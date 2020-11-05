package programmers;

import java.util.Arrays;
import java.util.Scanner;
//¹ßÀü¼Ò
public class boj1102 {
	static int n,goal;
	static int [][]bal;
	static int []dp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cnt=0;
		int visit=0;
		char []chars;
		n=sc.nextInt();
		bal=new int[n][n];
		dp=new int[1<<n];
		Arrays.fill(dp, -1);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				bal[i][j]=sc.nextInt();
			}
		}
		chars=sc.next().toCharArray();
		for(int i=0;i<chars.length;i++) {
			if(chars[i]=='Y') {
				visit=visit|(1<<i);
				cnt++;
			}
		}
		goal=sc.nextInt();
		int answer=(sol(visit, cnt))==987654321?-1:sol(visit, cnt);
		System.out.println(answer);
		
	}
	public static int sol(int visit,int cnt) {
		if(cnt>=goal)
			return 0;
		
		if(dp[visit]!=-1)
			return dp[visit];
		
		dp[visit]=987654321;
		
		for(int i=0;i<n;i++) {
			if((visit&(1<<i))==0) continue;
			for(int j=0;j<n;j++) {
				if((visit&(1<<j))!=0) continue;
				dp[visit]=Math.min(dp[visit],sol(visit|(1<<j), cnt+1)+bal[i][j]);
			}
		}
		return dp[visit];
	}
}
