import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11437 {
    static List<Integer>[] tree;
    static int[] parent;
    static int[] depth;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        valueInsert();
        solution();
    }

    private static void solution() throws IOException {
        Queue<Integer> que = new LinkedList<>();
        int m;

        que.add(1);
        parent[1] = 1;
        depth[1] = 1;

        while (!que.isEmpty()) {
            int from = que.poll();
            for (Integer to : tree[from]) {
                if (parent[to] == 0) {
                    que.add(to);
                    parent[to] = from;
                    depth[to] = depth[from] + 1;
                }
            }
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] tokens = br.readLine().split(" ");
            int p1 = Integer.parseInt(tokens[0]);
            int p2 = Integer.parseInt(tokens[1]);
            if (depth[p1] > depth[p2]) {
                int temp = p1;
                p1 = p2;
                p2 = temp;
            }
            while (depth[p1] != depth[p2]) {
                p2 = parent[p2];
            }
            if (p1 == p2) {
                System.out.println(p1);
            } else {
                while (parent[p1] != parent[p2]) {
                    p1 = parent[p1];
                    p2 = parent[p2];
                }
                System.out.println(parent[p1]);
            }
        }
    }

    private static void valueInsert() throws IOException {
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            tree[a].add(b);
            tree[b].add(a);
        }
    }
}
