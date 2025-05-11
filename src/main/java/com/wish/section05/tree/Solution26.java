package com.wish.section05.tree;

class Solution26
{
    public int solution(int n, int a, int b)
    {
        int answer;
        
        for (answer = 0; a != b; answer++) {    // a == b - 1,  1라운드 
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        
         return answer;
    }  
       
}