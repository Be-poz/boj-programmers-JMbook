import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int oneCnt = 0;
        long sum = 0 ;
        boolean isZeroExist = false;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                isZeroExist = true;
                continue;
            }
            if (input == 1) {
                oneCnt++;
                continue;
            }
            if (input < 0) {
                minus.add(input);
                continue;
            }
            plus.add(input);
        }

        Collections.sort(plus);
        Collections.sort(minus);
        if (plus.size() % 2 == 1) {
            for (int i = 1; i < plus.size(); i += 2) {
                sum += (plus.get(i) * plus.get(i + 1));
            }
            sum += plus.get(0);
        } else {
            for (int i = 0; i < plus.size(); i += 2) {
                sum += (plus.get(i) * plus.get(i + 1));
            }
        }
        sum += oneCnt;

        if (minus.size() % 2 == 1) {
            for (int i = 0; i < minus.size() - 1; i += 2) {
                sum += (minus.get(i) * minus.get(i + 1));
            }
            if (!isZeroExist) {
                sum += minus.get(minus.size() - 1);
            }
        } else {
            for (int i = 0; i < minus.size(); i += 2) {
                sum += (minus.get(i) * minus.get(i + 1));
            }
        }
        System.out.println(sum);
    }
}
