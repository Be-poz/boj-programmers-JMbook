import java.util.*;

public class boj_1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []order=new int[k];
        int cnt=0;
        for (int i = 0; i < k; i++) {
            order[i]=sc.nextInt();
        }
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < k; i++) {
            if(set.contains(order[i])) continue;
            if (set.size() < n) {
                set.add(order[i]);
                continue;
            }
            Iterator<Integer> it = set.iterator();
            int value=0;
            int idx=0;
            while (it.hasNext()) {
                int tmp=it.next();
                boolean flag=false;
                for (int j = i + 1; j < k; j++) {
                    if(order[j]==tmp){
                        if(j>idx){
                            idx=j;
                            value=tmp;
                        }
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    value=tmp;
                    break;
                }
            }
            set.remove(value);
            set.add(order[i]);
            cnt++;
        }
        System.out.println(cnt);
    }
}
