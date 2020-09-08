import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1753 {
    static int v, e, start;
    static Scanner sc;
    static class Element implements Comparable<Element> {
        int dis;
        int idx;

        Element(int idx, int dis) {
            this.dis = dis;
            this.idx = idx;
        }

        @Override
        public int compareTo(Element o) {
            return this.dis - o.dis;
        }
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        start = sc.nextInt();

        solution();
    }

    public static void solution() {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        ArrayList<Element>[] ad = new ArrayList[v + 1];
        int[] dist = new int[v + 1];

        for (int i = 0; i <= v; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i <= v; i++)
            ad[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            ad[a].add(new Element(b, c));
        }

        dist[start] = 0;
        pq.add(new Element(start, dist[start]));

        while (!pq.isEmpty()) {
            Element tmp = pq.poll();
            int idx = tmp.idx;
            int dis = tmp.dis;

            if(dis>dist[idx]) continue;

            for (Element em : ad[idx]) {
                int emIdx = em.idx;
                int emDis = em.dis;
                if (dist[emIdx] > dist[idx] + emDis) {
                    dist[emIdx] = dist[idx] + emDis;
                    pq.add(new Element(emIdx, dist[emIdx]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if(dist[i]==Integer.MAX_VALUE)
                System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
