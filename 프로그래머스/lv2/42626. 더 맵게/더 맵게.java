import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }

        while(heap.peek() < K){
            int first = heap.poll();
            int second = heap.poll()*2;

            heap.add(first + second);
            answer++;

            if(heap.peek() >= K) {
                break;
            }

            if(heap.peek() < K && heap.size() == 1){
                answer = -1;
                break;
            }
        }

        return answer;
    }
}