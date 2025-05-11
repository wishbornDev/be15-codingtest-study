package com.wish.section06.set;

import java.util.*;

class Solution32 {
    public int[] solution(int n, String[] words) {
        
        // 끝말잇기 탈락 하는 경우
        // 1. 중복된 단어를 말할 경우
        // 2. 앞 단어의 끝말과 이어지지 않을 경우
        
        // 사용된 언어를 중복 없이 저장
        Set<String> used = new HashSet<>();
        used.add(words[0]);
        char last = words[0].charAt(words[0].length() - 1);
        
        for (int i = 1; i < words.length; i++) {
             // 중복 되거나 앞 단어의 끝말과 다를 경우
            if (used.contains(words[i]) || words[i].charAt(0) != last) {
                // index 번호는 사람의 번호 - 1 이므로  +1 
                return new int[]{(i % n) + 1, (i / n) + 1};
            } 
            
            // 통과된 단어 추가
            used.add(words[i]);
            // 마지막 글자 변경
            last = words[i].charAt(words[i].length() - 1);
        }
        
        // 모두 통과
        return new int[]{0, 0};
        
    }
}