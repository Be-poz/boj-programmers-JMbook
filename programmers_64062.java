public class programmers_64062 {
    public static void main(String[] args) {
        int[] stones={2,4,5,3,2,1,4,2,5,1};
        int k=3;
        System.out.println(solution(stones,k));
    }
    static int solution(int[] stones, int k) {
        int left=0;
        int right=200000000;
        int pivot;
        while (right>=left) {
            pivot = (left + right) / 2;
            if (check(stones, k, pivot)) {
                left = pivot+1;
            } else {
                right = pivot - 1;
            }
        }
        return left-1;
    }

    static boolean check(int[] stones, int k, int pivot) {
        int cnt=0;
        for (int stone : stones) {
            if (stone < pivot){
                cnt++;
                if(cnt==k) return false;
            }else cnt=0;
        }
        return true;
    }
}
