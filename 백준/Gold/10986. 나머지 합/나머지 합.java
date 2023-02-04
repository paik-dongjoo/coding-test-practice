import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long sumArr[] = new long[N];
        long remainderArr[] = new long[M];
        long answer = 0;

        // 합배열 데이터입력
        sumArr[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + sc.nextInt();
        }

        // 합배열 인덱스별 % 연산 수행
        for (int i = 0; i < N; i++) {
            int remainder = (int) (sumArr[i] % M);

            // 구간합의 값이 0인 인덱스 카운팅
            if (remainder == 0) {
                answer++;
            }

            // 나머지가 같은 인덱스 개수 카운팅
            remainderArr[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수(Combination) 카운팅
            if (remainderArr[i] > 1) {
                answer = answer + (remainderArr[i] * (remainderArr[i] - 1)) / 2;
            }
        }

        System.out.println(answer);
    }
}