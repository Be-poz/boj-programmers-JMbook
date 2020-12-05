import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1780 {
    static int n;
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static int minusCnt = 0;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                paper[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        solution(0, 0, n);
        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.println(oneCnt);
    }

    public static void solution(int x, int y, int num) {
        int value = paper[x][y];
        if (isOnePaper(x, y, num)) {
            if(value == 0 ) zeroCnt++;
            if(value == 1 ) oneCnt++;
            if(value == -1 ) minusCnt++;
            return;
        }
        num /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int xx = x + i * num;
                int yy = y + j * num;
                solution(xx, yy, num);
            }
        }
    }

    static boolean isOnePaper(int x, int y, int num) {
        int value = paper[x][y];
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
