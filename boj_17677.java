import java.util.HashMap;
import java.util.Map;

public class boj_17677 {
    public static void main(String[] args) {
        System.out.println(solution("france", "french"));
    }

    static int solution(String str1, String str2) {
        Map<String, Integer> map_a = new HashMap<>();
        Map<String, Integer> map_b = new HashMap<>();
        double max_cnt=0;
        double min_cnt=0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 0; i < str1.length()-1; i++) {
            String tmp = str1.substring(i, i + 2);
            if (!Character.isLetter(tmp.charAt(0))||!Character.isLetter(tmp.charAt(1))) continue;
            if (map_a.containsKey(tmp)) {
                map_a.replace(tmp, map_a.get(tmp) + 1);
            } else {
                map_a.put(tmp,1);
            }
        }

        for (int i = 0; i < str2.length()-1; i++) {
            String tmp = str2.substring(i, i + 2);
            if (!Character.isLetter(tmp.charAt(0))||!Character.isLetter(tmp.charAt(1))) continue;
            if (map_b.containsKey(tmp)) {
                map_b.replace(tmp, map_b.get(tmp) + 1);
            } else {
                map_b.put(tmp,1);
            }
        }

        for (String key : map_a.keySet()) {
            if (map_b.containsKey(key)) {
                int a_value = map_a.get(key);
                int b_value = map_b.get(key);
                max_cnt += Math.max(a_value, b_value);
                min_cnt += Math.min(a_value, b_value);
            } else {
                max_cnt+=map_a.get(key);
            }
        }
        for (String key : map_b.keySet()) {
            if (!map_a.containsKey(key)) {
                max_cnt+=map_b.get(key);
            }
        }

        if(max_cnt==0)
            return 65536;
        return (int) ((min_cnt / max_cnt) * 65536);
    }
}