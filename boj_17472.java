import java.util.*;

public class boj_17472 {
    static int n,m;
    static ArrayList<xy> info = new ArrayList<>();
    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int w;

        Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    static class xy{
        int x,y;

        xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int is_cnt = marking(board);
        int[][] bridge = new int[is_cnt + 1][is_cnt + 1];
        bridgeInfo(bridge, board);
        System.out.println(prim(bridge));
    }

    public static int prim(int[][] bridge) {
        int island_cnt = bridge.length;
        ArrayList<Edge>[] graph = new ArrayList[island_cnt];
        int answer = 0;
        int cnt = 1;
        boolean[] visit = new boolean[island_cnt];

        for (int i = 0; i < island_cnt; i++)
            graph[i]=new ArrayList<>();

        for (int i = 1; i < island_cnt; i++) {
            for (int j = 1; j < island_cnt; j++) {
                if(bridge[i][j]==0) continue;
                int start = i;
                int end = j;
                int w = bridge[i][j];
                graph[start].add(new Edge(start, end, w));
            }
        }

        PriorityQueue<Edge> pque = new PriorityQueue<>();
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        while (!que.isEmpty()) {
            int cur = que.poll();
            visit[cur] = true;
            for (Edge edge : graph[cur]) {
                if (!visit[edge.e])
                    pque.add(edge);
            }
            while (!pque.isEmpty()) {
                Edge edge = pque.poll();
                if (!visit[edge.e]) {
                    que.add(edge.e);
                    cnt++;
                    answer += edge.w;
                    break;
                }
            }
        }
        if(cnt==island_cnt-1) return answer;
        else return -1;
    }

    public static void bridgeInfo(int[][] bridge, int[][] board) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (xy tmp : info) {
            int org_x = tmp.x;
            int org_y = tmp.y;
            int color = board[org_x][org_y];
            for (int j = 0; j < 4; j++) {
                int x = org_x;
                int y = org_y;
                int cnt = 0;
                while (true) {
                    x += dir[j][0];
                    y += dir[j][1];
                    if (x < 0 || x >= n || y < 0 || y >= m) break;
                    if (board[x][y] == color) break;
                    if (board[x][y] == 0) cnt++;
                    if (board[x][y] != 0 && board[x][y] != color) {
                        if(cnt<=1) break;
                        if (bridge[color][board[x][y]] == 0 || bridge[color][board[x][y]] > cnt) {
                            bridge[color][board[x][y]] = cnt;
                            bridge[board[x][y]][color] = cnt;
                        }
                        break;
                    }
                }
            }
        }
    }

    public static int marking(int[][] board) {
        boolean[][] visit = new boolean[n][m];
        int idx=1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!=0&&!visit[i][j])
                    bfs(board, visit, i, j, idx++);
            }
        }
        return idx - 1;
    }

    public static void bfs(int[][] board, boolean[][] visit,int x, int y, int idx) {
        Queue<xy> que = new LinkedList<>();
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int x_len = board.length;
        int y_len = board[0].length;
        que.add(new xy(x, y));
        board[x][y] = idx;
        visit[x][y] = true;
        info.add(new xy(x, y));
        while (!que.isEmpty()) {
            xy tmp=que.poll();
            int xx = tmp.x;
            int yy = tmp.y;
            for (int i = 0; i < 4; i++) {
                int xx2 = xx + dir[i][0];
                int yy2 = yy + dir[i][1];
                if(xx2<0||xx2>=x_len||yy2<0||yy2>=y_len) continue;
                if (!visit[xx2][yy2] && board[xx2][yy2] != 0) {
                    visit[xx2][yy2] = true;
                    que.add(new xy(xx2, yy2));
                    board[xx2][yy2] = idx;
                    info.add(new xy(xx2, yy2));
                }
            }
        }
    }
}
