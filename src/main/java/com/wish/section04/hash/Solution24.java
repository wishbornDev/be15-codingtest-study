package com.wish.section04.hash;

import java.util.*;
import java.util.stream.*;

class Solution24 {
    
    // 가장 많은 조합 찾기 
    
    static Map<String, Integer> orderCnt;
    static int max;
    static List<String> results;
    
    public String[] solution(String[] orders, int[] course) {
        
        results = new ArrayList<>();
        for(int coSize : course) {  // 필요한 세트 메뉴 조합 개수 만큼
            
            max = 0;
            orderCnt = new HashMap<>();
            
            for(String s : orders) {
                combine(s, "", 0, coSize);
            }
            
            if (max < 2 ) continue; // 최소 2명 이상
            
            orderCnt.entrySet().stream().filter(e -> e.getValue() == max) 
                .forEach(e -> results.add(e.getKey()));
        }
        
        Collections.sort(results); // 오름차순
        return results.toArray(new String[0]);  // String 배열로 
    }
    
    public void combine(String comb, String now, int idx, int coSize) {
        
        if(now.length() == coSize) {
            String sortedComb = sort(now);
            orderCnt.put(sortedComb, orderCnt.getOrDefault(sortedComb, 0) +1);  // 해당 조합 주문
            max = Math.max(max, orderCnt.get(sortedComb));
            return;
        }
        
        for(int i = idx; i < comb.length(); i++) {
            combine(comb, now+comb.charAt(i), i+1, coSize);
        }
        
    }
    
    public String sort(String comb) {
        return Arrays.stream(comb.split("")).sorted().collect(Collectors.joining());
    }
    
    
}