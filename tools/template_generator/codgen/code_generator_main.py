from template_generator.codgen.java.code_generator_java import genJavaCode
from template_generator.const.constants import CODE_TYPE_JAVA


def genCode(url: str, questionId: str, questionTitle: str, questionContent: str, codeType: str, code: str):
    if codeType.lower() == CODE_TYPE_JAVA:
        return genJavaCode(url, questionId, questionTitle, questionContent, codeType, code)
    else:
        raise Exception('Not support codeType {codeType}'.format(codeType=codeType))
