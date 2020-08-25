import java.util.LinkedList;
import java.util.Queue;

public class boj_17680 {
    public static void main(String[] args) {
        String[] cities = {"1", "2", "3", "2", "4"};
        System.out.println(solution(3,cities));
    }

    static int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length*5;
        int answer=0;
        Queue<String> que = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String tmp=cities[i].toLowerCase();
            if (!que.contains(tmp)) {           //miss
                if (que.size() == cacheSize) {  //꽉 차있으면 앞에거 삭제 후 집어넣고
                    que.poll();
                }
                que.add(tmp);                   //아니면 그냥 집어넣음
                answer += 5;
            } else {                            //hit
                answer++;
                int len=que.size();
                for (int j = 0; j < len; j++) { //hit 된 놈 놔두고 돌리다가 마지막에 추가
                    String tmp2=que.poll();
                    if (!tmp2.equals(tmp))
                        que.add(tmp2);
                }
                que.add(tmp);
            }
        }
        return answer;
    }
}
