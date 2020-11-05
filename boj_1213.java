package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

//팰린드롬 만들기
public class boj1213 {
	
	static class keyvalue {
		char key;
		int value;
		keyvalue(char key,int value){
			this.key=key;
			this.value=value;
		}
	}
	
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		HashMap<Character, Integer> map=new HashMap<>();
		ArrayList<keyvalue> list=new ArrayList<>();
		StringBuilder stb=new StringBuilder();
		char mid=0;
		int odd_cnt=0;
		char []chars=sc.nextLine().toCharArray();
		for(int i=0;i<chars.length;i++) {
			if(map.containsKey(chars[i])==true) 
				map.replace(chars[i], map.get(chars[i])+1);
			else map.put(chars[i], 1);
		}
		for(Character key:map.keySet()) {
			int value=map.get(key);
			if(value%2==1) odd_cnt++;
			if(value%2==1&&odd_cnt==1) {
				mid=key;
				list.add(new keyvalue(key,value-1));
			}
			else if(odd_cnt>1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}else list.add(new keyvalue(key,value));
		}
		list.sort(new Comparator<keyvalue>() {

			@Override
			public int compare(keyvalue o1, keyvalue o2) {
				char a1=o1.key;
				char a2=o2.key;
				
				if(a1>a2) return 1;
				else if(a1<a2) return -1;
				return 0;
			}
		});
		for(int i=0;i<list.size();++i) {
			keyvalue kv=list.get(i);
			char key=kv.key;
			int value=kv.value;
			for(int j=0;j<value/2;j++) {
				stb.append(key);
			}
		}
		String temp=stb.toString();
		if(mid!=0) stb.append(mid);
		stb.append(new StringBuffer(temp).reverse().toString());
		System.out.println(stb.toString());
	}
}