import java.util.Scanner;

public class boj_1182 {
    static int cnt=0;
    static int s=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();
        int[] arr =new int[n];
        int[] visit=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            combination(arr,visit,0,n,i);
        }
        System.out.println(cnt);
    }

    static void combination(int[] arr, int[] visit, int start, int n, int r) {
        if(r==0){
            int sum=0;
            for (int i = 0; i < visit.length; i++) {
                if(visit[i]==1)
                    sum+=arr[i];
            }
            if(sum==s) cnt++;
            return;
        }
        for (int i = start; i < n; i++) {
            visit[i]=1;
            combination(arr,visit,i+1,n,r-1);
            visit[i]=0;
        }
    }
}
