package programmers;

import java.util.Scanner;
//타일 장식물
public class programmers_43104 {
	public static void main(String []args) {
		int pibo[]=new int[81];
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		pibo[1]=1;
		pibo[2]=1;
		if(n==1) {
			System.out.println(4);
			return;
		}
		if(n==2) {
			System.out.println(6);
			return;
		}
		for(int i=3;i<=n;i++) {
			pibo[i]=pibo[i-1]+pibo[i-2];
		}
		int sum=(pibo[n]+pibo[n-1]*2+pibo[n-2])*2;
		System.out.println(sum);
		return;
	}
}

//class Solution {
//    public long solution(int n) {
//		if(n==1)
//			return 4;
//		if(n==2)
//			return 6;
//        long pibo[]=new long[n+1];
//		pibo[1]=1;
//		pibo[2]=1;
//		for(int i=3;i<=n;i++) {
//			pibo[i]=pibo[i-1]+pibo[i-2];
//		}
//		return (pibo[n]*2+pibo[n-1])*2;
//    }
//}
