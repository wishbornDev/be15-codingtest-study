package com.wish.section03.queue;

import java.util.*;

class Solution16 {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //List<Integer> answer = new ArrayList<>();
       
        Queue<Integer> answer = new ArrayDeque<>();
        
        int n = progresses.length;
        
        // 기능 별 필요한 작업일 수
        int[] days = new int[n];
        
        for(int i = 0; i < n; i++) {
            days[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        // 기준 날짜
        int flag = days[0]; 
        // 배포 기능 수
        int count = 0;
        
        for(int i = 0; i < n ; i++) {
            if(days[i] <= flag) count++;
            else {
                answer.add(count);
                count = 1;
                flag = days[i];
            }
        }            
        
        answer.add(count);
                       
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}