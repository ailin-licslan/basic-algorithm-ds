package com.licslan.LeetCode;

import java.util.Stack;

/**
 * LeetCode 专栏  ♥  NO20
 *
 * @author LICSLAN
 * */
public class IsValidParentheses {

    /**
     * NO20 有效的括号 ♥  Stack
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * TODO FINISHED!!!
     * -------
     * ({[   |    ]})
     *-------
     * 压入栈左括号
     * 栈顶元素反映了在嵌套的层次关系中 最近的需要匹配的元素
     * */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //遍历左侧的括号
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            else {
            //对比右侧的括号  判断当前栈顶是否有元素  就是判断栈是否为空
                if(stack.isEmpty()) return false;
                //栈顶取出一个元素
                char pop = stack.pop();
                if (c==')' && pop!='(') return false;
                if (c=='}' && pop!='{') return false;
                if (c==']' && pop!='[') return false;
            }
        }
        //判断所有元素都取完了 看栈里面的括号和右侧符号是不是都能匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new IsValidParentheses().isValid("{([[[]]])}"));
    }

}
