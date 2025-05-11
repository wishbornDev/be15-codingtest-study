package com.wish.section05.tree;

import java.util.*;

class Solution28 {
     // 양을 최대한 많이 루트까지 데려오기 
     // 이진 트리를 왔다갔다 하면서 양을 모두 모아야 함
     // 너비 탐색 -> 깊이 탐색
    
    // 노드, 연결된 노드들 
    private Map<Integer, ArrayList<Integer>> tree = new HashMap<>();
    // 이미 처리한 방문 
    private Set<Integer> set = new HashSet<>();
    // 양-늑대의 총 수 
    private int[] info;
    private int size;   
    private int answer = 1; // 루트에 한 마리 존재 
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        size = info.length; 
        
        for(int[] e : edges) {
            if(!tree.containsKey(e[0])) {
                tree.put(e[0], new ArrayList<>());
            }
            tree.get(e[0]).add(e[1]);
        }
        
        visit(1, 1, 0); // root node 방문
        
        return this.answer;
    }
    
    // visited : 방문한 노드 
    public void visit(int visited, int sheep, int wolf) {
        
        if(sheep - wolf == 0) return;   // 늑대가 양을 다 잡아먹었다.
        else {
            answer = Math.max(sheep, answer);   // 전달된 양과 현재 양 마리 비교
        }
        
        for(int i = 0; i < size; i++) {
            // 비트 << : a 를 b 만큼 비트이동 
            // 비트 & : 두 정수를 한 비트씩 비교하면서 양쪽 비트가 모두 1이면 결과도 1이고 나머지는 0을 반환
            
            // 현재 방문한 상태이고, 다음에 방문 가능한 노드가 존재 
            // i 번째 숫자를 1로 만든 숫자가 이미 방문한 노드인지 확인
            // ex) 1 << 3, 0001 -> 1000
            if(((1 << i) & visited) != 0 && tree.containsKey(i)) {
                ArrayList<Integer> nodes = tree.get(i); // 연결 가능한 노드 가져오기
                for(int j = 0; j < nodes.size(); j++) {
                    int next = nodes.get(j);   // 다음 노드 방문 확인하기     
                    // 비트 | : 두 정수를 한 비트씩 비교하면서 양쪽 비트 중 하나라도 1이면 결과가 1이고 나머지는 0을 반환
                    // 두 노드 중 한 쪽에서라도 방문했는지 확인
                    if((visited & (1 << next)) == 0) {
                        //OR(|) 연산은 1이면 무조건 1이라서 기존 값 유지하면서 새 비트만 추가
                        int v = visited | (1 << next); // 다음 노드 방문
                        
                        if(set.contains(v)) continue; // 이전에 처리했으면 통과
                        
                        set.add(v); // 새 방문 상태 추가 
                        
                        // 다음 노드가 0이면 양 추가
                        if(info[next] == 0) visit(v, sheep + 1, wolf);
                        // 아니면 늑대 추가 
                        else visit(v, sheep, wolf + 1);
                            
                    }
                    
                }         
            }
            
        }
    }
}