import java.util.*;

public class boj_1202 {

    static class Jewerly implements Comparable<Jewerly> {
        int weight;
        int value;

        Jewerly(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewerly o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Jewerly> jlist = new ArrayList<>();
        PriorityQueue<Integer> bags = new PriorityQueue<>();
        long sum = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            jlist.add(new Jewerly(w, v));
        }
        jlist.sort(Comparator.naturalOrder());

        for (int i = 0; i < k; i++) {
            bags.add(sc.nextInt());
        }

        PriorityQueue<Integer> weight = new PriorityQueue<>(Comparator.reverseOrder());

        int jIndex = 0;
        for (int i = 0; i < k; i++) {
            Integer bagWeight = bags.poll();
            while (jIndex < n && jlist.get(jIndex).weight <= bagWeight) {
                weight.add(jlist.get(jIndex).value);
                jIndex++;
            }
            if (!weight.isEmpty()) {
                sum += weight.poll();
            }
        }
        System.out.println(sum);
    }
}
