package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class hnm {
	int height;
	int garo;
	int sero;
	hnm(int x,int y,int z){
		height=x;
		sero=y;
		garo=z;
	}
}


public class boj7569 {
	static int box[][][];
	static Queue<hnm> que=new LinkedList<>();
	static int dir[][]= {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
	static int n,m,h;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean z_cnt=false;
		m=sc.nextInt();
		n=sc.nextInt();
		h=sc.nextInt();
		box=new int[h+1][n+1][m+1];
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=m;k++) {
					int temp=sc.nextInt();
					if(temp==1) 
						que.add(new hnm(i, j, k));
					if(z_cnt==false&&temp==0) z_cnt=true;
					box[i][j][k]=temp;
				}
			}
		}
		if(z_cnt==false) System.out.println(0);
		else System.out.println(bfs());
		sc.close();
	}
	
	public static int bfs() {
		int cnt=0;
		while(!que.isEmpty()) {
			int size=que.size();
			boolean changed=false;
			for(int i=0;i<size;i++) {
				hnm temp=que.poll();
				int x=temp.height;
				int y=temp.sero;
				int z=temp.garo;
				for(int j=0;j<6;j++) {
					int x2=x+dir[j][0];
					int y2=y+dir[j][1];
					int z2=z+dir[j][2];
					if(x2>0&&x2<=h&&y2>0&&y2<=n&&z2>0&&z2<=m&&box[x2][y2][z2]==0) {
						box[x2][y2][z2]=1;
						que.add(new hnm(x2,y2,z2));
						changed=true;
					}
				}
			}
			if(changed==true) cnt++;
		}
		cnt=filled()?cnt:-1;
		return cnt;
	}
	
	public static boolean filled() {
		boolean chk=true;
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=m;k++) {
					if(box[i][j][k]==0) {
						chk=false;
						return chk;
					}
				}
			}
		}
		return chk;
	}
}
