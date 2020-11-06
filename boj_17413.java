import java.util.ArrayList;
import java.util.Scanner;

public class boj_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] charArr = str.toCharArray();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> codes = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '<') {
                StringBuilder tmp = new StringBuilder("<");
                for (int j = i + 1; j < charArr.length; j++) {
                    tmp.append(charArr[j]);
                    if (charArr[j] == '>') {
                        words.add(tmp.toString());
                        codes.add(1);
                        i = j;
                        break;
                    }
                }
                continue;
            }
            if (charArr[i] == ' ') {
                words.add(String.valueOf(charArr[i]));
                codes.add(1);
                continue;
            }
            StringBuilder tmp = new StringBuilder();
            for (int j = i; j < charArr.length; j++) {
                char c = charArr[j];
                if (c == '<' || c == ' ') {
                    i = j - 1;
                    words.add(tmp.toString());
                    codes.add(0);
                    break;
                }
                tmp.append(c);
                if (j == charArr.length - 1) {
                    words.add(tmp.toString());
                    codes.add(0);
                    i = j;
                }
            }
        }

        for (int i = 0; i < words.size(); i++) {
            int code = codes.get(i);
            if (code == 1) {
                System.out.print(words.get(i));
            } else {
                String word = words.get(i);
                String reverse_word = new StringBuffer(word).reverse().toString();
                System.out.print(reverse_word);
            }
        }
    }
}
