package com.wish.section02.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution13 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // 없어진 인형의 수


        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i]-1]!= 0) {
                    list.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;   // 인형을 빼냄
                    break;
                }
            }
        }


        int size = list.size();

        for(int k = 0; k < list.size(); k++) {
            if( k != (list.size() - 1)) {
                if(list.get(k) == list.get(k+1)) {
                    list.remove(k);
                    list.remove(k);
                    answer++;
                    size -= 2;
                    k = -1;
                }
            }
        }

        // return answer * 2;




        /* 인형이 쌓여있는 각각의 열을 하나의 스택으로 생각 */
        Stack<Integer>[] stacks = new Stack[board.length];
        for(int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        // 각 열의 인형을 stacks에 추가  -- 아래에서 부터 추가하므로 역순
        for(int i = board.length-1; i >= 0; i--) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] > 0) stacks[j].push(board[i][j]);
            }
        }

        /* 인형 담기 */
        Stack<Integer> stack = new Stack<>();
        for(int m : moves) {
            if(!stacks[m-1].isEmpty()) {
                int toy = stacks[m-1].pop();    // 기계에서 인형 빼기
                if(!stack.isEmpty() && stack.peek() == toy) {
                    stack.pop();
                    answer+=2;
                } else {
                    stack.push(toy);    // 맨 위에 담겨있는 인형과 같지 않으면 push
                }
            }
        }
        return answer;
    }
}
