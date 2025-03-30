package com.wish.section01.array;

class Solution05 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬의 곱 arr1의 0번째 인덱스 길이와 arr2의 길이가 같을 때
        // arr1 * arr2[0]
        int row1 = arr1.length;
        int column1 = arr1[0].length;
        int row2 = arr2.length;
        int column2 = arr2[0].length;
        
        int result[][] = new int[row1][column2];
        
        for(int i = 0; i < row1; i++) {
            for(int j = 0; j < column2; j++) {
                for(int k = 0; k < column1; k++){
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return result;
    }
}