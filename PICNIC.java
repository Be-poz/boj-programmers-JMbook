package programmers;

import java.util.Scanner;

public class PICNIC {
	static int c,n,m;	//c:케이스 수, n:학생의 수, m:친구 쌍의 수
	static boolean areFriends[][]=new boolean[10][10];
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		c=scanner.nextInt();
		int result[]=new int[c];
		for(int i=0;i<c;i++) {
			System.out.println("학생의 수 : ");
			n=scanner.nextInt();
			System.out.println("친구 쌍의 수 : ");
			m=scanner.nextInt();
			boolean taken[]=new boolean[n];
			for(int j=0;j<m;j++) {
				int a=scanner.nextInt();
				int b=scanner.nextInt();
				areFriends[a][b]=true;
				areFriends[b][a]=true;
			}
			result[i]=countParings(taken);
		}
		for(int i=0;i<c;i++) {
			System.out.println(result[i]);
		}
		scanner.close();
	}
	
	static int countParings(boolean taken[]) {
		int firstFree=-1;
		for(int i=0;i<n;i++) {
			if(!taken[i]) {
				firstFree=i;
				break;
			}
		}
		if(firstFree==-1) {
			return 1;
		}
		
		int ret=0;
		for(int pairWith=firstFree+1;pairWith<n;pairWith++) {
			if(taken[pairWith]==false&&areFriends[pairWith][firstFree]==true) {
				taken[pairWith]=true;
				taken[firstFree]=true;
				ret+=countParings(taken);
				taken[pairWith]=false;
				taken[firstFree]=false;
			}
		}
		return ret;
	}
}
