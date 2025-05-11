package com.wish.section06.set;

import java.util.*;

class Solution33 {
    
    private static int[] parents;
    
    public int solution(int n, int[][] costs) {
        // 최소 비용으로 모든 섬을 연결한다. 
        
        int answer = 0;
        
        // 두 다리를 연결할 때 비용이 적은 순으로 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        // 루트 노드 
        parents = new int[n];
        
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
            // 두 섬을 연결하면 비용 추가
            if(union(costs[i][0], costs[i][1])) {
                answer += costs[i][2];
            }
        }
        
        return answer;
        
    }
    
    private static boolean union(int a, int b) { // 두 섬의 번호 전달
        // 두 섬이 연결된 root 섬 찾기
        int root1 = find(a);
        int root2 = find(b); 
        
        if(root1 == root2) return false; //  두 섬이 연결된 섬이 같으면 다시 연결하지 않음
        
        if(root1 > root2) {
            parents[root2] = root1;     // root2 섬의 root를 root1으로 연결
        } else {
            parents[root1] = root2;     // root1 섬의 root를 root2로 연결
        }
        
         return true;   // 비용 처리를 위한 flag
        
    }
    
    private static int find(int a) {  // 해당 섬이 연결된 섬 찾기
        
        if(a == parents[a]) {
            return a;   // 해당 섬이 루트 섬일 때
        }
        
        return parents[a] = find(parents[a]); // 루트 찾기 
        
    }
    
    
    
}