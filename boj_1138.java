import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class boj_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> orderInfos = new ArrayList<>();
        List<Integer> result = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            orderInfos.add(Integer.parseInt(values[i]));
        }

        result.add(n);
        for (int i = n - 2; i >= 0; i--) {
            int info = orderInfos.get(i);
            int resultLen = result.size();
            for (int j = 0; j < resultLen; j++) {
                if (info == 0) {
                    result.add(j, i + 1);
                    break;
                }
                if (result.get(j) > (i + 1)) {
                    info -= 1;
                }
                if (info == 0) {
                    result.add(j + 1, i + 1);
                    break;
                }
            }
        }
        for (Integer res : result) {
            System.out.print(res+" ");
        }
    }
}
