import java.util.*;

public class boj_2437 {
    public static void main(String[] args) {
        List<Integer> chu = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            chu.add(sc.nextInt());
        }
        chu.sort(Comparator.naturalOrder());

        int sum = 0;
        for (int i = 0; i < chu.size(); i++) {
            if (chu.get(i) > sum + 1) {
                System.out.println(sum + 1);
                return;
            }
            sum += chu.get(i);
        }
        System.out.println(sum + 1);
    }
}
