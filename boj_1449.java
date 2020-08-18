import java.util.Arrays;
import java.util.Scanner;

public class boj_1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int l=sc.nextInt();
        int[] leak = new int[n];
        for (int i = 0; i < n; i++) {
            leak[i]=sc.nextInt();
        }
        Arrays.sort(leak);
        int start=leak[0];
        int end=0;
        int cnt=1;
        for (int i = 1; i < n; i++) {
            end=start+l-1;
            if(leak[i]<=end) continue;
            else{
                start=leak[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
