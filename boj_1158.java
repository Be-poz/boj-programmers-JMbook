import java.util.*;

public class boj_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            que.offer(i + 1);
        }
        StringBuilder stb = new StringBuilder();
        stb.append("<");
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < k; j++) {
                int tmp=que.poll();
                if (j == k - 1) {
                    stb.append(tmp+", ");
                }else que.offer(tmp);
            }
        }
        stb.append(que.poll()+">");
        System.out.println(stb.toString());
    }
}