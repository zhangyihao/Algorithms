package com.zhangyihao.algorithms.leetcode.q0015;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangyihao
 * @date 2022/3/7
 */
public class ValidQuot20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch, topCh;
        for (int i = 0, size = s.length(); i < size; i++) {
            ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                // 开始符号，入栈
                stack.push(ch);
            } else if (stack.isEmpty()) {
                // 如果我空，则不匹配
                return false;
            } else {
                topCh = stack.peek();
                // 比较栈顶，匹配则出栈。不匹配，则字符串无效
                if ((topCh == '(' && ch == ')') || (topCh == '[' && ch == ']') || (topCh == '{' && ch == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // 如果栈为空则字符串有效
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidQuot20 t = new ValidQuot20();
        System.out.println(t.isValid("()"));
        System.out.println(t.isValid("()[]{}"));
        System.out.println(t.isValid("(]"));
        System.out.println(t.isValid("([)]"));
        System.out.println(t.isValid("{[]}"));
        System.out.println(t.isValid("({{{{}}}))"));
        System.out.println(t.isValid("(])"));
    }

}
