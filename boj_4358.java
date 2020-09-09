import java.util.*;

public class boj_4358 {
    static class Biology implements Comparable<Biology>{
        String name;
        double ratio;

        Biology(String name, double ratio) {
            this.name = name;
            this.ratio = ratio;
        }

        @Override
        public int compareTo(Biology o) {
            return this.name.compareTo(o.name);
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Biology> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String tmp = sc.nextLine();
            if (map.containsKey(tmp)) {
                map.replace(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        int sum = 0;
        for (String key : map.keySet()) {
            sum += map.get(key);
            list.add(new Biology(key, map.get(key)));
        }
        Collections.sort(list);

        for (Biology bio : list) {
            String ratios=String.format("%.4f",bio.ratio*100/sum);
            System.out.println(bio.name+" "+ratios);
        }
    }
}
