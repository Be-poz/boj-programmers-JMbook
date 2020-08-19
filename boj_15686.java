import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_15686 {
    static int[][] dir={{1,0},{-1,0},{0,-1},{0,1}};
    static int minValue=987654321;
    static int n=0;
    static int m=0;
    static class xy{
        int x=0,y=0;

        xy(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        ArrayList<xy> home = new ArrayList<>();
        ArrayList<xy> chicken = new ArrayList<>();
        int chicken_cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int loc=sc.nextInt();
                if(loc==1) home.add(new xy(i, j));
                if(loc==2) {
                    chicken.add(new xy(i,j));
                    chicken_cnt++;
                }
            }
        }
        int[] visit = new int[chicken_cnt];
        combination(home,chicken,visit,0,chicken_cnt,m);
        System.out.println(minValue);
    }

    static void combination(ArrayList<xy> home,ArrayList<xy> chicken,int[] visit, int start, int n, int r) {
        if (r == 0) {
            ArrayList<xy> chicken_info = new ArrayList<>();
            int sum=0;
            for (int i = 0; i < visit.length; i++) {
                if (visit[i] == 1) {
                    chicken_info.add(new xy(chicken.get(i).x,chicken.get(i).y));
                }
            }
            for (int i = 0; i < home.size(); i++) {
                int x=home.get(i).x;
                int y=home.get(i).y;
                int mn=987654321;
                for (int j = 0; j < chicken_info.size(); j++) {
                    int x2=chicken_info.get(j).x;
                    int y2=chicken_info.get(j).y;
                    mn=Math.min(mn,Math.abs(x-x2)+Math.abs(y-y2));
                }
                sum+=mn;
                if(sum>minValue) return;
            }
            minValue=Math.min(minValue,sum);
            return;
        }
        for (int i = start; i < n; i++) {
            visit[i]=1;
            combination(home,chicken,visit,i+1,n,r-1);
            visit[i]=0;
        }
    }

    static int bfs(int x, int y, ArrayList<xy> chicken_xy) {
        Queue<xy> que = new LinkedList<>();
        int[][] visit=new int[n][n];
        que.add(new xy(x,y));
        visit[x][y]=1;
        int cnt=0;
        while (!que.isEmpty()) {
            boolean flag=false;
            int s=que.size();
            for (int c = 0; c < s; c++) {
                xy tmp=que.poll();
                int xx=tmp.x;
                int yy=tmp.y;
                for (int i = 0; i < 4; i++) {
                    int xx2=xx+dir[i][0];
                    int yy2=yy+dir[i][1];
                    if (xx2 >= 0 && xx2 < n && yy2 >= 0 && yy2 < n && visit[xx2][yy2] == 0) {
                        for (int j = 0; j < chicken_xy.size(); j++) {
                            xy tmp2=chicken_xy.get(j);
                            if(tmp2.x==xx2&&tmp2.y==yy2) return cnt+1;
                        }
                        que.add(new xy(xx2,yy2));
                        visit[xx2][yy2]=1;
                        flag=true;
                    }
                }
            }
            if(flag) cnt++;
        }
        return cnt;
    }
}
