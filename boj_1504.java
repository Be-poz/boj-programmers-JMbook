import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1504 {
    static Scanner sc = new Scanner(System.in);
    static int n, e;
    static final int inf = Integer.MAX_VALUE;

    static class Element implements Comparable<Element>{
        int idx;
        int dis;

        Element(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }

        @Override
        public int compareTo(Element o) {
            return this.dis - o.dis;
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        e = sc.nextInt();
        ArrayList<Element>[] ad = new ArrayList[n+1];
        int[] dist = new int[n + 1];
        int answer=inf;

        for (int i = 0; i <= n; i++)
            ad[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            ad[a].add(new Element(b, c));
            ad[b].add(new Element(a, c));
        }

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        int a = solution(1, p1, ad, dist);
        int b = solution(p1, p2, ad, dist);
        int c = solution(p2, n, ad, dist);
        if(a!=inf&&b!=inf&&c!=inf)
            answer = Math.min(answer, a + b + c);

        a = solution(1, p2, ad, dist);
        b = solution(p2, p1, ad, dist);
        c = solution(p1, n, ad, dist);
        if(a!=inf&&b!=inf&&c!=inf)
            answer = Math.min(answer, a + b + c);

        if (answer == inf) {
            System.out.println("-1");
        }else System.out.println(answer);
    }

    public static int solution(int start, int end, ArrayList<Element>[] ad, int[] dist) {
        PriorityQueue<Element> pq = new PriorityQueue<>();

        for (int i = 0; i <= n; i++)
            dist[i]=inf;

        dist[start] = 0;
        pq.add(new Element(start, dist[start]));

        while (!pq.isEmpty()) {
            Element tmp = pq.poll();
            int idx = tmp.idx;
            int dis = tmp.dis;

            if (dis > dist[idx]) continue;

            for (Element ele : ad[idx]) {
                int elIdx = ele.idx;
                int elDis = ele.dis;
                if (dist[elIdx] > dist[idx] + elDis) {
                    dist[elIdx] = dist[idx] + elDis;
                    pq.add(new Element(elIdx, dist[elIdx]));
                }
            }
        }
        return dist[end];
    }
}
