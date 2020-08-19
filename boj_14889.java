import java.util.Scanner;

public class boj_14889 {
    static int n;
    static int[][] team;
    static int minValue=987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        team=new int[n][n];
        int[] com=new int[n];
        int[] visited=new int[n];
        for (int i = 0; i < n; i++) {
            com[i]=i;
            for (int j = 0; j < n; j++) {
                team[i][j]=sc.nextInt();
            }
        }
        combination(com,visited,0,n,n/2);
        System.out.println(minValue);
    }

    static void combination(int[] com,int[] visited, int depth, int n, int r) {
        if(r==0){
            int[] a=new int[n/2]; //선택
            int[] b=new int[n/2]; //선택X
            int a_cnt=0,a_sum=0;
            int b_cnt=0,b_sum=0;
            for (int i = 0; i < n; i++) {
                if(visited[i]==1) a[a_cnt++]=i;
                else b[b_cnt++]=i;
            }
            for (int i = 0; i < n/2; i++) {
                for(int j=i+1;j<n/2;j++){
                    a_sum += team[a[i]][a[j]];
                    a_sum += team[a[j]][a[i]];
                    b_sum += team[b[i]][b[j]];
                    b_sum += team[b[j]][b[i]];
                }
            }
            minValue=Math.min(minValue,Math.abs(a_sum-b_sum));
            return;
        }
        for (int i = depth; i < n; i++) {
            visited[i]=1;
            combination(com,visited,i+1,n,r-1);
            visited[i]=0;
        }
    }
}
