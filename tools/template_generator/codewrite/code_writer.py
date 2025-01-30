from template_generator.const.constants import CODE_TYPE_JAVA

def writeCode(path: str, fileName: str, codeType: str, content: str):
    if codeType.lower() != CODE_TYPE_JAVA:
        raise Exception('Not support codeType {codeType}'.format(codeType=codeType))

    file_path = path + '/' + fileName + '.java'
    f = open(file_path, 'w+')
    f.write(content)
    f.flush()
    f.close()