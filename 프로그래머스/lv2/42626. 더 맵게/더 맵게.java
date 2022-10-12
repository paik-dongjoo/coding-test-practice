import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for(int item : scoville){
            heap.add(item);
        }

        while(heap.peek() < K && heap.size() > 1){

            heap.add(heap.poll() + (heap.poll()*2));
            answer++;
            
        }

        if(heap.peek() < K){
            answer = -1;
        }

        return answer;
    }
}