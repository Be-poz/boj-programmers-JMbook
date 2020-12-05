import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] sik = sc.next().toCharArray();
        List<Integer> list = new ArrayList<>();
        StringBuilder strb = new StringBuilder();
        int result = 0;
        boolean flag = false;

        for (char c : sik) {
            if (c == '-' || c == '+') {
                list.add(Integer.parseInt(strb.toString()));
                strb = new StringBuilder();
            }
            strb.append(c);
        }
        list.add(Integer.parseInt(strb.toString()));

        for (Integer i : list) {
            if (!flag && i < 0) {
                flag = true;
            }
            if (flag) {
                if (i > 0) {
                    result -= i;
                    continue;
                }
                if (i < 0) {
                    result += i;
                    continue;
                }
            }
            result += i;
        }
        System.out.println(result);
    }
}
