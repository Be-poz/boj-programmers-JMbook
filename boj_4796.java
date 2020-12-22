import java.util.Scanner;

public class boj_4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        while (true) {
            int l = sc.nextInt();
            int p = sc.nextInt();
            int v = sc.nextInt();
            int holiday = 0;
            if (l == 0 && p == 0 && v == 0) {
                break;
            }
            int value = v / p;
            int leftDay = v - value * p;
            holiday += value * l;
            if (leftDay > l) {
                holiday += l;
            }
            if (leftDay <= l) {
                holiday += leftDay;
            }
            System.out.println("Case " + cnt + ": " + holiday);
            cnt++;
        }
    }
}
