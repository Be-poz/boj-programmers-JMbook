public class programmers_1832 {
    static int MOD = 20170805;
    public static void main(String[] args) {
        int[][] cityMap = {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}};
        System.out.println(solution(3, 6, cityMap));
    }

    public static int solution(int m, int n, int[][] cityMap) {
        int[][][] map=new int[m][n][2];
        for (int i = 0; i < m; i++) {
            map[i][0][0] = 1;
            map[i][0][1] = 1;
        }
        for (int i = 0; i < n; i++) {
            map[0][i][0] = 1;
            map[0][i][1] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) {
                for (int j = i; j < m; j++) {
                    map[j][0][0] = 0;
                    map[j][0][1] = 0;
                }
                break;
            } else if (cityMap[i][0] == 2) {
                map[i][0][0]=0;
                map[i][0][1]=1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] == 1) {
                for (int j = i; j < n; j++) {
                    map[0][j][0] = 0;
                    map[0][j][1] = 0;
                }
                break;
            } else if (cityMap[0][i] == 2) {
                map[0][i][0]=1;
                map[0][i][1]=0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int upValue=map[i-1][j][1];
                int leftValue=map[i][j-1][0];

                if (cityMap[i][j] == 2) {
                    map[i][j][0]=leftValue;
                    map[i][j][1]=upValue;
                } else if (cityMap[i][j] == 1) {
                    map[i][j][0] = 0;
                    map[i][j][1] = 0;
                } else {
                    map[i][j][0] = upValue + leftValue;
                    map[i][j][0]%=MOD;
                    map[i][j][1] = upValue + leftValue;
                    map[i][j][1]%=MOD;
                }
            }
        }
        return map[m-1][n-1][0];
    }
}
