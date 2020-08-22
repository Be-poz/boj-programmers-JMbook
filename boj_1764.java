import java.util.*;

public class boj_1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            set.add(tmp);
        }
        for (int i = 0; i < m; i++) {
            String tmp = sc.next();
            if(set.contains(tmp))
                list.add(tmp);
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (String tmp : list) {
            System.out.println(tmp);
        }
    }
}
