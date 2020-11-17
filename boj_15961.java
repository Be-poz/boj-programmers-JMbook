import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15961 {
    static int n,d,k,c;
    static int[] sushi;
    static int[] kind;
    public static void main(String[] args)  throws IOException {
        valueInsert();
        System.out.println(solution());
    }

    private static int solution() {
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if(kind[sushi[i]]++ == 0) cnt++;
        }
        int maxValue = cnt;
        if(kind[c]==0) maxValue++;
        for (int i = 1; i < n; i++) {
            if(--kind[sushi[i - 1]] == 0) cnt--;
            if(++kind[sushi[(i + k - 1) % n]] == 1) cnt++;
            int add = (kind[c] == 0) ? 1 : 0;
            maxValue = Math.max(cnt + add, maxValue);
        }
        return maxValue;
    }

    private static void valueInsert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        c = Integer.parseInt(input[3]);
        kind = new int[d + 1];
        sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }
}
