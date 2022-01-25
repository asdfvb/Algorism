package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 문제 설명
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 * 같은 전화번호가 중복해서 들어있지 않습니다.
 *
 */

//다량의 문자를 비교하는경우는 해시가 가장 빠른 기법중 하나이다.
//equals or startwith는 그냥 노가다 문자열 비교이다. (해시 기법 x)
public class PhoneBook {
    public static void main(String[] args) {
        boolean bool = soultion(new String[]{"119", "97674223", "1195524421"});
        System.out.println("result : " + bool);
    }

    private static boolean soultion(String[] phone_book) {

        HashMap<String,Object> map = new HashMap<String,Object>();

        //해시에 담기
        for(String number : phone_book)
            map.put(number, 0);

        for(int i = 0; i<phone_book.length; i++){
            for (int j = 1; j <= phone_book[i].length(); j++) {
                System.out.println(i + " - " + j + " : " + phone_book[i].substring(0, j));
                System.out.println(">> : " + phone_book[i].hashCode());
                if (map.containsKey(phone_book[i].substring(0, j)) && phone_book[i].hashCode() != phone_book[i].substring(0, j).hashCode()) {
                    return false;
                }
            }
        }

        return true;
    }
}
