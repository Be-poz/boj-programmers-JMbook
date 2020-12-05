import java.util.Arrays;
import java.util.Scanner;

public class boj_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = sc.nextInt();
        }
        Arrays.sort(line);
        for (int i = 0; i < n; i++) {
            sum += line[i] * (n - i);
        }
        System.out.println(sum);
    }
}
