import java.util.Scanner;

public class boj_14888 {
    static int maxValue=-1000000000;
    static int minValue=1000000000;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int []num=new int[n];
        int []sik=new int[n-1];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int index=0;
        for (int i = 0; i < 4; i++) {
            int tmp=sc.nextInt();
            for (int j = 0; j < tmp; j++) {
                sik[index++] = i;
            }
        }
        permutation(sik,num,0,n-1,n-1);
        System.out.println(maxValue);
        System.out.println(minValue);
        return;
    }

    static void permutation(int[] sik,int []num, int depth, int n, int r) {
        if (depth == r) {
            int temp=num[0];
            for (int i = 0; i < n; i++) {
                switch(sik[i]){
                    case 0:
                        temp+=num[i+1];
                        break;
                    case 1:
                        temp-=num[i+1];
                        break;
                    case 2:
                        temp*=num[i+1];
                        break;
                    case 3:
                        temp/=num[i+1];
                        break;
                    default: break;
                }
            }
            maxValue=Math.max(maxValue,temp);
            minValue=Math.min(minValue,temp);
        }

        for (int i = depth; i < n; i++) {
            swap(sik,depth,i);
            permutation(sik,num,depth+1,n,r);
            swap(sik,depth,i);
        }

    }

    static void swap(int[] sik, int depth, int i) {
        int temp=sik[depth];
        sik[depth]=sik[i];
        sik[i]=temp;
    }
}
