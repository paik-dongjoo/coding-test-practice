import java.util.HashMap;

class Solution {
    public int solution(int[] nums){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], nums[i]);
        }

        int answer = 0;
        int arrSize = nums.length/2;
        int cntSize = hm.size();

        if(arrSize >= cntSize){
            answer = cntSize;
        } else if (cntSize > arrSize){
            answer = arrSize;
        }

        return answer;
    }
}