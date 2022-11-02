
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] count = new int[2];
    static int[][] coloredPaper;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        coloredPaper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                coloredPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(N, 0, 0);
        System.out.println(count[0]);
        System.out.println(count[1]);
    }

    static void recursive(int n, int y, int x) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++)
                if (coloredPaper[i][j] != coloredPaper[y][x]) {
                    n = n/2;

                    recursive(n, y, x);
                    recursive(n, y + n, x);
                    recursive(n, y, x + n);
                    recursive(n, y + n, x + n);

                    return;
                }
        }

        count[coloredPaper[y][x]]++;
    }
}