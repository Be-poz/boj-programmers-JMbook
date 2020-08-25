public class boj_17682 {
    public static void main(String[] args) {
        System.out.println(solution("1S*2T*3S"));
    }
    static int solution(String dartResult) {
        int[] number=new int[3];
        int idx=-1;
        int answer=0;
        boolean flag=true;
        for (int i = 0; i < dartResult.length(); i++) {
            char c=dartResult.charAt(i);
            if (Character.isDigit(c)) {
                if(flag) idx++;
                number[idx]=number[idx]*10+(c-'0');
                flag=false;
                continue;
            }
            flag=true;
            if(c=='S') continue;
            if(c=='D') number[idx]*=number[idx];
            if(c=='T') number[idx]*=number[idx]*number[idx];
            if(c=='#') number[idx]*=-1;
            if (c == '*') {
                if (idx == 0) {
                    number[idx] *= 2;
                } else {
                    number[idx]*=2;
                    number[idx-1]*=2;
                }
            }
        }
        for (int ans : number) {
            answer+=ans;
        }
        return answer;
    }
}
