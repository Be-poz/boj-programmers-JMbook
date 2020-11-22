import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_1068 {

    static int n;
    static int pick, root;
    static List<Integer>[] tree;
    static int[] visit;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        valueInsert();
        solution();
        System.out.println(result);
    }

    private static void solution() {
        if(pick == root) return;
        dfs(root);
    }

    private static void dfs(int curNode) {
        int size = tree[curNode].size();
        boolean flag = true;
        visit[curNode] = 1;
        for (int i = 0; i < size; i++) {
            int node = tree[curNode].get(i);
            if (visit[node] == 0 && node != pick) {
                dfs(node);
                flag = false;
            }
        }
        if(flag) result++;
    }

    private static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        visit = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(tokens[i]);
            if (parent == -1) {
                root = i;
                continue;
            }
            tree[parent].add(i);
            tree[i].add(parent);
        }
        pick = Integer.parseInt(br.readLine());
        br.close();
    }
}
