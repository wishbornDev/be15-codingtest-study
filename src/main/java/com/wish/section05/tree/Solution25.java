package com.wish.section05.tree;

public class Solution25 {
    public static String[] solution(int[] node) {
        String[] result = new String[3];
        result[0] = preOrder(node, 0).trim();
        result[1] = inOrder(node, 0).trim();
        result[2] = postOrder(node, 0).trim();

        return result;
    }

    private static String preOrder(int[] node, int idx) {

        if (idx >= node.length) {
            return "";
        }

        return node[idx] + " " + preOrder(node, 2 * idx + 1) + preOrder(node, 2 * idx + 2);

    }

    private static String inOrder(int[] node, int idx) {

        if(idx >= node.length) {
            return "";
        }

        return inOrder(node, 2 * idx + 1) + node[idx] + " " + inOrder(node, 2 * idx * 2);

    }

    private static String postOrder(int[] node, int idx) {

        if(idx >= node.length) {
            return "";
        }

        return postOrder(node, 2 * idx + 1) + postOrder(node, 2 * idx + 2) + node[idx] + " ";

    }

}
