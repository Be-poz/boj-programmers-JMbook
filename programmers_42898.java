import java.util.Arrays;

public class programmers_42898 {
    public static void main(String[] args) {
        int[][] puddles={{2,2},{3,2}};
        System.out.println(solution(4,3,puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] maps=new int[n][m];
        for (int[] map : maps) {
            Arrays.fill(map, -1);
        }
        for (int i = 0; i < m; i++) {
            maps[0][i]=1;
        }
        for (int i = 0; i < n; i++) {
            maps[i][0]=1;
        }
        for (int[] puddle : puddles) {
            int a=puddle[1]-1;
            int b=puddle[0]-1;
            maps[puddle[1]-1][puddle[0]-1]=0;
            if (a == 0) {
                for (int i = b; i < m; i++) {
                    maps[0][i] = 0;
                }
            }
            if (b == 0) {
                for (int i = a; i < n; i++) {
                    maps[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(maps[i][j]==0) continue;
                int tmp=(maps[i-1][j]+maps[i][j-1])%1000000007;
                if(maps[i][j]==-1) maps[i][j]=tmp;
                else if(maps[i][j]>tmp) maps[i][j]=tmp;
            }
        }
        return maps[n-1][m-1];
    }
}
