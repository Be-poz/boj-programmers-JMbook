import java.util.PriorityQueue;

public class programmers_12978 {
    static final int inf = Integer.MAX_VALUE;
    static class Element implements Comparable<Element> {
        int distance;
        int idx;

        Element(int distance, int idx) {
            this.distance = distance;
            this.idx = idx;
        }

        @Override
        public int compareTo(Element o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int k = 4;
        System.out.println(solution(n, road, k));
    }

    public static int solution(int n, int[][] road, int k) {
        int[][] ad = new int[n + 1][n + 1];
        int[] distance = new int[n + 1];
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int cnt = 0;

        for (int[] ints : road) {
            int a = ints[0];
            int b = ints[1];
            int c = ints[2];
            if (ad[a][b] == 0) {
                ad[a][b] = c;
            } else {
                ad[a][b] = Math.min(ad[a][b], c);
            }
            if (ad[b][a] == 0) {
                ad[b][a] = c;
            } else {
                ad[b][a] = Math.min(ad[b][a], c);
            }
        }

        for (int i = 0; i <= n; i++)
            distance[i] = inf;

        distance[1] = 0;
        pq.add(new Element(distance[1], 1));

        while (!pq.isEmpty()) {
            Element tmp = pq.poll();
            int dis = tmp.distance;
            int idx = tmp.idx;

            if(dis>distance[idx]) continue;

            for (int i = 1; i <= n; i++) {
                if (ad[idx][i] != 0 && distance[i] > distance[idx] + ad[idx][i]) {
                    distance[i] = distance[idx] + ad[idx][i];
                    pq.add(new Element(distance[i], i));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if(distance[i]<=k) cnt++;
        }
        return cnt;
    }
}
