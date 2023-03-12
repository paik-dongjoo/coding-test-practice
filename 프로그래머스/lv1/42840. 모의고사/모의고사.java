import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int[] answers) {

        int[] person1 = {1, 2, 3, 4, 5};                    // 5
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};           // 8
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};     // 10
        int[] score = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i%5]) {
                score[0]++;
            }
            if (answers[i] == person2[i%8]) {
                score[1]++;
            }
            if (answers[i] == person3[i%10]) {
                score[2]++;
            }
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> scoreList = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) {
            if(maxScore == score[i]) scoreList.add(i+1);
        }

        int[] answer = new int[scoreList.size()];
        for(int i=0; i<scoreList.size(); i++){
            answer[i] = scoreList.get(i);
        }

        return answer;
    }
}