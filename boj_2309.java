import java.util.Arrays;
import java.util.Scanner;

public class boj_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] height=new int[9];
        int[] visited=new int[9];
        int[] result=new int[7];
        for (int i = 0; i < 9; i++) {
            height[i] = sc.nextInt();
        }
        Arrays.sort(height);
        combination(height,visited,result,0,9,7);
    }
    public static void combination(int []height,int[] visited,int []result,int start,int n,int r){
        if(r==0){
            int sum=0;
            for (int res : result) {
                sum+=res;
            }
            if(sum==100){
                Arrays.sort(result);
                for (int res : result) {
                    System.out.println(res);
                }
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < n; i++) {
            if(visited[i]!=1){
                visited[i]=1;
                result[7-r]=height[i];
                combination(height,visited,result,start+1,n,r-1);
                visited[i]=0;
            }
        }
    }
}
