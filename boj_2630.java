import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2630 {
    static int[][] paper;
    static int oneCnt = 0;
    static int zeroCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                paper[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        solution(0, 0, n);
        System.out.println(zeroCnt);
        System.out.println(oneCnt);
    }

    public static void solution(int x, int y, int n) {
        int value = paper[x][y];
        if (isOnePaper(x, y, n)) {
            if(value == 1) oneCnt++;
            if(value == 0) zeroCnt++;
            return;
        }
        n /= 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int xx = x + i * n;
                int yy = y + j * n;
                solution(xx, yy, n);
            }
        }
    }

    public static boolean isOnePaper(int x, int y, int n) {
        int value = paper[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
