package com.style.algorithm.problemset;

import java.util.Stack;

/**
 * 20.有效的括号
 *
 * @author leon
 * @date 2021-12-30 22:31:53
 */
public class Solution20 {
    public static boolean isValid(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        Stack<Character> left = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c.equals('(') || c.equals('{') || c.equals('[')) {
                left.push(c);
            } else {
                if (!left.isEmpty() && leftOfChar(c).equals(left.peek())) {
                    left.pop();
                } else {
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    public static Character leftOfChar(Character character) {
        if (character == '}') {
            return '{';
        }

        if (character == ')') {
            return '(';
        }
        return '[';
    }

    public static void main(String[] args) {
        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }
}
