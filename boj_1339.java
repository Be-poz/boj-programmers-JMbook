import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class boj_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] alphabets = new Integer[26];
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(alphabets, 0);

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                int cnt = (int) Math.pow(10, word.length() - j - 1);
                int index = word.charAt(j) - 'A';
                alphabets[index] += cnt;
            }
        }
        Arrays.sort(alphabets, Comparator.reverseOrder());
        AtomicInteger num = new AtomicInteger(9);
        int result = Arrays.stream(alphabets)
                .mapToInt(value -> value * (num.getAndDecrement()))
                .sum();
        System.out.println(result);
    }
}
