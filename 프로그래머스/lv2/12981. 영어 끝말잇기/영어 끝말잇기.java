import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> hs = new HashSet<>();
        hs.add(words[0]);
        int count = 1;
        
        for (int i = 1; i < words.length; i++) {
            char last = words[i-1].charAt(words[i-1].length()-1);
            char first = words[i].charAt(0);
            if(!hs.contains(words[i]) && last==first){
                hs.add(words[i]);
                count++;
            } else {
                break;
            }
        }
        if(count == words.length){
            return new int[]{0, 0};
        } else {
            return new int[]{(count%n)+1, (count/n)+1};
        }
        
    }
}