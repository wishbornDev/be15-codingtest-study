package com.wish.section05.tree;

import java.util.*;

class Solution27 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int[] answer = new int[enroll.length];
        Map<String, String> en_map = new HashMap<>();
        
        // 판매자 - 추천인
        for(int i = 0; i < enroll.length; i++) {
            en_map.put(enroll[i], referral[i]);
        }
        
        // 판매자 - 수익
        Map<String, Integer> rev_total = new HashMap<>();
        
        for (int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int revenue = amount[i] * 100;  // 개당 100원
            
            while (revenue > 0 && !cur.equals("-")) {
                rev_total.put(cur, 
                              rev_total.getOrDefault(cur, 0) + revenue - (revenue / 10));
                cur = en_map.get(cur);
                
                revenue /= 10;
            }    
        }
        
        
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = rev_total.getOrDefault(enroll[i], 0);
        }   
        
        return answer;
    }
}