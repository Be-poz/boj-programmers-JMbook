package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj11559 {

	static class xy{
		int x,y;
		xy(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int[][] board=new int[12][6];
	static int visit[][]=new int[12][6];
	static int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<12;i++) {
			String sen=sc.next();
			for(int j=0;j<sen.length();j++) {
				char temp=sen.charAt(j);
				switch(temp) {
				case '.': board[i][j]=0;
							break;
				case 'Y': board[i][j]=1;
							break;
				case 'G': board[i][j]=2;
							break;
				case 'R': board[i][j]=3;
							break;
				case 'P': board[i][j]=4;
							break;
				case 'B': board[i][j]=5;
							break;
				default: break;
								
				}
			}
		}
		System.out.println(solve());
		sc.close();
	}
	
	public static int solve() {
		int cnt=0;
		while(ispop()) {				//ÅÍÆ®¸±°Å ÀÖ³ª ¹°»ö
			pop();						//ÅÍÆ®·Á ÁáÀ½
			admit();					//»Ñ¿ä ¹ØÀ¸·Î ³»·ÁÁÜ
			cnt++;
		}
		return cnt;
	}
	
	public static boolean ispop() {
		visit=new int[12][6];
		boolean chk=false;
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(board[i][j]!=0&&visit[i][j]==0)
					chk=ispop_bfs(i,j);
				if(chk==true) return chk;
			}
		}
		return chk;
	}
	
	public static boolean ispop_bfs(int x,int y) {
		Queue<xy> que=new LinkedList<>();
		int cnt=1;
		int color=board[x][y];
		que.add(new xy(x,y));
		while(!que.isEmpty()) {
			xy temp=que.poll();
			visit[temp.x][temp.y]=1;
			for(int i=0;i<4;i++) {
				int x2=temp.x+dir[i][0];
				int y2=temp.y+dir[i][1];
				if(x2>=0&&x2<12&&y2>=0&&y2<6&&visit[x2][y2]==0) {
					if(board[x2][y2]==color) {
						que.add(new xy(x2,y2));
						cnt++;
					}
				}
			}
		}
		if(cnt>=4) return true;
		else return false;
	}
	
	public static void pop() {
		visit=new int[12][6];
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(board[i][j]!=0&&visit[i][j]==0) {
					pop_bfs(i,j);
				}
			}
		}
	}
	
	public static void pop_bfs(int x,int y) {
		Queue<xy> que=new LinkedList<>();
		ArrayList<xy> save=new ArrayList<>();
		int cnt=1;
		int color=board[x][y];
		save.add(new xy(x,y));
		que.add(new xy(x,y));
		while(!que.isEmpty()) {
			xy temp=que.poll();
			visit[temp.x][temp.y]=1;
			for(int i=0;i<4;i++) {
				int x2=temp.x+dir[i][0];
				int y2=temp.y+dir[i][1];
				if(x2>=0&&x2<12&&y2>=0&&y2<6&&visit[x2][y2]==0) {
					if(board[x2][y2]==color) {
						que.add(new xy(x2,y2));
						cnt++;
						save.add(new xy(x2,y2));
					}
				}
			}
		}
		if(cnt>=4) {
			for(int i=0;i<save.size();i++) {
				xy temp=save.get(i);
				board[temp.x][temp.y]=0;
			}
		}
	}
	
	public static void admit() {
		ArrayList<Integer> save=new ArrayList<>();
		for(int i=0;i<6;i++) {
			for(int j=11;j>=0;--j) {
				if(board[j][i]!=0)
					save.add(board[j][i]);
			}
			int x=11;
			for(int j=0;j<save.size();j++) {
				board[x--][i]=save.get(j);
			}
			for(int j=0;j<=x;j++) {
				board[j][i]=0;
			}
			
			save.clear();
		}
	}
}
