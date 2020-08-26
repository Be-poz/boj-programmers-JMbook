public class boj_17687 {
    public static void main(String[] args) {
        System.out.println(solution(16,16,2,2));
    }

    static String solution(int n, int t, int m, int p) {
        if(m==p) p=0;
        String answer="";
        String bit=getBit(n,t,m);
        int cnt=0;
        for (int i = 0; i < bit.length(); i++) {
            if ((i + 1) % m == p) {
                answer += bit.charAt(i);
                cnt++;
                if(cnt==t) break;
            }
        }
        return answer;
    }

    static String getBit(int n, int t, int m) {
        String answer="";
        int cnt=0;
        int num=0;
        while (cnt <= t * m) {
            String b = nBit(num++, n);
            answer+=b;
            cnt+=b.length();
        }
        return answer;
    }

    static String nBit(int num, int n) {
        String answer="";
        while (num >= n) {
            int mod=num%n;
            if(mod>=10) answer+=(char)('A'+mod-10);
            else answer+=mod;
            num/=n;
        }
        if(num>=10) answer+=(char)('A'+num-10);
        else answer+=num;
        return new StringBuffer(answer).reverse().toString();
    }
}
