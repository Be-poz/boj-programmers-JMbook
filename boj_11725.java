import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_11725 {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] result;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        valueInsert();
        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int start) {
        visit[start] = 1;
        for (int i = 0; i < list[start].size(); i++) {
            int value = list[start].get(i);
            if(visit[value] == 1) continue;
            visit[value] = 1;
            result[value] = start;
            dfs(value);
            visit[value] = 0;
        }
    }

    private static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        result = new int[n + 1];
        visit = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            String[] toks = br.readLine().split(" ");
            int a = Integer.parseInt(toks[0]);
            int b = Integer.parseInt(toks[1]);
            list[a].add(b);
            list[b].add(a);
        }
        br.close();
    }
}
