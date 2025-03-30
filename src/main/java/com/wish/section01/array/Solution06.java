package com.wish.section01.array;

import java.util.*;

class Solution06 {
    public int[] solution(int N, int[] stages) {
        // stages[i] 값이 N+1이면 최종 스테이지까지 통과
        int[] challengers = new int[N+2]; // 자연수만 값으로 가지며, 최종스테이지 통과한 사람까지 
        // 스테이지별 도전자 수 
        for(int stage : stages) {
            challengers[stage] += 1;
        }
        
        List<Stage> stageList = new ArrayList<>();
        
        int players = stages.length;
        for(int i = 1; i <= N; i++) {
            double fail = (double) challengers[i] / players;
            players -= challengers[i];
            
            Stage s = new Stage(i, fail);
            stageList.add(s);
        }
        
        Collections.sort(stageList, Collections.reverseOrder());
        
        int[] result = new int[N];
        for(int i = 0; i < N; i ++) {
            result[i] = stageList.get(i).stage;
        }
        return result;
    }
    
    static class Stage implements Comparable<Stage> {
        int stage;
        double fail;
        
        Stage(int stage, double fail) {
            this.stage = stage;
            this.fail = fail;
        }
        
        @Override
        public int compareTo(Stage s) {
            if(this.fail < s.fail) return -1;
            else if(this.fail > s.fail) return 1;
            else return 0;
        }
    }
}