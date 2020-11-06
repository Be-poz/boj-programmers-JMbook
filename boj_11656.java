import java.util.Arrays;
import java.util.Scanner;

public class boj_11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] strArr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i);
            strArr[i] = temp;
        }
        Arrays.sort(strArr);
        for (String answer : strArr) {
            System.out.println(answer);
        }
    }
}
