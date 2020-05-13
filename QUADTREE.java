package programmers;

import java.util.Scanner;

public class QUADTREE {
	static int c;
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		String tree;
		c=sc.nextInt();
		for(int i=0;i<c;i++) {
			tree=sc.next();
			tree=solve(tree);
			System.out.println(tree);
		}
		sc.close();
	}
	
	public static String solve(String tree) {
		String lt,rt,lb,rb;
		StringBuilder result=new StringBuilder("");
		int idx=1;
		
		if(tree.charAt(0)!='x') return tree;
		
		if(tree.charAt(idx)!='x') lt=String.valueOf(tree.charAt(idx));
		else lt=solve(tree.substring(idx));
		
		if(tree.charAt(idx+lt.length())!='x') rt=String.valueOf(tree.charAt(idx+lt.length()));
		else rt=solve(tree.substring(idx+lt.length()));
		
		if(tree.charAt(idx+lt.length()+rt.length())!='x') lb=String.valueOf(tree.charAt(idx+lt.length()+rt.length()));
		else lb=solve(tree.substring(idx+lt.length()+rt.length()));
		
		if(tree.charAt(idx+lt.length()+rt.length()+lb.length())!='x') rb=String.valueOf(tree.charAt(idx+lt.length()+rt.length()+lb.length()));
		else rb=solve(tree.substring(idx+lt.length()+rt.length()+lb.length()));
		
		result=result.append('x').append(lb).append(rb).append(lt).append(rt);
		return result.toString();
	}
	
}
