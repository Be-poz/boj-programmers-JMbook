import java.util.*;

public class boj_4485 {
    static int[][] cave;
    static int[][] dist;
    static final int inf = 2250;
    static class Element implements Comparable<Element>{
        int distance;
        int x;
        int y;

        Element(int distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Element o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        while (true) {
            int n = sc.nextInt();
            int answer = 0;
            if(n==0) break;
            cave = new int[n+1][n+1];
            dist = new int[n+1][n+1];

            for (int i = 0; i <= n; i++)
                for (int j = 0; j <= n; j++)
                    dist[i][j]=inf;

            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    cave[i][j] = sc.nextInt();

            answer = solution(n);
            System.out.println("Problem "+cnt+": "+answer);
            cnt++;
        }
    }

    public static int solution(int n) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<Element> que = new PriorityQueue<>();
        dist[1][1] = cave[1][1];
        que.add(new Element(dist[1][1], 1, 1));

        while (!que.isEmpty()) {
            Element tmp = que.poll();
            int distance = tmp.distance;
            int x = tmp.x;
            int y = tmp.y;

            if(distance>dist[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];
                if(xx<=0||xx>n||yy<=0||yy>n) continue;
                if (dist[xx][yy] > dist[x][y] + cave[xx][yy]) {
                    dist[xx][yy] = dist[x][y] + cave[xx][yy];
                    que.add(new Element(dist[xx][yy], xx, yy));
                }
            }
        }
        return dist[n][n];
    }
}
