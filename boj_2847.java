import java.util.Scanner;
import java.util.Stack;

public class boj_2847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.add(sc.nextInt());
        }

        Integer standardValue = stack.pop();
        while (!stack.isEmpty()) {
            Integer currentValue = stack.pop();
            if (currentValue >= standardValue) {
                cnt += currentValue - standardValue + 1;
                standardValue--;
                continue;
            }
            standardValue = currentValue;
        }

        System.out.println(cnt);
    }
}
