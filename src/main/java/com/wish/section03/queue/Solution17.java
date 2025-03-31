package com.wish.section03.queue;

import java.util.*;

class Solution17 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue<String> cQue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cQue2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> gQue = new LinkedList<>(Arrays.asList(goal));
        
        while(!gQue.isEmpty()) {
            String str = gQue.poll();
            
            if(!cQue1.isEmpty() && str.equals(cQue1.peek())) {
                cQue1.poll();
            }
            
            else if(!cQue2.isEmpty() && str.equals(cQue2.peek())) {
                cQue2.poll();
            }
            
            else {
                return "No";
            }         
        }    
        return "Yes";
    }
}