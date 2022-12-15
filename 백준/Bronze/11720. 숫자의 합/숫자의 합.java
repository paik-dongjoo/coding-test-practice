import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력받을 숫자의 길이
        int n = sc.nextInt();

        // n의 길이를 갖는 숫자
        String sNum = sc.next();

        // sNum을 char[] 배열에 저장
        char[] cNum = sNum.toCharArray();

        // int 변수 sum 선언
        int sum = 0;

        // for문 반복하며 각 인덱스 값 누적
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum);

    }

}