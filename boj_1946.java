import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class boj_1946 {
    static class xy{
        int x=0,y=0;

        xy(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            ArrayList<xy> list = new ArrayList<>();
            int n=sc.nextInt();
            int cnt=0;
            for (int j = 0; j < n; j++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                list.add(new xy(x, y));
            }
            Collections.sort(list, new Comparator<xy>() {
                @Override
                public int compare(xy o1, xy o2) {
                    int x1=o1.x;
                    int x2=o2.x;
                    if(x1>x2) return 1;
                    else return -1;
                }
            });
            int minValue=list.get(0).y;
            for (int a = 0; a < n; a++) {
                if(a==0) continue;
                if(list.get(a).y>minValue){
                    cnt++;
                }
                minValue=Math.min(minValue,list.get(a).y);
            }
            System.out.println(n-cnt);
        }
    }
}
