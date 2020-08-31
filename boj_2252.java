import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> result =new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] targeted=new int[n+1];
        ArrayList<Integer>[] direction=new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            direction[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            targeted[end]++;
            direction[start].add(end);
        }
        for (int i = 1; i <= n; i++) {
            if(targeted[i]==0) que.add(i);
        }

        while (!que.isEmpty()) {
            int currentNode = que.poll();
            result.add(currentNode);
            for (int i = 0; i < direction[currentNode].size(); i++) {
                int getArrowNode = direction[currentNode].get(i);
                targeted[getArrowNode]--;
                if (targeted[getArrowNode] == 0) {
                    que.add(getArrowNode);
                }
            }
        }
        for (Integer ans : result) {
            System.out.println(ans+" ");
        }
    }
}
