import java.util.Scanner;

public class boj_2529 {
    static String maxStr = "0";
    static String minStr = "9876543210";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        char[] bu=new char[k];
        boolean[] visit=new boolean[10];
        StringBuilder stbd = new StringBuilder();

        for (int i = 0; i < k; i++)
            bu[i]=sc.next().charAt(0);

        solution(bu, k, stbd, 0, visit);
        System.out.println(maxStr);
        System.out.println(minStr);
    }

    public static void solution(char[] bu, int k, StringBuilder stbd, int depth, boolean[] visit) {
        if (depth == k + 1) {
            if(Long.parseLong(maxStr)<Long.parseLong(stbd.toString()))
                maxStr=stbd.toString();
            if(Long.parseLong(minStr)>Long.parseLong(stbd.toString()))
                minStr=stbd.toString();
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(visit[i]) continue;
            stbd.append(i);
            if(!check(stbd,bu)){
                stbd.deleteCharAt(stbd.length() - 1);
                continue;
            }
            visit[i]=true;
            solution(bu, k, stbd, depth + 1, visit);
            stbd.deleteCharAt(stbd.length()-1);
            visit[i]=false;
        }
    }

    public static boolean check(StringBuilder stbd, char[] bu) {
        int len = stbd.toString().length();
        if(len<=1) return true;
        int a = stbd.toString().charAt(len - 2)-'0';
        int b = stbd.toString().charAt(len - 1)-'0';
        char c = bu[len - 2];
        if (c == '>'&&a>b)
            return true;
        return c == '<' && a < b;
    }
}
