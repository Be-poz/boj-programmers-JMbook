import java.util.*;

public class boj_17678 {
    public static void main(String[] args) {
        String[] timetable = {"09:10","09:09","08:00"};
        System.out.println(solution(2,10,2,timetable));
    }

    static String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];
        ArrayList<Integer> last = new ArrayList<>();
        for (int i = 0; i < timetable.length; i++) {
            String time = timetable[i];
            String tokens[] = time.split(":");
            times[i] = Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
        }
        Arrays.sort(times);
        int start=540-t;
        int idx=0;
        int cnt;
        for (int i = 0; i < n; i++) {
            start+=t;
            cnt=0;
            for (int j = idx; j < times.length; j++) {
                if (times[idx] <= start) {
                    if (i == n - 1) {
                        last.add(times[idx]);
                    }
                    cnt++;
                    idx++;
                    if(cnt==m) break;
                }else break;
            }
        }
        if (last.size() < m) {
            return answer(start);
        }
        cnt=0;
        for (int i = 0; i < last.size(); i++) {
            cnt++;
            if(cnt==m) start=last.get(i)-1;
        }

        return answer(start);
    }

    static String answer(int num) {
        String answer="";
        int hour=num/60;
        int min=num%60;
        if(hour<10) {
            answer+="0";
            answer+=hour;
        }else answer+=hour;
        answer+=":";
        if (min < 10) {
            answer+="0";
            answer+=min;
        }else answer+=min;
        return answer;
    }
}

