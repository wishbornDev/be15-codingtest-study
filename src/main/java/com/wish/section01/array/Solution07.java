package com.wish.section01.array;

import java.util.*;

class Solution07 {
    public int solution(String dirs) {
        Map<Character, int[]> location = new HashMap<>();
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
        
        // 음수 좌표 처리를 위해 좌표 변경
        int x = 5, y = 5;
        
        // 중복 경로 제거
        Set<String> result = new HashSet<>();
    
        for(int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int newX = x + offset[0];
            int newY = y + offset[1];
            
            if(!checkBound(newX, newY)) continue;
            
            // x,y -> nexX, newY 경로 OR newX,newY -> x, y 경로 중복 방지 
            result.add(x + "" + y + "" + newX + "" + newY);
            result.add(newX + "" + newY + "" + x + "" + y);
            
            x = newX;
            y = newY;
        } 
        
        return result.size() / 2;
    
    }
    
    public boolean checkBound (int x, int y) {
        return 0 <= x && x < 11 && 0 <= y && y < 11;
    }
}