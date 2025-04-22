package com.wish.section04.hash;

import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
class Solution22 {
   public int[] solution(String[] genres, int[] plays) {

        //장르 카운트
        Map<String, Integer> genreCount = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genreCount.put(
                genres[i], 
                genreCount.getOrDefault(genres[i], 0) + plays[i]
            );
        }

        //각 장르별 플레이
        Map<String, Map<Integer, Integer>> playCount = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            playCount.computeIfAbsent(
                genres[i], k -> new HashMap<>()
            ).put(i, plays[i]);
        }

        List<String> genresOrderByDesc = genreCount
                        .keySet()
                        .stream()
                        .sorted(
                            Comparator.comparing(s -> genreCount.get(s))
                                      .reversed()
                        )
                        .collect(Collectors.toList());
       
        List<Integer> answer = new ArrayList<>();

        for(String genre: genresOrderByDesc){
            Map<Integer, Integer> idAndPlays = playCount.get(genre);
            List<Integer> keys = idAndPlays
                    .keySet()
                    .stream()
                    .sorted(Comparator.comparing(
                            (Integer i) -> idAndPlays.get(i))
                            .reversed()
                            .thenComparing(i -> i)
                    )
                    .limit(2)
                    .collect(Collectors.toList());

            answer.addAll(keys);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
