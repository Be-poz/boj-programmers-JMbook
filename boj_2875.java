import java.util.Scanner;

public class boj_2875 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        for (int i = m; i >= 1; i--) {
            if(n<i*2) continue;
            if((m-i)+(n-i*2)<k) continue;
            System.out.println(i);
            return;
        }
        System.out.println(0);
        return;
    }
}
