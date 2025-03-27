import sys
import os

sys.path.append(os.path.dirname(os.path.abspath(__file__.replace('main.py', ''))))

import json
import re

from template_generator.codgen.code_generator_main import genCode
from template_generator.network.fetcher import QuestionDetail, queryQuestionDetail
from template_generator.codewrite.code_writer import writeCode
from template_generator.md.md_editor import editMd

if __name__ == '__main__':
    envJsonFile = open(__file__.replace('main.py', 'env.json'))
    args = json.loads(envJsonFile.read())
    envJsonFile.close()

    for i in range(1, len(sys.argv), 2):
        args[sys.argv[i]] = sys.argv[i + 1]

    questionDetail: QuestionDetail = queryQuestionDetail(url=args['url'])
    generatedCode = genCode(url=questionDetail.questionUrl, questionId=questionDetail.questionId,
                            questionTitle=questionDetail.questionTitle, questionContent=questionDetail.questionContent,
                            codeType=args['code'],
                            code=questionDetail.questionCodes[args['code'].lower()].codeContent)

    codeFilePath = writeCode(path=args['generate_code_path'],
                             fileName=questionDetail.questionTitle.title().replace(' ', ''),
                             codeType=args['code'].lower(), content=generatedCode)

    repoPath = __file__.replace(re.findall(r'LeetCodeTest/(.*)', __file__)[0], '')
    editMd(mdFilePath=repoPath + 'README.md', questionId=questionDetail.questionId, questionTitle=questionDetail.questionTitle,
           questionUrl=questionDetail.questionUrl, solutionFilePath=codeFilePath)
