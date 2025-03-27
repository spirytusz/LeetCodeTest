import json
import re
from typing import Dict

import requests

from template_generator.const.constants import S_PATTERN, S_LEET_CODE_GRAPHQL, HEADER_USER_AGENT


def auto_str(cls):
    def __str__(self):
        return '%s(%s)' % (
            type(self).__name__,
            ', '.join('%s=%s' % item for item in vars(self).items())
        )

    cls.__str__ = __str__
    return cls


@auto_str
class QuestionCode:
    codeName: str
    codeContent: str


@auto_str
class QuestionDetail:
    questionId: str
    questionTitle: str
    questionUrl: str
    questionContent: str
    questionCodes: Dict[str, QuestionCode]


def queryQuestionDetail(url):
    title_slug = re.findall(S_PATTERN, url)[0]
    session = requests.Session()
    headers = {
        'User-Agent': HEADER_USER_AGENT,
        'Connection': 'keep-alive',
        'Content-Type': 'application/json',
        'Referer': 'https://leetcode.com/problems/' + title_slug
    }
    params = {
        'operationName': "getQuestionDetail",
        'variables': {
            'titleSlug': title_slug
        },
        'query': '''
            query getQuestionDetail($titleSlug: String!) {
                question(titleSlug: $titleSlug) {
                    questionId
                    codeSnippets {
                        code
                        lang
                    }
                    questionFrontendId
                    questionTitle
                    questionTitleSlug
                    content
                    difficulty
                    stats
                    similarQuestions
                    categoryTitle
                    topicTags {
                        name
                        slug
                    }
                }
            }
        '''
    }
    json_data = json.dumps(params).encode('utf8')

    resp = session.post(S_LEET_CODE_GRAPHQL, data=json_data, headers=headers, timeout=10)
    content = resp.json()
    questionDetail = QuestionDetail()

    questionDetail.questionId = content['data']['question']['questionId']

    questionDetail.questionTitle = content['data']['question']['questionTitle']

    questionDetail.questionUrl = url

    questionCodes = {}
    questionDetail.questionCodes = questionCodes
    questionDetail.questionContent = content['data']['question']['content']
    for code in content['data']['question']['codeSnippets']:
        questionCode = QuestionCode()
        questionCode.codeName = code['lang']
        questionCode.codeContent = code['code']
        questionCodes[code['lang'].lower()] = questionCode

    return questionDetail
