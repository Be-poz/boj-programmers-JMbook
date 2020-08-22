import java.util.Arrays;
import java.util.Scanner;

public class boj_1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long b = sc.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr,b));
    }

    static int solution(int[] arr, long target) {
        int left=1;
        int right=arr.length;
        int answer=0;
        int mid;
        int len=arr.length;
        while (right >= left) {
            mid = (right + left) / 2;
            long sum=0;
            boolean flag=false;
            for (int i = 0; i <= len - mid; i++) {
                if(i==0){
                    for (int j = 0; j <mid; j++) {
                        sum += arr[j];
                    }
                    if (sum >= target) {
                        flag=true;
                        break;
                    }
                    continue;
                }
                sum -= arr[i - 1];
                sum += arr[i + mid - 1];
                if (sum >= target) {
                    flag=true;
                    break;
                }
            }
            if (flag) {
                answer=mid;
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return answer;
    }
}
