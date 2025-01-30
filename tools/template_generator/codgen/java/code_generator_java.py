import re

CODE_TEMPLATE = '''
{imports}/**
 * <a href="{url}">{questionId}. {questionTitle}</a>
 * 
{questionContentFormatted}
 */
public class {className} {{
{dataStructureDeclare}
{solutionMethodDeclare}
}}
'''

TREE_NODE_DECLARE = '''
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
'''

LIST_NODE_DECLARE = '''
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
'''

IMPORTS_LIST = '''import java_lang.util.List;'''
IMPORTS_MAP = '''import java_lang.util.Map;'''

INDENT = ' ' * 4

SUPPRESS_DECLARE = '@SuppressWarnings("ClassEscapesDefinedScope")'


def genJavaCode(url: str, questionId: str, questionTitle: str, questionContent: str, codeType: str, code: str):
    imports = ''
    if re.match('List<.*>', code):
        imports += '\n' + IMPORTS_LIST
    if re.match('Map<.*,.*>', code) or re.match('Map<.*,.*>', code):
        imports += '\n' + IMPORTS_MAP

    questionContentFormatted = ''
    for line in questionContent.splitlines():
        questionContentFormatted += ' * {line}\n'.format(line=line)

    className = questionTitle.title().replace(' ', '')

    dataStructureDeclare = ''
    if 'public class TreeNode' in code:
        dataStructureDeclare += '\n' + TREE_NODE_DECLARE
    if 'public class ListNode' in code:
        dataStructureDeclare += '\n' + LIST_NODE_DECLARE

    solutionMethodDeclare = '\n' + INDENT + re.findall('(public .* .*\(.*\) {)', code)[0].replace('public', 'public static') + '\n' + INDENT + '}'
    if len(dataStructureDeclare) != 0:
        solutionMethodDeclare = '\n' + INDENT + SUPPRESS_DECLARE + solutionMethodDeclare

    return CODE_TEMPLATE.format(imports=imports, url=url, questionId=questionId, questionTitle=questionTitle,
                                questionContentFormatted=questionContentFormatted, className=className,
                                dataStructureDeclare=dataStructureDeclare,
                                solutionMethodDeclare=solutionMethodDeclare)
