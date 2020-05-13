package programmers;

import java.util.ArrayList;
import java.util.Scanner;

//public class FENCE {
//	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		int c,fence_length;
//		ArrayList<Integer> fence=new ArrayList<>();
//		c=sc.nextInt();
//		for(int i=0;i<c;i++) {
//			fence_length=sc.nextInt();
//			for(int j=0;j<fence_length;j++)
//				fence.add(sc.nextInt());
//			System.out.println(solve(fence));
//			fence.clear();
//		}
//		sc.close();
//	}
//	
//	public static int solve(ArrayList<Integer> fence) {
//		int max=0;
//		for(int i=0;i<fence.size();i++) {
//			int a=fence.get(i);
//			int b=1;
//			
//			if(i==fence.size()-1) {
//				max=Math.max(max,a);
//				break;
//			}
//			
//			for(int j=i+1;j<fence.size();j++) {
//				if(fence.get(j)>=a) b++;
//				else break;
//			}
//			max=Math.max(max,a*b);
//		}
//		return max;
//	}
//}
public class FENCE {
	static ArrayList<Integer> fence=new ArrayList<>();
	
	public static int solve(int left,int right) {
		if(left==right) return fence.get(left);
		int mid=(left+right)/2;
		int ret=Math.max(solve(left,mid), solve(mid+1,right));
		int height=Math.min(fence.get(mid),fence.get(mid+1));
		ret=Math.max(ret,height*2);
		int cur_l=mid;
		int cur_r=mid+1;
		while(cur_l>left||cur_r<right) {
			if(cur_l>left&&(cur_r==right||fence.get(cur_l-1)>=fence.get(cur_r+1))) {
				cur_l--;
				height=Math.min(height,fence.get(cur_l));
			}else{
				cur_r++;
				height=Math.min(height,fence.get(cur_r));
			}
			ret=Math.max(ret,height*(cur_r-cur_l+1));
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c,fence_length;
		c=sc.nextInt();
		for(int i=0;i<c;i++) {
			fence_length=sc.nextInt();
			for(int j=0;j<fence_length;j++)
				fence.add(sc.nextInt());
			System.out.println(solve(0,fence_length-1));
			fence.clear();
		}
		sc.close();
	}
}







