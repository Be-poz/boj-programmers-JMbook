import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1940 {
    static int n,m;
    static int[] metal;
    public static void main(String[] args) throws IOException {
        valueInsert();
        System.out.println(solution());
    }

    private static int solution() {
        if(n==1) return 0;
        int cnt = 0;
        int left =0 ;
        int right = n - 1;
        while (right > left) {
            if (metal[right] + metal[left] > m) {
                right--;
            } else if (metal[right] + metal[left] < m) {
                left++;
            } else {
                right--;
                left++;
                cnt++;
            }
        }
        return cnt;
    }

    private static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        metal = new int[n];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            metal[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(metal);
        br.close();
    }
}
