import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1261 {
    static int n, m;

    static class Element implements Comparable<Element>{
        int dis;
        int x;
        int y;

        Element(int dis, int x, int y) {
            this.dis = dis;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Element o) {
            return this.dis - o.dis;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        System.out.println(solution(map));
    }

    public static int solution(int[][] map) {
        int[][] dist = new int[n][m];
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = map[0][0];
        pq.add(new Element(dist[0][0], 0, 0));

        while (!pq.isEmpty()) {
            Element tmp = pq.poll();
            int x = tmp.x;
            int y = tmp.y;
            int distance = tmp.dis;

            if(distance>dist[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];
                if(xx<0||xx>=n||yy<0||yy>=m) continue;
                if (dist[xx][yy] > dist[x][y] + map[xx][yy]) {
                    dist[xx][yy] = dist[x][y] + map[xx][yy];
                    pq.add(new Element(dist[xx][yy], xx, yy));
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}
