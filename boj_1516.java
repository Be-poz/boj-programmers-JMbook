import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj_1516 {
    static class Element{
        int p;
        int c;
        Element(int point, int cost) {
            p = point;
            c = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] targeted = new int[n + 1];
        ArrayList<Integer>[] info = new ArrayList[n + 1];
        int[] cost = new int[n + 1];
        int[] result = new int[n + 1];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n + 1; i++) {
            info[i] = new ArrayList<>();
        }


        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            cost[i] = Integer.parseInt(input[0]);
            int idx = 1;
            while (Integer.parseInt(input[idx])!=-1) {
                targeted[i]++;
                info[Integer.parseInt(input[idx++])].add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (targeted[i] == 0) {
                que.add(i);
                result[i] = cost[i];
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();
            for (Integer p : info[now]) {
                targeted[p]--;
                result[p] = Math.max(result[now] + cost[p], result[p]);
                if (targeted[p] == 0) {
                    que.add(p);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}
