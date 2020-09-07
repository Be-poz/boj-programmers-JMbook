import java.util.*;

/**
 * 프림 알고리즘 이용
 */
public class boj_1197 {

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<Edge>[] list = new ArrayList[v + 1];
        boolean[] visit=new boolean[v+1];

        for(int i=0;i<=v;i++)
            list[i]=new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            list[start].add(new Edge(start, end, weight));
            list[end].add(new Edge(end, start, weight));
        }

        int start=1;
        System.out.println(solve(start, visit, list));
        sc.close();
    }

    public static int solve(int s, boolean[] visit, ArrayList<Edge>[] list) {
        PriorityQueue<Edge> pque = new PriorityQueue<>();
        Queue<Integer> que = new LinkedList<>();
        int answer = 0;

        que.add(s);

        while (!que.isEmpty()) {
            int cur = que.poll();
            visit[cur] = true;

            for (Edge edge : list[cur]) {
                if(!visit[edge.end])
                    pque.add(edge);
            }

            while (!pque.isEmpty()) {
                Edge edge=pque.poll();
                if (!visit[edge.end]) {
                    que.add(edge.end);
                    visit[edge.end] = true;
                    answer += edge.weight;
                    break;
                }
            }

        }
        return answer;
    }
}

/**
 * 크루스칼 알고리즘 이용
 */
//public class boj_1197{
//
//    static class Edge implements Comparable<Edge>{
//        int start;
//        int end;
//        int weight;
//
//        Edge(int start, int end, int weight) {
//            this.start = start;
//            this.end = end;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Edge o) {
//            return this.weight - o.weight;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int v = sc.nextInt();
//        int e = sc.nextInt();
//        int answer = 0;
//        ArrayList<Edge> list = new ArrayList<>();
//        int[] parent = new int[v];
//        Arrays.fill(parent, -1);
//
//        for (int i = 0; i < e; i++) {
//            int start = sc.nextInt() - 1;
//            int end = sc.nextInt() - 1;
//            int weight = sc.nextInt();
//            list.add(new Edge(start, end, weight));
//        }
//
//        Collections.sort(list);
//
//
//        for (int i = 0; i < e; i++) {
//            Edge edge = list.get(i);
//            int a = edge.start;
//            int b = edge.end;
//            if (!isCycle(parent, a, b)) {
//                union(parent, a, b);
//                answer += edge.weight;
//            }
//        }
//        System.out.println(answer);
//    }
//
//    public static int find(int[] parent, int x) {
//        if (parent[x] < 0) {
//            return x;
//        } else {
//            return parent[x] = find(parent, parent[x]);
//        }
//    }
//
//    public static void union(int[] parent, int x, int y) {
//        x = find(parent, x);
//        y = find(parent, y);
//        if(x==y) return;
//        if (parent[x] < parent[y]) {
//            parent[x] += parent[y];
//            parent[y] = x;
//        } else {
//            parent[y] += parent[x];
//            parent[x] = y;
//        }
//    }
//
//    public static boolean isCycle(int[] parent, int x, int y) {
//        x = find(parent, x);
//        y = find(parent, y);
//        return x == y;
//    }
//}