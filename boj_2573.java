package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj2573 {

	static class xy{
		int x,y;
		xy(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int cnt=0;
	static int n,m;
	static int[][] visit;
	static int[][] iceberg;
	static int[][]dir= {{1,0},{-1,0},{0,1},{0,-1}};
	static ArrayList<xy> loc=new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int year_cnt=0;
		n=sc.nextInt();
		m=sc.nextInt();
		iceberg=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int temp=sc.nextInt();
				if(temp!=0)
					loc.add(new xy(i,j));
				iceberg[i][j]=temp;
			}
		}
		
		if(separated()==true) {
			System.out.println(year_cnt);
		}
		else while(true) {
				boolean complete=melt();
				year_cnt++;
				if(complete) {
					System.out.println(0);
					break;
				}
				if(separated()) {
					System.out.println(year_cnt);
					break;
				}
			}
		sc.close();
	}
	
	public static boolean melt() {
		int [][]changed_iceberg=new int[n][m];
		ArrayList<xy> changed_loc=new ArrayList<>();
		int size=loc.size();
		for(int i=0;i<size;i++) {
			int z_cnt=0;
			xy temp=loc.get(i);
			int cur_x=temp.x;
			int cur_y=temp.y;
			for(int j=0;j<4;j++) {
				int x2=cur_x+dir[j][0];
				int y2=cur_y+dir[j][1];
				if(x2>=0&&x2<n&&y2>=0&&y2<m&&iceberg[x2][y2]==0)
					z_cnt++;
			}
			if(iceberg[cur_x][cur_y]>z_cnt) {
				changed_iceberg[cur_x][cur_y]=iceberg[cur_x][cur_y]-z_cnt;
				changed_loc.add(new xy(cur_x,cur_y));
			}
		}
		if(changed_loc.size()==0) return true;
		loc=changed_loc;
		iceberg=changed_iceberg;
		return false;
	}
	
	public static boolean separated() {
		int size=loc.size();
		xy temp=loc.get(0);
		int x=temp.x;
		int y=temp.y;
		visit=new int[n][m];
		cnt=1;
		dfs(x,y);
		if(size==cnt) return false;
		else return true;
	}
	
	public static void dfs(int x,int y) {
		visit[x][y]=1;
		for(int i=0;i<4;i++) {
			int x2=x+dir[i][0];
			int y2=y+dir[i][1];
			if(x2>=0&&x2<n&&y2>=0&&y2<m&&iceberg[x2][y2]!=0&&visit[x2][y2]==0) {
				cnt++;
				dfs(x2, y2);
			}
		}
		return;
	}
}
