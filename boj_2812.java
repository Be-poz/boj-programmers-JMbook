import java.util.*;

public class boj_2812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Stack<String> stack = new Stack<>();
        String[] nums = sc.next().split("");
        StringBuilder sbd = new StringBuilder();

        for (String num : nums) {
            while (!stack.isEmpty() && num.compareTo(stack.peek()) > 0 && k > 0) {
                stack.pop();
                k--;
            }
            stack.add(num);
        }

        while (!stack.isEmpty()) {
            sbd.append(stack.pop());
        }
        String answer = sbd.reverse().toString();
        System.out.println(answer.substring(0, answer.length() - k));
    }
}
