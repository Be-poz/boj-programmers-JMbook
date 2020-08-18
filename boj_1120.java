import java.util.Scanner;

public class boj_1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int minValue=50;
        if (a.length() == b.length()){
            System.out.println(solve(a,b));
            return;
        }

        for (int i = 0; i <= b.length() - a.length(); i++) {
            int value=solve2(a,b,i);
            minValue = Math.min(value, minValue);
        }
        System.out.println(minValue);

    }

    static int solve(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        return cnt;
    }

    static int solve2(String a, String b, int index) {
        int cnt = 0;
        for (int i = index; i < index+a.length(); i++) {
            if(b.charAt(i)!=a.charAt(i-index)) cnt++;
        }
        return cnt;
    }
}
