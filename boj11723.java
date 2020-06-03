package programmers;

import java.util.HashSet;
import java.util.Scanner;
//С§Че
public class boj11723 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sbl=new StringBuilder();
		String cmd;
		int n;
		int num;
		//HashSet<Integer> set=new HashSet<>();
		int bit=0;
		n=sc.nextInt();
		while(--n>=0) {
			cmd=sc.next();
			switch(cmd) {
			case "add":
				num=sc.nextInt();
				bit=bit|(1<<(num-1));
				//set.add(num);
				break;
			case "check":
				num=sc.nextInt();
				num=1<<(num-1);
				if((bit&num)==0) sbl.append("0\n");
				else sbl.append("1\n");
//				if(set.contains(num)==true)
//					System.out.println(1);
//				else System.out.println(0);
				break;
			case "remove":
				num=sc.nextInt();
				num=~(1<<(num-1));
				bit=bit&num;
				
				//set.remove(num);
				break;
			case "toggle":
				num=sc.nextInt();
				num=1<<(num-1);
				bit=bit^num;
//				if(set.contains(num)==true) set.remove(num);
//				else set.add(num);
				break;
			case "all":
				bit=(1<<20)-1;
//				for(int i=1;i<=20;i++)
//					set.add(i);
				break;
			case "empty":
				bit=1>>20;
				//set.clear();
				break;
			default: break;
			}
		}
		System.out.print(sbl.toString());
		sc.close();
	}
}
