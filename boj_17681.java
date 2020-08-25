public class boj_17681 {
    public static void main(String[] args) {
        int[] arr1 = {46,33,33,22,31,50};
        int[] arr2 = {27,56,19,14,14,10};
        String[] answer = solution(6, arr1, arr2);
        for (String ans : answer) {
            System.out.println(ans);
        }
    }

    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer=new String[n];

        for (int i = 0; i < n; i++) {
            String tmp = Integer.toBinaryString(arr1[i]|arr2[i]);
            if (tmp.length() < n) {
                String rtmp="";
                for (int k = 0; k < n-tmp.length(); k++) {
                    rtmp+=" ";
                }
                rtmp+=tmp;
                tmp=rtmp;
            }
            answer[i]="";
            for (int j = 0; j < tmp.length(); j++) {
                if(tmp.charAt(j)=='1') answer[i]+='#';
                else answer[i]+=' ';
            }
        }
        return answer;
    }
}
