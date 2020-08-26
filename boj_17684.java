import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class boj_17684 {
    public static void main(String[] args) {
        int[] answer=solution("ABABABABABABABAB");
        for (int ans : answer) {
            System.out.print(ans+" ");
        }
    }

    static int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        int idx=27;
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(Character.toString(alphabet[i-1]),i);
        }
        String tmp="";
        for (int i = 0; i < msg.length(); i++) {
            tmp="";
            tmp += msg.charAt(i);
            for (int j = i + 1; j < msg.length(); j++) {
                tmp+=msg.charAt(j);
                if (map.containsKey(tmp)) {
                    i++;
                    continue;
                } else {
                    map.put(tmp,idx++);
                    tmp = tmp.substring(0, tmp.length() - 1);
                    break;
                }
            }
            answer.add(map.get(tmp));
        }
        int[] answerarr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerarr[i]=answer.get(i);
        }
        return answerarr;
    }
}
