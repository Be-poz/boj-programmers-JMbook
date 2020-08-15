import java.util.*;

public class boj_10610 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n = sc.next();
        int[] ary = new int[n.length()];
        int sum=0;
        for(int i=0;i<n.length();i++){
            int tmp=n.charAt(i)-'0';
            sum+=tmp;
            ary[i]=tmp;
        }

        Arrays.sort(ary);
        if(sum%3!=0||ary[0]!=0){
            System.out.println("-1");
            return;
        }

        String answer="";
        for (int i = ary.length - 1; i >= 0; i--) {
            answer+=ary[i];
        }
        System.out.println(answer);
    }
}