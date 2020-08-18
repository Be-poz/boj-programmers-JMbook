import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] pack=new int[m];
        int[] one=new int[m];
        int sum=0;
        for (int i = 0; i < m; i++) {
            pack[i]=sc.nextInt();
            one[i]=sc.nextInt();
        }
        Arrays.sort(pack);
        Arrays.sort(one);

        if(one[0]*6<pack[0]){
            System.out.println(one[0]*n);
            return;
        }
        int pack_cnt=n/6;
        int rest=n%6;
        if(rest*one[0]>pack[0])
            sum=(pack_cnt+1)*pack[0];
        else sum=pack_cnt*pack[0]+rest*one[0];
        System.out.println(sum);
    }
}
