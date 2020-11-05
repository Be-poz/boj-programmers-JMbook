import java.util.Scanner;

public class boj_2559 {
    static int n,k;
    static int[] temper;    //temperature
    public static void main(String[] args) {
        valueInsert();
        System.out.println(solution());
    }

    public static int solution(){
        int maxTemper = Integer.MIN_VALUE;          //maxTemperature
        int tempTemper = 0;                         //tempTempreature
        int tail = 0;
        int head = k;
        for (int i = 0; i < k; i++) {
            tempTemper += temper[i];
        }
        maxTemper = Math.max(maxTemper, tempTemper);
        for (int i = k; i < n; i++) {
            tempTemper += temper[head++];
            tempTemper -= temper[tail++];
            maxTemper = Math.max(maxTemper, tempTemper);
        }
        return maxTemper;
    }


    public static void valueInsert(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        temper = new int[n];
        for (int i = 0; i < n; i++) {
            temper[i] = sc.nextInt();
        }
        sc.close();
    }
}
