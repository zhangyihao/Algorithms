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
                stack.push(ch);ªª
            } else if (stack.isEmpty()) {
                return false;
            } else {
                topCh = stack.peek();
                if ((topCh == '(' && ch == ')') || (topCh == '[' && ch == ']') || (topCh == '{' && ch == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidQuot20 t = new ValidQuot20();
//        System.out.println(t.isValid("()"));
//        System.out.println(t.isValid("()[]{}"));
//        System.out.println(t.isValid("(]"));
//        System.out.println(t.isValid("([)]"));
//        System.out.println(t.isValid("{[]}"));
//        System.out.println(t.isValid("({{{{}}}))"));
        System.out.println(t.isValid("(])"));
    }

}
