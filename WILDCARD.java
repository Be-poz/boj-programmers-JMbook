package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WILDCARD {
	char [] wc;
	char [] fn;
	ArrayList<String> fileNameArray;
	int[][] cache;
	
	WILDCARD(String wc, ArrayList<String> fileNameArray){
		this.wc=wc.toCharArray();
		this.fileNameArray=fileNameArray;
		this.cache=new int[1001][101];
	}
	
	public int match(int wIdx, int fnIdx) {
		if(cache[wIdx][fnIdx]!=-1)
			return cache[wIdx][fnIdx];
		
		if(wIdx<wc.length&&fnIdx<fn.length)
			if(wc[wIdx]=='?'||wc[wIdx]==fn[fnIdx])
				return cache[wIdx][fnIdx]=match(wIdx+1, fnIdx+1);
		
		if(wIdx==wc.length)
			return cache[wIdx][fnIdx]=(fnIdx==fn.length)?1:0;
		
		if(wc[wIdx]=='*') {
			if(match(wIdx+1, fnIdx)==1||(fnIdx<fn.length&&match(wIdx,fnIdx+1)==1))
				return cache[wIdx][fnIdx]=1;
		}
		return cache[wIdx][fnIdx]=0;
	}
	
	public void solve() {
		ArrayList<String> resFileName=new ArrayList<>();
		for(int i=0;i<fileNameArray.size();i++) {
			for(int []arr:this.cache)
				Arrays.fill(arr, -1);
			
			String temp=fileNameArray.get(i);
			fn=temp.toCharArray();
			if(match(0, 0)==1)
				resFileName.add(temp);
		}
		
		Collections.sort(resFileName);
		for(String str:resFileName)
			System.out.println(str);
	}
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		for(int i=0;i<c;i++) {
			String wc=sc.next();
			int numFileName=sc.nextInt();
			
			ArrayList<String> fileNameArray=new ArrayList<>();
			for(int j=0;j<numFileName;j++)
				fileNameArray.add(sc.next());
			
			WILDCARD wildcard=new WILDCARD(wc,fileNameArray);
			wildcard.solve();
		}
	}

}
