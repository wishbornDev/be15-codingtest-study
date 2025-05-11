package com.wish.section06.set;

import java.util.*;

class Solution31 {
    public int solution(int[] nums) {
        // 모든 포켓몬 nums 
        // 최댓값 nums / 2
        int max = nums.length / 2;
        
        // 최대한 다양한 포켓몬 갖기 
        // 중복 제거를 위한 set 사용
        Set<Integer> poketball = new HashSet<>();
        
        for(int n : nums) {
            poketball.add(n);   // 포켓몬 번호로 구분
        }

        return Math.min(max, poketball.size());
        
    }    
}