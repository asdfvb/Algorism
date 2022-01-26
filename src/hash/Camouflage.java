package hash;

/*
* 문제 설명
    스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

    예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

    - 종류: 이름
    얼굴: 동그란 안경, 검정 선글라스
    상의: 파란색 티셔츠
    하의: 청바지
    겉옷: 긴 코트

    스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

* 제한사항
    clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
    스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
    같은 이름을 가진 의상은 존재하지 않습니다.
    clothes의 모든 원소는 문자열로 이루어져 있습니다.
    모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
    스파이는 하루에 최소 한 개의 의상은 입습니다.
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Camouflage {
    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();
        System.out.println("soultion : " + camouflage.greaterSoultion(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    //나의 풀이법
    public int mySolution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> clothMap = new HashMap<String,Integer>();
        for(String[] cloth : clothes){
            //키들의 개수를 해쉬에 담는다.
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1],0)+1);

        }

        //키들의 곱셈을 한다.(경우의 수를 구하기 위함)
        //곱셈에 +1을 붙이는건 해당 의상만 입는 경우를 추가하기 위함. (예) headgear1개만 착용하는 경우의 수가 발생 가능
        for(String key : clothMap.keySet()){
            answer *= clothMap.get(key)+1;
        }

        // -1을 하는 이유는 아무 의상도 입지 않는 경우는 배제하기 위함.
        return answer-1;
    }

    //stream을 이용한 풀이법(groupingby, mapping 사용법)에 대해 배움.
    public int greaterSoultion(String [][] clothes){
        int answer = 0;

        System.out.println(Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], counting())));

        answer = Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;

        return answer;
    }
}
