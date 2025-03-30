package com.wish.section02.stack;

import java.util.*;

class Solution08 {
    boolean solution(String s) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] cArr = s.toCharArray();
        
        for(char c : cArr){
            if(c == '(') {
                stack.push(c);
            } else if(stack.isEmpty() || stack.pop() == c) return false; 
        }

        return stack.isEmpty();
    }
}