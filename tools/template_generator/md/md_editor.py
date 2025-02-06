import re
import os

MD_CODE_TEMPLATE = '''| {questionId} | [{questionTitle}]({questionUrl}) | [{solutionFileName}]({solutionFileRelativePath}) |'''


def editMd(mdFilePath: str, questionId: str, questionTitle: str, questionUrl: str, solutionFilePath):
    mdFile = open(mdFilePath, 'a')
    solutionFileName = solutionFilePath.split(os.sep)[-1]
    solutionFileRelativePath = re.findall(r'(src/.*)', solutionFilePath)[0]

    code = '\n' + MD_CODE_TEMPLATE.format(questionId=questionId, questionTitle=questionTitle, questionUrl=questionUrl,
                                          solutionFileName=solutionFileName,
                                          solutionFileRelativePath=solutionFileRelativePath)
    mdFile.write(code)
    mdFile.flush()

    mdFile.close()
