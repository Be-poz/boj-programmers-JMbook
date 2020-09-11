import java.util.*;

public class boj_4386 {
    static class Element implements Comparable<Element>{
        int e;
        double w;

        Element(int e, double w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Element o) {
            if(this.w-o.w>0) return 1;
            else if(this.w==o.w) return 0;
            else return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Element>[] list = new ArrayList[n + 1];
        double[][] info = new double[n][2];

        for (int i = 0; i < n; i++) {
            info[i][0] = sc.nextDouble();
            info[i][1] = sc.nextDouble();
        }

        for (int i = 0; i < n + 1; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double ax = info[i][0];
                double ay = info[i][1];
                double bx = info[j][0];
                double by = info[j][1];
                double w = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
                list[i + 1].add(new Element(j+1, w));
                list[j + 1].add(new Element(i + 1, w));
            }
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();
        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        double answer = 0;
        que.add(1);
        visit[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (Element ele : list[cur]) {
                if (!visit[ele.e]) {
                    pq.add(ele);
                }
            }

            while (!pq.isEmpty()) {
                Element ele = pq.poll();
                if (!visit[ele.e]) {
                    que.add(ele.e);
                    visit[ele.e] = true;
                    answer+=ele.w;
                    break;
                }
            }
        }
        System.out.println(String.format("%.2f",answer));
    }
}
