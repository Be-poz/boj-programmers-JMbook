import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2623 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] targeted = new int[n + 1];
        ArrayList<Integer>[] point = new ArrayList[n + 1];
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            point[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 1; j < tokens.length - 1; j++) {
                int a = Integer.parseInt(tokens[j]);
                int b = Integer.parseInt(tokens[j + 1]);
                if (!point[a].contains(b)) {
                    point[a].add(b);
                    targeted[b]++;
                }
            }
        }
        int cnt=0;
        for (int i = 1; i <= n; i++) {
            if (targeted[i] == 0) {
                que.add(i);
                result.add(i);
                cnt++;
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();
            for (Integer p : point[now]) {
                targeted[p]--;
                if (targeted[p] == 0) {
                    que.add(p);
                    result.add(p);
                    cnt++;
                }
            }
        }

        if (cnt != n) {
            System.out.println("0");
            return;
        }

        for (Integer ans : result) {
            System.out.println(ans);
        }

    }
}
