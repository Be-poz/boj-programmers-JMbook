import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class boj_2467 {
    static int n;
    static Long[] liquid;
    static long optimizeValue = 2000000000;
    static ArrayList<Long> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        valueInsert();
        for (int i = 0; i < liquid.length - 1; i++) {
            if (Math.abs(liquid[i] + liquid[i + 1]) < optimizeValue) {
                optimizeValue = Math.abs(liquid[i] + liquid[i + 1]);
                results.clear();
                results.add(liquid[i]);
                results.add(liquid[i + 1]);
            }
        }
        results.sort(Comparator.naturalOrder());
        System.out.println(results.get(0) + " " + results.get(1));
    }

    public static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        liquid = new Long[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < values.length; i++) {
            liquid[i] = Long.parseLong(values[i]);
        }
        Arrays.sort(liquid, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(Math.abs(o1),Math.abs(o2));
            }
        });
        br.close();
    }

}
