package com.wish.section02.stack;

import java.util.*;

class Solution10 {
    public int solution(String s) {
        
        // 문자열 구분용 
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        int length = s.length();
        // 한 칸 씩 문자열의 길이만큼 왼쪽으로 움직인다는 것은 주어진 문자열이 반복된다는 의미
        s += s; 
        
        int answer = 0;
        
        A:for(int i = 0; i < length; i++) {
            Stack<Character> stack = new Stack<>(); 
            for(int j = i; j < i+length; j++) {
                char c = s.charAt(j);
                if(!map.containsKey(c)) {
                    stack.push(c);
                } else if(stack.isEmpty() || !stack.pop().equals(map.get(c))){
                    // stack이 비어있거나 닫힌 괄호와 맞는 열린 괄호가 없을 때 
                    continue A;
                } 
            }  
            if(stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}