import java.util.Scanner;

public class boj_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        int cnt=0;
        for (int i = 0; i <= a.length() - b.length(); i++) {
            String cmp=a.substring(i,i+b.length());
            if(cmp.equals(b)){
                cnt++;
                i+=b.length()-1;
            }
        }
        System.out.println(cnt);
    }
}
