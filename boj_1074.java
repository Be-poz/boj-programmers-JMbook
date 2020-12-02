import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1074 {
    static int r;
    static int c;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        n = (int)Math.pow(2, n);
        r = Integer.parseInt(inputs[1]);
        c = Integer.parseInt(inputs[2]);

        solution(0, 0, n);
    }

    public static void solution(int x, int y, int n) {
        if (n == 1) {
            System.out.println(answer);
            return;
        }
        n /= 2;
        if (r >= x + n && c >= y + n) {
            answer += (n * 2) * (n * 2) / 4 * 3;
            solution(x + n, y + n, n);
        } else if (r >= x + n) {
            answer += (n * 2) * (n * 2) / 4 * 2;
            solution(x + n, y, n);
        } else if (c >= y + n) {
            answer += (n * 2) * (n * 2) / 4;
            solution(x, y + n, n);
        } else {
            solution(x, y, n);
        }
    }
}
