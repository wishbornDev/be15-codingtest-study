package com.wish.section01.array;

import java.util.*;

class Solution04 {
    public int[] solution(int[] answers) {
        // 패턴 분석
        int[][] numbers = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        // 점수 저장 
        int[] scores = new int[3];
        
        // 패턴 확인
        for(int i=0; i < answers.length; i++){
            for(int j = 0; j < numbers.length; j++) {
                // 
                if(answers[i] == numbers[j][i % numbers[j].length]) scores[j]++;
            }
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == maxScore) {
                list.add(i+1);
            }
        }
        
        int[] result = new int[list.size()];
        
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}