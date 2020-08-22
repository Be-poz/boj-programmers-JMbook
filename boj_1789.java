import java.util.Scanner;

public class boj_1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long left=1;
        long right=n;
        long mid;
        long answer=0;

        while (right >= left) {
            mid = (left + right) / 2;
            long sum=0;
            boolean flag = false;
            for (int i = 1; i <= mid; i++) {
                sum+=i;
                if (sum > n) {
                    right=mid-1;
                    flag = true;
                    break;
                }
                if (sum == n) {
                    System.out.println(i);
                    return;
                }
            }
            if (!flag) {
                answer = mid;
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
