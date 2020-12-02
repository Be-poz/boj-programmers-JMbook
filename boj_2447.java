import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2447 {
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stars = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(stars[i], ' ');
        }

        solution(0, 0, n);

        for (int i = 0; i < n; i++) {
            System.out.println(stars[i]);
        }
    }

    public static void solution(int x, int y, int n) {
        if (n == 1) {
            stars[x][y] = '*';
            return;
        }

        n /= 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                solution(i * n + x, j * n + y, n);
            }
        }
    }
}
