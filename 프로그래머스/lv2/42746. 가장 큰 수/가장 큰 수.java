import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberString = new String[numbers.length];

        // 배열의 원소들이 0일 경우 0 으로 리턴하기 위해 
        boolean cheked = true;
        for (int i = 0; i < numberString.length; i++) {
            numberString[i] = String.valueOf(numbers[i]);
            if (numbers[i] != 0) {
                cheked = false;
            }
        }

        // 사전 순 비교를 통해 뒤에 있는 객체 확인이 가능하도록
        Arrays.sort(numberString, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                return (n2 + n1).compareTo(n1 + n2);
            }
        });

        for (int i = 0; i < numberString.length; i++)
            answer += numberString[i];
        if (cheked) {
            answer = "0";
        }

        return answer;
    }
}