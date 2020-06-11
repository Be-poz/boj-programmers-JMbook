package programmers;

import java.util.Scanner;

//¸Ö¸® ¶Ù±â
public class programmers_12914 {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num==1) {
			System.out.println(1);
			return;
		}
		int div=num/2;
		int sum=1;
		for(int i=1;i<=div;i++) {
			int n=num-i*2+i;
			int r=Math.min(i,n-i);
			sum+=combination(n,r)%1234567;
			sum%=1234567;
		}
		System.out.println(sum);
		return;
	}
	
	public static int combination(int n, int r) {
		if(n==r||r==0) return 1;
		else return combination(n-1,r-1)+combination(n-1,r);
	}
}



//class Solution {
//    public long solution(int num) {
//        int []pibo=new int[2001];
//        pibo[1]=1;
//        pibo[2]=2;
//        if(num<=2) return pibo[num];
//        for(int i=3;i<=num;i++){
//            pibo[i]=pibo[i-1]+pibo[i-2];
//            pibo[i]%=1234567;
//        }
//        return pibo[num];
//    }
//}