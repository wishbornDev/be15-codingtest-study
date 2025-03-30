package com.wish.section02.stack;

import java.util.Stack;

public class Solution14 {
    public String solution(int n, int k, String[] cmd) {
        // 초기 행의 수 n, 초기 위치 k

        Stack<Node> ctrlZ = new Stack<>();
        Node[] nodes = new Node[n];

        for(int i = 0; i < n; i++) {
            nodes[i] = new Node();

            if(i == 0) continue;

            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i-1];
        }

        Node current = nodes[k];

        for(String command : cmd) {
            char operate = command.charAt(0);

            switch(operate) {
                case 'U':
                    int move = Integer.parseInt(command.split(" ")[1]);
                    current = current.movePrev(move);
                    break;
                case 'D':
                    move = Integer.parseInt(command.split(" ")[1]);
                    current = current.moveNext(move);
                    break;
                case 'C':
                    ctrlZ.push(current);
                    current = current.delete();
                    break;
                case 'Z' :
                    Node node = ctrlZ.pop();
                    node.restore();
                    break;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (Node node : nodes) {
            if(node.removed) {
                answer.append("X");
                continue;
            }
            answer.append("O");
        }

        return answer.toString();
    }

    class Node {
        Node prev;
        Node next;
        boolean removed;

        // U X
        public Node movePrev(int move) {
            Node node = this;
            for(int i = 0; i < move; i++) {
                node = node.prev;
            }
            return node;
        }

        // D X
        public Node moveNext(int move) {
            Node node = this;
            for(int i = 0; i < move; i++) {
                node = node.next;
            }
            return node;
        }

        // C
        public Node delete() {
            this.removed = true;
            Node prev = this.prev;
            Node next = this.next;

            if(prev != null) {
                prev.next = next;
            }

            if(next != null) {
                next.prev = prev;
                return next;
            }

            return prev;
        }

        // Z
        public void restore() {
            this.removed = false;
            Node prev = this.prev;
            Node next = this.next;

            if(prev != null) {
                prev.next = this;
            }

            if(next != null) {
                next.prev = this;
            }
        }
    }
}
