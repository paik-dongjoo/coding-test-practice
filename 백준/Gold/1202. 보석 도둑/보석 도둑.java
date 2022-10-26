
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Gem implements Comparable<Gem>{

        int m, v;   // m : 무게, v : 가격

        public Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }

        // Comparable 사용 : 보석의 무게를 오름차순 정렬
        @Override
        public int compareTo(Main.Gem o) {
            return this.m-o.m;
        }
    }

    static class GemCount implements Comparable<GemCount>{
        int n;

        public GemCount(int n) {
            this.n = n;
        }

        @Override
        public int compareTo(Main.GemCount o) {    // 가방에 들어간 보석은 내림차순으로 정렬 : 무거운 보석부터 넣기
            return o.n-this.n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 보석의 개수
        int K = Integer.parseInt(st.nextToken());   // 가방의 개수

        ArrayList<Gem> gem = new ArrayList<>();     // 보석(무게, 가격) 리스트
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());   // 보석 무게
            int v = Integer.parseInt(st.nextToken());   // 보석 가격
            gem.add(new Gem(m, v));
        }

        ArrayList<Integer> bag = new ArrayList<>();
        for(int i=0; i<K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(gem);  // 보석 오름차순 정렬
        Collections.sort(bag);  // 가방 오름차순 정렬

        long sum = 0;
        int idx = 0;
        PriorityQueue<GemCount> pq = new PriorityQueue<>();

        for(int i=0; i<K; i++) {
            for(int j=idx; j<N; j++) {
                if(gem.get(j).m <= bag.get(i)) {
                    idx++;
                    pq.add(new GemCount(gem.get(j).v));
                } else {
                    break;
                }
            }
            if(pq.isEmpty()) continue;
            sum+=pq.poll().n;
        }
        System.out.println(sum);
    }

}
