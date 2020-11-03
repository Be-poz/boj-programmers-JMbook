import java.util.Scanner;

public class boj_2003 {
    static int n,m;
    static int[] a;
    public static void main(String[] args) {
        valueInsert();
        System.out.println(solution());
    }

    public static int solution(){
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            int head = 0;
            int tail = i;
            int sum = 0;
            for (int j = 0; j <= tail; j++) {
                sum += a[j];
            }
            if(sum==m) result++;
            for (int j = 1; j < (n - i); j++) {
                head++;
                tail++;
                sum -= a[head - 1];
                sum += a[tail];
                if(sum==m) result++;
            }
        }
        return result;
    }

    public static void valueInsert(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
    }
}
