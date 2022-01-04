package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
* 해시 Algorism
*
* - 문제 설명
*   수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
*   마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
*
* - 제한 사항항
*   마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
*   completion의 길이는 participant의 길이보다 1 작습니다.
*   참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
*   참가자 중에는 동명이인이 있을 수 있습니다.
* */

public class CompletePlayer {
    public static void main(String[] args) {
        String soultion = soultion(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});

        System.out.println(">> result : " + soultion);
    }

    public static String soultion(String[] participant, String[] completion){
        String answer = "";
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(String player : participant){
            map.put(player, map.getOrDefault(player, 0)+1);
        }

        for(String player : completion){
            map.put(player, map.get(player)-1);
        }

        answer = map.keySet().stream().filter(x -> {
            return map.get(x) != 0;
        }).collect(Collectors.joining(",")).toString();

        return answer;
    }

}
