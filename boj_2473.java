import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class boj_2473 {
    static int n;
    static Long[] liquid;
    static ArrayList<Long> list = new ArrayList<>();
    static long optimizeValue = 3000000000L;
    public static void main(String[] args) throws IOException {
        valueInsert();
        for (int i = 0; i < n - 2; i++) {
            solution(i);
        }
        list.sort(Comparator.naturalOrder());
        for (Long li : list) {
            System.out.print(li+" ");
        }
    }

    private static void solution(int index){
        int left = index + 1;
        int right = n - 1;
        while (right > left) {
            long sum = liquid[index] + liquid[left] + liquid[right];
            if (Abs(sum) < optimizeValue) {
                optimizeValue = Abs(sum);
                list.clear();
                list.add(liquid[index]);
                list.add(liquid[left]);
                list.add(liquid[right]);
            }
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }
    }

    private static long Abs(long value) {
        return Math.abs(value);
    }

    private static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] liquidInfo = br.readLine().split(" ");
        liquid = new Long[n];
        for (int i = 0; i < n; i++) {
            liquid[i] = Long.parseLong(liquidInfo[i]);
        }
        Arrays.sort(liquid);
    }
}
