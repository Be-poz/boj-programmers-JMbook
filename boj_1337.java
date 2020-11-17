import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1337 {
    static int[] arr;
    public static void main(String[] args) throws IOException  {
        valueInsert();
        System.out.println(solution());
    }

    private static int solution() {
        int left = 0;
        int right = 0;
        int minValue = Integer.MAX_VALUE;
        while(right>=left) {
            if(right>=arr.length) break;
            if (arr[right] - arr[left] > 4) {
                left++;
            } else {
                int need = 5 - (right - left + 1);
                minValue = Math.min(minValue, need);
                right++;
            }
        }
        return minValue;
    }

    private static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        br.close();
    }
}
