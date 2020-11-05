package programmers;

import java.util.Scanner;

public class boj9663 {
	static int [] a,l,r; 
	static int cnt=0; 
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n];			//세로
		l=new int[n*2-1];			//   '/' 대각선
		r=new int[n*2-1];			//   '\' 대각선
		solve(0);
		System.out.println(cnt);
		sc.close();
	}
	
	public static void solve(int i) {
		if(i==n) {
			cnt++;
			return;
		}
		for(int j=0;j<n;j++) {
			if(a[j]==1||l[i+j]==1||r[i-j+n-1]==1) continue;
			a[j]=l[i+j]=r[i-j+n-1]=1;
			solve(i+1);
			a[j]=l[i+j]=r[i-j+n-1]=0;
		}
	}
}
