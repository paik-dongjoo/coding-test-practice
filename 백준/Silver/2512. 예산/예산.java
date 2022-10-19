import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int result = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 지방의 수
        int[] budget = new int[N]; // 지방별 예산
        for (int i = 0; i < budget.length; i++) {
            budget[i] = sc.nextInt();
        }

        Arrays.sort(budget);
        int M = sc.nextInt();   // 총 예산
        int minBudget = 0;
        int maxBudget = budget[budget.length - 1];

        while (minBudget <= maxBudget) {
            int tax = (minBudget + maxBudget) / 2;
            int taxsum = 0;
            for (int item : budget) {
                if (item <= tax) {
                    taxsum += item;
                } else {
                    taxsum += tax;
                }  // item > tax
            }
            if (taxsum > M) {
                maxBudget = tax - 1;
            } else {
                minBudget = tax + 1;
                result = Math.max(result, tax);
            }
        }
        System.out.println(result);
    }

}