import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            int cityCnt = Integer.parseInt(tokens[0]);
            int planeCnt = Integer.parseInt(tokens[1]);
            for (int j = 0; j < planeCnt; j++) {
                br.readLine();
            }
            System.out.println(cityCnt - 1);
        }
        br.close();
    }
}
