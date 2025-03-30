package com.wish.section02.stack;

import java.util.*;
import java.lang.*;

class Solution09 {
    public static void main(int num) {
        // mod 저장
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 2);
            num = num / 2;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}

