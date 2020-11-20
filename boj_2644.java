import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2644 {
    static int n,m,a,b;
    static int[][] rel;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        valueInsert();
        System.out.println(solution());
    }

    private static int solution(){
        int[] visit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if(rel[a][i]==0) continue;
            visit[a] = 1;
            dfs(i,1, visit);
            visit[a] = 0;
        }
        if(result == Integer.MAX_VALUE) return -1;
        else return result;
    }

    private static void dfs(int start, int depth, int[] visit) {
        if(start == b){
            result = Math.min(depth, result);
        }
        for (int i = 1; i <= n; i++) {
            if(rel[start][i] == 0) continue;
            if (visit[i] == 1) continue;
            visit[i] = 1;
            dfs(i, depth + 1, visit);
            visit[i] = 0;
        }
    }

    private static void valueInsert() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rel = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            rel[i] = new int[n + 1];
        }
        String[] tok = br.readLine().split(" ");
        a = Integer.parseInt(tok[0]);
        b = Integer.parseInt(tok[1]);
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] values = br.readLine().split(" ");
            int v1 = Integer.parseInt(values[0]);
            int v2 = Integer.parseInt(values[1]);
            rel[v1][v2] = 1;
            rel[v2][v1] = 1;
        }
        br.close();
    }
}
