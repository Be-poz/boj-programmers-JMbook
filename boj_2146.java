package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class boj2146 {
 
    static class pair {
        int r;
        int c;
 
        public pair(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }
 
    private static boolean[][] visited;
    private static int[][] map;
    private static int[] dr = { -1, 0, 1, 0 };
    private static int[] dc = { 0, 1, 0, -1 };
    private static int N;
    private static int cnt;
    private static int min_cnt;
 
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        min_cnt = Integer.MAX_VALUE;
        map = new int[N][N];
        visited = new boolean[N][N];
 
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 별로 분류 bfs 이용
        int number = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs1(i, j, number);
                    number++;
                }
            }
        }
 
        // 섬에서 0과 인접한 곳을 발견하면 그때부터는 0을 따라 가면서 다른 섬을 발견할 때 까지 카운트 해준다
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    // 인접한 곳 중에서 0이 한 개라도 있으면
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            if (map[nr][nc] == 0) {
                                bfs2(map[i][j], nr, nc);
                                min_cnt = min_cnt < cnt ? min_cnt : cnt;
                            }
                        }
                    }
                }
            }
        }
 
        // 가장 짧게 카운트된 값을 구한다
        System.out.println(min_cnt);
 
    } // end of main
 
    private static void bfs2(int f_number, int r, int c) {
        Queue<pair> q = new LinkedList<>();
        boolean[][] zero_visited = new boolean[N][N];
        q.add(new pair(r, c));
        zero_visited[r][c] = true;
        cnt = 0;
 
        while (!q.isEmpty()) {
            int q_size = q.size();
            cnt++;
            if (cnt >= min_cnt)
                return;
            for (int size = 0; size < q_size; size++) {
                pair p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        if (map[nr][nc] == 0 && !zero_visited[nr][nc]) {
                            q.add(new pair(nr, nc));
                            zero_visited[nr][nc] = true;
                        } else if (map[nr][nc] != 0 && map[nr][nc] != f_number) {
                            // 다른섬을 만난경우
                            return;
                        }
                    }
                }
            }
        }
 
    } // end of bfs2
 
    private static void bfs1(int r, int c, int number) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(r, c));
        visited[r][c] = true;
        map[r][c] = number;
 
        while (!q.isEmpty()) {
            pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] != 0 && !visited[nr][nc]) {
                        q.add(new pair(nr, nc));
                        visited[nr][nc] = true;
                        map[nr][nc] = number;
                    }
                }
            }
        }
    } // end of bfs1
}