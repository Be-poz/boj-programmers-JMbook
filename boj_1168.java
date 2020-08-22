import java.util.ArrayList;
import java.util.Scanner;

public class boj_1168 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt()-1;
        int idx=0;

        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }

        for (int i = 0; i < n; i++) {
            idx += k;
            idx %= list.size();
            int tmp=list.get(idx);
            answer.add(tmp);
            list.remove(idx);
        }

        StringBuilder stb = new StringBuilder();
        stb.append("<");
        for (int i = 0; i < answer.size()-1; i++) {
            stb.append(answer.get(i)+", ");
        }
        stb.append(answer.get(answer.size()-1)+">");
        System.out.println(stb.toString());
    }
}
