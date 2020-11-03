import java.util.ArrayList;
import java.util.Scanner;

public class boj_1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> primes = getPrime(n);
        solution(primes, n);
    }

    public static void solution(ArrayList<Integer> primes, int n) {
        int cnt = 0 ;
        int head = 0;
        int tail = 0;
        long sum = 0;

        while(true){
            if(sum>=n) sum-=primes.get(tail++);
            else if(head==primes.size()) break;
            else if(sum<n) sum+=primes.get(head++);
            if(sum==n) cnt++;
        }
        System.out.println(cnt);
    }


    public static ArrayList getPrime(int n){
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Boolean> list = new ArrayList<>(n+1);
        list.add(false);
        list.add(false);
        for(int i=2;i<=n;i++)
            list.add(i, true);
        for (int i = 2; (i * i) <= n; i++) {
            if (list.get(i)) {
                for(int j=i*i;j<=n;j+=i)
                    list.set(j, false);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (list.get(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
