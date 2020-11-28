import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_1167 {
    static int maxValue = -1;
    static int maxPoint = 0;
    static List<Node>[] tree;

    static class Node{
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] visited = new int[n + 1];
        tree = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int fromPoint = Integer.parseInt(inputs[0]);

            for (int j = 1; j < inputs.length; j += 2) {
                int toPoint = Integer.parseInt(inputs[j]);
                if (toPoint == -1) {
                    break;
                }
                int weight = Integer.parseInt(inputs[j + 1]);
                if (toPoint < fromPoint) {
                    continue;
                }
                tree[fromPoint].add(new Node(toPoint, weight));
                tree[toPoint].add(new Node(fromPoint, weight));
            }
        }
        visited[1] = 1;
        dfs(1, 0, visited);
        visited = new int[n + 1];
        maxValue = 0;
        visited[maxPoint] = 1;
        dfs(maxPoint, 0, visited);
        System.out.println(maxValue);
    }

    private static void dfs(int cur, int sum, int[] visited) {

        if (sum > maxValue) {
            maxValue = sum;
            maxPoint = cur;
        }

        for (int i = 0; i < tree[cur].size(); i++) {
            int toPoint = tree[cur].get(i).v;
            int weight = tree[cur].get(i).w;
            if (visited[toPoint] == 1) continue;
            visited[toPoint] = 1;
            dfs(toPoint, sum + weight, visited);
            visited[toPoint] = 0;
        }
    }
}
