import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2230 {
    static int n,m;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        valueInsert();
        System.out.println(solution());
    }

    private static int solution(){
        int minValue = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < n) {
            int result = nums[right] - nums[left];
            if (result > m) {
                left++;
                minValue = Math.min(result, minValue);
            } else if (result < m) {
                right++;
            } else return m;
        }
        return minValue;
    }

    private static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        br.close();
    }
}
