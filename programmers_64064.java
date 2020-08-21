import java.util.HashSet;
import java.util.Set;

public class programmers_64064 {
    static Set<String> already_banned = new HashSet<>();
    static Set<String> done_string = new HashSet<>();
    static int cnt=0;
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        System.out.println(solution(user_id, banned_id));
    }

    static int solution(String[] user_id, String[] banned_id) {
        String[][] fit = new String[banned_id.length][user_id.length];
        int[] visit = new int[user_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            fit_in(user_id, banned_id[i], fit, i);
        }
        tracking(user_id,banned_id,fit,0,visit);
        return cnt;
    }

    static void fit_in(String[] user_id, String banned_id, String[][] fit, int n) {
        int blen=banned_id.length();
        int idx=0;
        for (String id : user_id) {
            if(id.length()!=blen) continue;
            boolean flag=false;
            for (int i = 0; i < blen; i++) {
                if(banned_id.charAt(i)=='*'){
                    if(i==blen-1) flag=true;
                    else continue;
                }
                if(banned_id.charAt(i)!=id.charAt(i)) break;
                if(i==blen-1) flag=true;
            }
            if(flag)
                fit[n][idx++]=id;
        }
    }

    static void tracking(String[] user_id, String[] banned_id, String[][] fit, int depth, int[] visit) {
        if (depth == banned_id.length) {
            String visitStr="";
            for (int vis : visit) {
                visitStr+=vis;
            }
            if (done_string.contains(visitStr)) {
                return;
            } else {
                done_string.add(visitStr);
                cnt++;
                return;
            }
        }

        for (int i = 0; i < fit[depth].length; i++) {
            if (fit[depth][i] == null) return;
            if (already_banned.contains(fit[depth][i])) continue;
            already_banned.add(fit[depth][i]);
            for (int j = 0; j < user_id.length; j++) {
                if(user_id[j]==fit[depth][i]){
                    visit[j]=1;
                    break;
                }
            }
            tracking(user_id, banned_id, fit, depth + 1, visit);
            already_banned.remove(fit[depth][i]);
            for (int j = 0; j < user_id.length; j++) {
                if(user_id[j]==fit[depth][i]){
                    visit[j]=0;
                    break;
                }
            }
        }

    }
}
