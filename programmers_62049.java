package programmers;

import java.util.ArrayList;
import java.util.Scanner;
//종이 접기
public class programmers_62049 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		ArrayList<Integer> answer=new ArrayList<>();
		list.add(0);
		int n=sc.nextInt();
		answer=solve(list,n);
		int answer2[]=new int[(1<<n)-1];
		for(int i=0;i<answer.size();i++) {
			answer2[i]=answer.get(i);
		}
		for(int i=0;i<answer2.length;i++) {
			System.out.print(answer2[i]+" ");
		}
	}
	public static ArrayList<Integer> solve(ArrayList<Integer> answer,int n) {
		ArrayList<Integer> temp=new ArrayList<>();
		temp.addAll(answer);
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=1;i<n;i++) {
			for(int j=0;j<temp.size();j++) {
				if(j%2==1) list.add(temp.get(j));
				else if(temp.get(j)==0) {
					list.add(0);
					list.add(0);
					list.add(1);
				}else if(temp.get(j)==1) {
					list.add(0);
					list.add(1);
					list.add(1);
				}
			}
			temp.clear();
			temp.addAll(list);
			list.clear();
		}
		return temp;
	}
}


//class Solution {
//    public int[] solution(int n) {
//		ArrayList<Integer> list=new ArrayList<>();
//		int answer[]=new int[(1<<n)-1];
//		list.add(0);
//		solve(list,n,answer);
//        return answer;
//    }
//	public static void solve(ArrayList<Integer> answer,int n,int [] result) {
//		ArrayList<Integer> temp=new ArrayList<>();
//		temp.addAll(answer);
//		ArrayList<Integer> list=new ArrayList<>();
//		for(int i=1;i<n;i++) {
//			for(int j=0;j<temp.size();j++) {
//				if(j%2==1) list.add(temp.get(j));
//				else if(temp.get(j)==0) {
//					list.add(0);
//					list.add(0);
//					list.add(1);
//				}else if(temp.get(j)==1) {
//					list.add(0);
//					list.add(1);
//					list.add(1);
//				}
//			}
//			temp.clear();
//			temp.addAll(list);
//			list.clear();
//		}
//		for(int i=0;i<temp.size();i++){
//            result[i]=temp.get(i);
//        }
//	}
//}
