package com.wish.section03.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution15 {
    /* BOJ 1158 */
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        while(!queue.isEmpty()) {

            for(int i = 1; i <= K - 1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll());

            if(!queue.isEmpty()) sb.append(", ");

        }

        sb.append(">");
        System.out.println(sb.toString());
    }

    private int solution(int N, int K) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= N ; i++) {
            deque.addLast(i);
        }

        while(deque.size() > 1) {
            for(int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();  // K번째 삭제
        }

        return deque.pollFirst();
    }
}
