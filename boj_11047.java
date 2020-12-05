import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int change = k;
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (coins[i] > change) {
                continue;
            }
            result += (change / coins[i]);
            change %= coins[i];
        }
        System.out.println(result);
    }
}
