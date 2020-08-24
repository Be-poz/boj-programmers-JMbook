import java.util.LinkedList;
import java.util.Queue;

public class boj_1829 {
    static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class xy{
        int x;
        int y;
        xy(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] answer=new int[2];
        answer=solution(6,4,picture);
        for (int ans : answer) {
            System.out.print(ans+" ");
        }
    }
    static int[] solution(int m, int n, int[][] picture) {
        int[][] visit = new int[m][n];
        int maxValue=0;
        int areaCnt=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] ==0&&picture[i][j]!=0) {
                    maxValue=Math.max(maxValue,bfs(i,j,visit,picture));
                    areaCnt++;
                }
            }
        }
        int[] answer=new int[2];
        answer[0] = areaCnt;
        answer[1] = maxValue;
        return answer;
    }

    static int bfs(int x, int y, int[][] visit, int[][] picture) {
        Queue<xy> que = new LinkedList<>();
        int cnt=1;
        int color=picture[x][y];
        que.add(new xy(x, y));
        visit[x][y]=1;
        while (!que.isEmpty()) {
            xy a = que.poll();
            int xx=a.x;
            int yy=a.y;
            for (int i = 0; i < 4; i++) {
                int xx2 = xx + dir[i][0];
                int yy2 = yy + dir[i][1];
                if (xx2 >= 0 && yy2 >= 0 && xx2 < visit.length && yy2 < visit[0].length) {
                    if (visit[xx2][yy2] == 0 && picture[xx2][yy2] == color) {
                        visit[xx2][yy2]=1;
                        que.add(new xy(xx2, yy2));
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
