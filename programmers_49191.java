import java.util.*;

public class programmers_49191 {
    static class wl{
        Set<Integer> win = new HashSet<>();
        Set<Integer> lose = new HashSet<>();
        wl(){
        }
    }

    public static void main(String[] args) {
        int[][] results = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8}};
        System.out.println(solution(8,results));
    }

    public static int solution(int n, int[][] results) {
        int answer=0;
        ArrayList<wl> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new wl());
        for (int[] result : results) {
            int a=result[0]-1;
            int b=result[1]-1;
            list.get(a).win.add(b);
            list.get(b).lose.add(a);
        }
        for (int depth = 0; depth < n; depth++) {
            for (int i = 0; i < n; i++) {
                wl now=list.get(i);
                Set<Integer> win=now.win;
                Set<Integer> lose=now.lose;
                Set<Integer> win_set = new HashSet<>();
                Set<Integer> lose_set = new HashSet<>();

                for (Integer tmp : win) {
                    for (Integer tmp2 : list.get(tmp).win) {
                        win_set.add(tmp2);
                    }
                }
                win.addAll(win_set);

                for (Integer tmp : lose) {
                    for (Integer tmp2 : list.get(tmp).lose) {
                        lose_set.add(tmp2);
                    }
                }
                lose.addAll(lose_set);
            }
        }
        for (wl tmp : list) {
            if(tmp.win.size()+tmp.lose.size()==n-1) answer++;
        }
        return answer;
    }
}



