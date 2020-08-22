import java.util.Arrays;
import java.util.Scanner;

public class boj_2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int []share=new int[a];
        for (int i = 0; i < a; i++) {
            share[i] = sc.nextInt();
        }
        Arrays.sort(share);
        System.out.println(solution(share,b));
    }

    static int solution(int[] share,int target) {
        int answer=0;
        int left=1;
        int right=share[share.length-1]-1;
        int mid;
        while (right >= left) {
            mid = (left + right) / 2;
            int pos=share[0];
            int cnt=1;
            for (int i = 1; i < share.length; i++) {
                if (share[i] - pos >= mid) {
                    cnt++;
                    pos=share[i];
                }
            }
            if (cnt >= target) {
                left=mid+1;
                answer=mid;
            } else {
                right=mid-1;
            }
        }
        return answer;
    }
}
