package com.wish.section04.hash;

import java.util.HashMap;
import java.util.Map;

class Solution19 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>(); // 동명이인이 있을 수 있음

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1); // default value = 1, 동명이인 발견하면 +1
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1); // 완주자이름을 key로 value -1
        }

        for (String s : map.keySet()) {
            if (map.get(s) > 0) { // 명단에 남은 사람은 미완주자
                answer = s;
                break;
            }
        }

        return answer;
    }
}
