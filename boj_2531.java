import java.util.*;

public class boj_2531 {
    static int n,d,k,c;
    static int[] sushi;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        valueInsert();
        System.out.println(solution());
    }

    private static int solution(){
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            que.add(sushi[i]);
            set.add(sushi[i]);
        }
        set.add(c);
        int tempCount = set.size();
        int maxCount = tempCount;
        int tailIndex = 0;
        while(true) {
            int pollValue = que.poll();
            tailIndex++;
            if (tailIndex == n) break;
            int insertValue = sushi[(tailIndex + k - 1) % n];
            que.add(insertValue);
            set.add(insertValue);
            if (!que.contains(pollValue) && pollValue != c) {
                set.remove(pollValue);
            }
            tempCount = set.size();
            maxCount = Math.max(maxCount, tempCount);
        }
        return maxCount;
    }

    private static void valueInsert() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();
        sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = sc.nextInt();
        }
        sc.close();
    }
}
