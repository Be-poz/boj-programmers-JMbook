import java.util.Scanner;

public class boj_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int cnt=0;
        int num=666;
        while (cnt != n) {
            if(check(num++)) cnt++;
        }
        System.out.println(num-1);
    }

    static boolean check(int num) {
        String n=Integer.toString(num);
        int cnt=0;
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i)=='6') cnt++;
            else cnt=0;
            if(cnt==3) return true;
        }
        return false;
    }
}
