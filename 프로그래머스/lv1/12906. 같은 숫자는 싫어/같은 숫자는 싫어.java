import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int isCheck = 10;
        for (int num : arr) {
            if(num != isCheck){
                list.add(num);
                isCheck = num;
            }
        }

        int[] answer = new int[list.size()];
        int answerI=0;
        
        for (int num : list){
            answer[answerI] = num;
            answerI++;
        }

        return answer;
    }
}