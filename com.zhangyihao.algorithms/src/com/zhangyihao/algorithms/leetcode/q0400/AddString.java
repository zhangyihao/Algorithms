package com.zhangyihao.algorithms.leetcode.q0400;

/**
 * 415 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回
 *
 * @author zhangyihao
 * @date 2021/11/28
 */
public class AddString {

    public static void main(String[] args) {
        AddString t = new AddString();
        System.out.println(t.addStrings("0", "0"));
        System.out.println(t.addStrings("1", "9"));
        System.out.println(t.addStrings("11", "123"));
        System.out.println(t.addStrings("12456", "77"));
    }

    public String addStrings(String num1, String num2) {
        int index1 = num1 != null ? num1.length() - 1 : -1;
        int index2 = num2 != null ? num2.length() - 1 : -1;

        int carry = 0;
        int addNum1, addNum2, addResult;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            addNum1 = index1 >= 0 ? ((int)num1.charAt(index1) - 48) : 0;
            addNum2 = index2 >= 0 ? ((int)num2.charAt(index2) - 48) : 0;

            addResult = addNum1 + addNum2 + carry;

            carry = addResult / 10;
            sb.append(addResult % 10);

            index1--;
            index2--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
