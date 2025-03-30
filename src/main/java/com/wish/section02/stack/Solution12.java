package com.wish.section02.stack;

import java.util.Stack;

class Solution12 {
    public int[] solution(int[] prices) {

        /* 브루트 포스 : 반복문을 통해 시점마다 이후의 가격을 비교 */

        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }     
        }
        
        /* stack 활용 */

        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  //

        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 가격이 떨어지면 이전 가격의 상승 기간 계산 --> for문 이후에 stack에 남은 값은 가격이 떨어지지 않은 경우
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;

    }
}