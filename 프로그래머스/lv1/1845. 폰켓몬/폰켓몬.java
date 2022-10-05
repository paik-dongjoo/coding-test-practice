import java.util.HashMap;

class Solution {
    public int solution(int[] nums){
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], nums[i]);
        }
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