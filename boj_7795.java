import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n,m;
        while (t-- > 0) {
            String[] nandm = br.readLine().split(" ");
            n = Integer.parseInt(nandm[0]);
            m= Integer.parseInt(nandm[1]);
            int[] a = new int[n];
            int[] b = new int[m];
            String[] nValue = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(nValue[i]);
            }
            String[] mValue = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(mValue[i]);
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int result = 0;
            int pivot = 0;
            for (int i = 0; i < n; i++) {
                if(pivot == 0 && b[pivot]>=a[i]) continue;
                while(true){
                    if(pivot==m) break;
                    if(a[i]>b[pivot]) pivot++;
                    else break;
                }
                result += pivot;
            }
            System.out.println(result);
        }
        br.close();
    }
}
