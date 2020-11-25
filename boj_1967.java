import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_1967 {

    static class Node{
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static int n;
    static int maxValue = 0;
    static int point;
    static List<Node>[] tree;
    public static void main(String[] args) throws IOException {
        valueInsert();
        System.out.println(solution());
    }

    private static int solution() {
        int[] visited = new int[n + 1];
        int result = 0;
        visited[1] = 1;
        dfs(1, 0, visited);
        maxValue = 0;
        visited = new int[n + 1];
        visited[point] = 1;         //1이 아니라 가장 먼 점 시작이니깐 point 방문 처리
        dfs(point, 0, visited);
        result += maxValue;
        return result;
    }

    private static void dfs(int cur, int sum, int[] visited) {
        if (sum > maxValue) {
            maxValue = sum;
            point = cur;
        }
        for (int i = 0; i < tree[cur].size(); i++) {
            int v = tree[cur].get(i).v;
            int w = tree[cur].get(i).w;
            if(visited[v] == 1) continue;
            visited[v] = 1;
            dfs(v, sum + w, visited);
            visited[v] = 0;
        }
    }

    private static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            int parent = Integer.parseInt(tokens[0]);
            int child = Integer.parseInt(tokens[1]);
            int weight = Integer.parseInt(tokens[2]);
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }
        br.close();
    }
}
