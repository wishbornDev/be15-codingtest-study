package com.wish.section01.array;

import java.util.HashSet;

public class Solution03 {
    public int[] solution(int[] numbers) {

        // 1. 중복을 제거하기 위한 hashSet
        HashSet<Integer> set = new HashSet<>();

        // 2. 모든 경우의 수의 합
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 오름차순 정렬 후 int[]에 담은 후 return
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
