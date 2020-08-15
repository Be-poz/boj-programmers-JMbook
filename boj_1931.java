import java.util.*;

public class boj_1931 {
    static class xy{
        int x=0,y=0;
        xy(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<xy> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            list.add(new xy(x,y));
        }
        Collections.sort(list, new Comparator<xy>() {
            @Override
            public int compare(xy o1, xy o2) {
                int x1=o1.x;
                int y1=o1.y;
                int x2=o2.x;
                int y2=o2.y;
                if(y1>y2) return 1;
                else if(y1<y2) return-1;
                else if(y1==y2){
                    if(x1>x2) return 1;
                    else return -1;
                }
                return 0;
            }
        });

        System.out.println(solution(n,list));
    }

    static int solution(int n,ArrayList<xy> list){
        int cnt=1;
        int tmp=list.get(0).y;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).x>=tmp){
                cnt++;
                tmp=list.get(i).y;
            }
        }
        return cnt;
    }
}
