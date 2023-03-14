import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder stringBuilder = new StringBuilder();

    // N 개 중에서 M 개를 고르는 경우
    // 같은 수를 여러번 골라도 됨
    // 중복을 허용해서 순서가 있도록 나열
    static int N, M;
    static int[] selected = new int[M + 1];

    static void input() {
        MyReader myReader = new MyReader();
        N = myReader.nextInt();
        M = myReader.nextInt();
        selected = new int[M + 1];
    }

    // Recurrence Function (재귀 함수)
    // M 개를 전부 고른 경우 : 조건에 맞는 한 가지 경우의 수를 탐색 완료
    // M 개를 전부 고르지 않은 경우 : k 번째부터 M 번째까지의 원소를 고르는 모든 경우를 탐색
    static void rec_func(int k) {

        if (k == M + 1) {
            // selected 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++) {
                stringBuilder.append(selected[i]).append(' ');
            }
            stringBuilder.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                // k 번째 위치에 i 가 올 수 있으면
                selected[k] = i;

                // k+1 부터 M 까지 채워주는 함수를 호출
                rec_func(k + 1);
                // 재귀함수 호출이 종료되면 해당 자리는 통상적으로 0 으로 변경
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {

        input();

        // 1 번째 원소부터 M 번째 원소까지 조건에 맞는 모든 경우의수 탐색
        rec_func(1);
        System.out.println(stringBuilder.toString());
    }

    static class MyReader {

        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public MyReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyReader(String str) throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}