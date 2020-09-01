import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj_9466 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            Set<Integer> cycleList = new HashSet<>();
            Set<Integer> nocycleList = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt() - 1;
                if(i==arr[i]) cycleList.add(i);
            }
            for (int i = 0; i < n; i++) {
                if(cycleList.contains(i)) continue;
                if(nocycleList.contains(i)) continue;
                isCycle(i,cycleList,arr,nocycleList);
            }
            System.out.println(n-cycleList.size());
        }
    }

    static void isCycle(int num,Set<Integer> cycleList, int[] arr, Set<Integer> nocycleList) {
        Set<Integer> list = new HashSet<>();
        Set<Integer> noList = new HashSet<>();
        int n = num;
        list.add(n);

        while (true) {
            n = arr[n];
            if(nocycleList.contains(n)){
                nocycleList.addAll(noList);
                return;
            }
            if(cycleList.contains(n)){
                nocycleList.addAll(noList);
                return;
            }
            if (list.contains(n)) {
                list.clear();
                list.add(n);
                while (true) {
                    n=arr[n];
                    if(list.contains(n)){
                        cycleList.addAll(list);
                        return;
                    }
                    list.add(n);
                }
            }
            list.add(n);
            noList.add(n);
        }
    }
}
