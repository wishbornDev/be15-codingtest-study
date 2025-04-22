package com.wish.section04.hash;

import java.util.*;

class Solution23 {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length]; // 결과 통보 횟수
        // 신고 당한 유저, 신고 유저들 
        Map<String, HashSet<String>> rpUsers = new HashMap<>(); 
        // 유저 ID, 고유번호 부여
        Map<String, Integer> id_idx = new HashMap<>();
        
        // 초기화
        for(int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            rpUsers.put(id, new HashSet<>());
            id_idx.put(id, i);
        }
        
        for(String s : report) {
            String[] sArr = s.split(" ");
            String from = sArr[0];
            String to = sArr[1];
            rpUsers.get(to).add(from);  // 신고한 유저 추가
        }
        
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = rpUsers.get(id_list[i]);
            if(send.size() >= k) {
                for(String id : send) {
                    answer[id_idx.get(id)]++;
                }
            }
        }
        
        return answer;
    
    }
}