package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7562 {
	
	static class xy{
		int x,y;
		xy(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int[][]dir= {{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1}};
	static int[][]board;
	static int l;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c;
		c=sc.nextInt();
		for(int i=0;i<c;i++) {
			l=sc.nextInt();
			board=new int[l][l];
			int a=sc.nextInt();
			int b=sc.nextInt();
			int obj_x=sc.nextInt();
			int obj_y=sc.nextInt();
			if(a==obj_x&&b==obj_y) System.out.println(0); 
			else System.out.println(bfs(a,b,obj_x,obj_y));
			filled();
		}
		sc.close();
	}
	
	public static int bfs(int x,int y,int obj_x,int obj_y) {
		Queue<xy> que=new LinkedList<>();
		board[x][y]=1;
		que.add(new xy(x,y));
		int cnt=0;
		while(!que.isEmpty()) {
			int size=que.size();
			cnt++;
			for(int k=0;k<size;k++) {
				xy cls=que.poll();
				int cur_x=cls.x;
				int cur_y=cls.y;
				for(int i=0;i<8;i++) {
					int x2=cur_x+dir[i][0];
					int y2=cur_y+dir[i][1];
					if(x2>=0&&x2<l&&y2>=0&&y2<l&&board[x2][y2]==0) {
						que.add(new xy(x2,y2));
						board[x2][y2]=1;
					}
					if(x2==obj_x&&y2==obj_y) return cnt;
				}
			}
		}
		return cnt;
	}
	
	public static void filled() {
		int size=board.length;
		for(int i=0;i<size;i++) {
			Arrays.fill(board[i], 0);
		}
	}
}
