import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1916 {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static final int inf = Integer.MAX_VALUE;

    static class Element implements Comparable<Element>{
        int idx;
        int distance;

        Element(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Element o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<Element>[] ad = new ArrayList[n+1];
        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++)
            ad[i] = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            dist[i] = inf;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            ad[a].add(new Element(b, c));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(solution(start, end, ad, dist));
    }

    public static int solution(int start, int end, ArrayList<Element>[] ad, int[] dist) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Element(start, dist[start]));

        while (!pq.isEmpty()) {
            Element tmp = pq.poll();
            int idx = tmp.idx;
            int distance = tmp.distance;

            if(distance>dist[idx]) continue;

            for (Element ele : ad[idx]) {
                int emIdx = ele.idx;
                int emDis = ele.distance;
                if (dist[emIdx] > dist[idx] + emDis) {
                    dist[emIdx] = dist[idx] + emDis;
                    pq.add(new Element(emIdx, dist[emIdx]));
                }
            }
        }
        return dist[end];
    }
}
