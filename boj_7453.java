import java.util.*;

public class boj_7453 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer=0;
        int n = sc.nextInt();
        long[][] box=new long[n][4];
        long[] ab = new long[n * n];
        long[] cd = new long[n * n];
        for (int i = 0; i < n; i++) {
            box[i][0] = sc.nextInt();
            box[i][1] = sc.nextInt();
            box[i][2] = sc.nextInt();
            box[i][3] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i * n + j] = box[i][0] + box[j][1];
                cd[i * n + j] = box[i][2] + box[j][3];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
        for (int i = 0; i < n * n; i++) {
            long tmp = ab[i];
            int v1 = upperbound(cd, -tmp);
            int v2 = lowerbound(cd, -tmp);
            if(v1==v2) continue;
            answer += v1 - v2;
        }
        System.out.println(answer);
    }

    static int lowerbound(long[] arr, long target) {
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (right >= left) {
            mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int upperbound(long[] arr, long target) {
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (right >= left) {
            mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
