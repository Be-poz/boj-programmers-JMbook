package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj6593 {
	
	static class xyz{
		int x,y,z;
		xyz(int x,int y,int z){
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
	
	static int L,R,C;
	static int[][][] b;
	static int[][][] visit;
	static int dir[][]= {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=0,y=0,z=0;
		while(true) {
			L=sc.nextInt();
			R=sc.nextInt();
			C=sc.nextInt();
			if(L==0&&R==0&&C==0) break;
			b=new int[L][R][C];
			for(int i=0;i<L;i++) {
				for(int j=0;j<R;j++) {
					String temp=sc.next();
					for(int k=0;k<C;k++) {
						char info=temp.charAt(k);
						if(info=='.') b[i][j][k]=0;
						if(info=='#') b[i][j][k]=1;
						if(info=='S') {
							b[i][j][k]=8;
							x=i;
							y=j;
							z=k;
						}
						if(info=='E') b[i][j][k]=9;
					}
				}
				//System.out.println();
			}
			solve(x,y,z);
		}
		sc.close();
	}
	
	public static void solve(int x,int y,int z) {
		Queue<xyz> que=new LinkedList<>();
		visit=new int[L][R][C];
		que.add(new xyz(x,y,z));
		int cnt=0;
		while(!que.isEmpty()) {
			int size=que.size();
			cnt++;
			for(int s=0;s<size;s++) {
				xyz temp=que.poll();
				visit[x][y][z]=1;
				for(int i=0;i<6;i++) {
					int x2=temp.x+dir[i][0];
					int y2=temp.y+dir[i][1];
					int z2=temp.z+dir[i][2];
					if(x2>=0&&x2<L&&y2>=0&&y2<R&&z2>=0&&z2<C) {
						if(visit[x2][y2][z2]==0&&b[x2][y2][z2]!=1) {
							if(b[x2][y2][z2]==9) {
								System.out.println("Escaped in "+cnt+" minute(s).");
								return;
							}
							if(b[x2][y2][z2]==0) {
								que.add(new xyz(x2,y2,z2));
								b[x2][y2][z2]=8;
							}
						}
					}
				}
			}
		}
		System.out.println("Trapped!");
		return;
	}
}
