package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class boj1759 {
	static int l,c;
	static ArrayList<Character> word=new ArrayList<>();
	static char[] w;
	static int[] used;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		l=sc.nextInt();
		c=sc.nextInt();
		w=new char[c];
		used=new int[c];
		for(int i=0;i<c;i++) {
			String temp=sc.next();
			word.add(temp.charAt(0));
		}
		Collections.sort(word);
		solve(0,new StringBuilder(""));
		sc.close();
	}
	public static void solve(int min,StringBuilder stb) {
		if(stb.length()==l) {
			int cnt=0;
			String temp=stb.toString();
			for(int i=0;i<temp.length();i++) {
				if(temp.charAt(i)=='a'||temp.charAt(i)=='e'||temp.charAt(i)=='i'||temp.charAt(i)=='o'||temp.charAt(i)=='u')
					cnt++;
			}
			if(cnt>=1&&temp.length()-cnt>=2)
				System.out.println(temp);
			return;
		}
		
		for(int i=min;i<c;i++) {
			if(used[i]==0) {
				used[i]=1;
				stb.append(word.get(i));
				solve(i,stb);
				stb.delete(stb.length()-1,stb.length());
				used[i]=0;
			}
		}
	}
}
