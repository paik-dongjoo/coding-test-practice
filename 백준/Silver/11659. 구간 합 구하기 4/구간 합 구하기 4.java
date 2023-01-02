import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(stringTokenizer.nextToken());
        int M = Integer.valueOf(stringTokenizer.nextToken());

        long[] sumArr = new long[N+1];
        stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.valueOf(stringTokenizer.nextToken());
        }

        for (int k = 0; k < M; k++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int i = Integer.valueOf(stringTokenizer.nextToken());
            int j = Integer.valueOf(stringTokenizer.nextToken());
            System.out.println(sumArr[j] - sumArr[i - 1]);
        }

    }

}