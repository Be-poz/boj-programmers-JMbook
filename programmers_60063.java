import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_60063 {

    static int[][] direction ={{0,1},{1,0},{0,-1},{-1,0}};       // 상 우 하 좌 순서이다. 밑의 dir과 i 값을 맞추기 위함이다.
    static int[][] visit;

    static class info{
        int x=0,y=0,dir=0,cnt=0;          // dir은 상 우 하 좌  순으로 0,1,2,3
        info(int x,int y,int dir,int cnt){
            this.x=x;
            this.y=y;
            this.dir=dir;
            this.cnt=cnt;
        }
    }

    public static void main(String[] args) {
        int[][] board={{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        visit=new int[board.length][board.length];
        visit[0][0]=1;visit[0][1]=1;
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int length=board[0].length;
        return bfs(0,1,board);
    }

    public static int bfs(int x,int y,int[][] board){
        Queue<info> que=new LinkedList<>();
        int length=board[0].length;
        que.add(new info(x,y,1,0));
        int cnt=0;

        while (!que.isEmpty()) {
            info tmpInfo=que.poll();
            int xx=tmpInfo.x;
            int yy=tmpInfo.y;
            int dir=tmpInfo.dir;
            int ccnt=tmpInfo.cnt;
            for(int i=0;i<4;i++){
                xx+=direction[i][0];
                yy+=direction[i][1];
                if(xx==length-1&&yy==length-1)
                    return ccnt+1;
                if(xx<0||yy<0||xx>=length||yy>=length) continue;
                if(board[xx][yy]==1) continue;
                if(visit[xx][yy]==1) continue;

                switch(dir){
                    case 0:
                        if(dir==i){
                            que.add(new info(xx,yy,i,ccnt+1));
                            visit[xx][yy]=1;
                            break;
                        }
                        else if(i==1||i==3){
                            if(board[xx][yy-1]==1) break;
                            else{
                                que.add(new info(xx,yy,i,ccnt+1));
                                visit[xx][yy]=1;
                                break;
                            }
                        }
                        else break;
                    case 1:
                        if(dir==i){
                            que.add(new info(xx,yy,i,ccnt+1));
                            visit[xx][yy]=1;
                            break;
                        }
                        else if(i==0||i==2){
                            if(board[xx-1][yy]==1) break;
                            else{
                                que.add(new info(xx,yy,i,ccnt+1));
                                visit[xx][yy]=1;
                                break;
                            }
                        }
                        else break;
                    case 2:
                        if(dir==i){
                            que.add(new info(xx,yy,i,ccnt+1));
                            visit[xx][yy]=1;
                            break;
                        }
                        else if(i==1||i==3){
                            if(board[xx][yy+1]==1) break;
                            else{
                                que.add(new info(xx,yy,i,ccnt+1));
                                visit[xx][yy]=1;
                                break;
                            }
                        }
                        else break;
                    case 3:
                        if(dir==i){
                            que.add(new info(xx,yy,i,ccnt+1));
                            visit[xx][yy]=1;
                            break;
                        }
                        else if(i==0||i==2){
                            if(board[xx+1][yy]==1) break;
                            else{
                                que.add(new info(xx,yy,i,ccnt+1));
                                visit[xx][yy]=1;
                                break;
                            }
                        }
                        else break;
                }
            }
        }
        return 0;
    }
}
