import java.util.*;

public class boj_1766 {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        PriorityQueue<Integer> que = new PriorityQueue<>();
        ArrayList<Integer>[] pointing = new ArrayList[n + 1];
        int[] pointed = new int[n + 1];
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            pointing[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pointed[b]++;
            pointing[a].add(b);
        }
        for (int i = 1; i <= n; i++)
            if(pointed[i]==0) que.add(i);

        while (!que.isEmpty()) {
            int currentPoint = que.poll();
            results.add(currentPoint);
            for (int i = 0; i < pointing[currentPoint].size(); i++) {
                int pointedPoint=pointing[currentPoint].get(i);
                pointed[pointedPoint]--;
                if (pointed[pointedPoint] == 0)
                    que.add(pointedPoint);
            }
        }
        for (Integer result : results)
            System.out.print(result+" ");
    }

//    public static void insertProcess(ArrayList<Integer>[] pointing,int[] pointed,PriorityQueue<Integer>que) {
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i <= n; i++) {
//            pointing[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < m; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            pointed[b]++;
//            pointing[a].add(b);
//        }
//        for (int i = 1; i <= n; i++)
//            if(pointed[i]==0) que.add(i);
//    }
}
