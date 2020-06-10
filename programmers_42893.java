package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;

//매칭점수
public class programmers_42893 {
	static String word="blind";
	static String []pages= {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
	
	static class result{
		int idx;
		double score;
		result(int idx, double score){
			this.idx=idx;
			this.score=score;
		}
	}
	
	static class info{
		String name;
		HashSet<String> set=new HashSet<>(); //외부 링크
		int b_score;			//기본 점수
		int o_link;	//외부 링크 수
		double bdo;				//기본점수 / 외부링크 수
		info(String name, HashSet<String> set, int b_score){
			this.name=name;
			this.set=set;
			this.b_score=b_score;
			o_link=set.size();
			bdo=(double)b_score/(double)set.size();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<info> list=new ArrayList<>();
		LinkedHashMap<String,Double> map=new LinkedHashMap<>();
		
		for(int i=0;i<pages.length;i++) {
			String name=find_name(pages[i]);
			HashSet<String> set=find_oLink(pages[i]);
			int word_cnt=find_wordCnt(pages[i],word);
			map.put(name, (double) word_cnt);
			info a=new info(name,set,word_cnt);
			list.add(a);
		}
		
		for(int i=0;i<list.size();i++) {
			info a=list.get(i);
			HashSet<String> set=a.set;
			double bdo=a.bdo;
			for(String link:set) {
				if(map.containsKey(link)==true) {
					double score=map.get(link)+bdo;
					map.replace(link,score);
				}
			}
		}
		
		ArrayList<result> last=new ArrayList<>();
		int idx=0;
		for(String key:map.keySet()) {
			last.add(new result(idx,map.get(key)));
			idx++;
		}
		last.sort(new Comparator<result>() {

			@Override
			public int compare(result o1, result o2) {
				double a1=o1.score;
				double a2=o2.score;
				if(a1>a2) return -1;
				else return 1;
			}
		});
		System.out.print(last.get(0).idx);
	}
	
	public static String find_name(String page) {
		String []log=page.split("meta property");
		String []log2=log[1].split("content=\"");
		String result="";
		for(int i=0;i<log2[1].length();i++) {
			if(log2[1].charAt(i)=='\"') break;
			result+=log2[1].charAt(i);
		}
		return result;
	}
	
	public static HashSet<String> find_oLink(String page){
		HashSet<String> result=new HashSet<>();
		String []log=page.split("<a href=\"");
		if(log.length==1) return result;
		for(int i=1;i<log.length;i++) {
			String []temp=log[i].split("\"");
			result.add(temp[0]);
		}
		return result;
	}
	
	public static int find_wordCnt(String page,String word) {
		String l_page=page.toLowerCase();
		String l_word=word.toLowerCase();
		int word_cnt=0;
		int idx=0;
		boolean before=false;
		boolean next=false;
		for(int i=0;i<l_page.length();i++) {
			if(idx==l_word.length()) {
				if(i==0) before=true;
				else if((l_page.charAt(i-l_word.length()-1)>='a'&&l_page.charAt(i-l_word.length()-1)<='z'))
					before=false;
				else before=true;
				
				if(i==l_page.length()-1) next=true;
				else if((l_page.charAt(i)>='a'&&l_page.charAt(i)<='z'))
					next=false;
				else next=true;
				
				if(next&&before) {
					word_cnt++;
					idx=0;
				}else idx=0;
			}
			
			if(l_page.charAt(i)==l_word.charAt(idx)) {
				idx++;
			}else idx=0;
		}
		return word_cnt;
	}
}


//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.LinkedHashMap;
//class Solution {
//    
//	static class result{
//		int idx;
//		double score;
//		result(int idx, double score){
//			this.idx=idx;
//			this.score=score;
//		}
//	}
//	
//	static class info{
//		String name;
//		HashSet<String> set=new HashSet<>(); //외부 링크
//		int b_score;			//기본 점수
//		int o_link;	//외부 링크 수
//		double bdo;				//기본점수 / 외부링크 수
//		info(String name, HashSet<String> set, int b_score){
//			this.name=name;
//			this.set=set;
//			this.b_score=b_score;
//			o_link=set.size();
//			bdo=(double)b_score/(double)set.size();
//		}
//	}
//    
//    public int solution(String word, String[] pages) {
//		ArrayList<info> list=new ArrayList<>();
//		LinkedHashMap<String,Double> map=new LinkedHashMap<>();
//		
//		for(int i=0;i<pages.length;i++) {
//			String name=find_name(pages[i]);
//			HashSet<String> set=find_oLink(pages[i]);
//			int word_cnt=find_wordCnt(pages[i],word);
//			map.put(name, (double) word_cnt);
//			info a=new info(name,set,word_cnt);
//			list.add(a);
//		}
//		
//		for(int i=0;i<list.size();i++) {
//			info a=list.get(i);
//			HashSet<String> set=a.set;
//			double bdo=a.bdo;
//			for(String link:set) {
//				if(map.containsKey(link)==true) {
//					double score=map.get(link)+bdo;
//					map.replace(link,score);
//				}
//			}
//		}
//		
//		ArrayList<result> last=new ArrayList<>();
//		int idx=0;
//		for(String key:map.keySet()) {
//			last.add(new result(idx,map.get(key)));
//			idx++;
//		}
//		last.sort(new Comparator<result>() {
//
//			@Override
//			public int compare(result o1, result o2) {
//				double a1=o1.score;
//				double a2=o2.score;
//				if(a1>a2) return -1;
//				else return 1;
//			}
//		});
//        int answer=last.get(0).idx;
//        return answer;
//    }
//	public static String find_name(String page) {
//		String []log=page.split("meta property");
//		String []log2=log[1].split("content=\"");
//		String result="";
//		for(int i=0;i<log2[1].length();i++) {
//			if(log2[1].charAt(i)=='\"') break;
//			result+=log2[1].charAt(i);
//		}
//		return result;
//	}
//	
//	public static HashSet<String> find_oLink(String page){
//		HashSet<String> result=new HashSet<>();
//		String []log=page.split("<a href=\"");
//		if(log.length==1) return result;
//		for(int i=1;i<log.length;i++) {
//			String []temp=log[i].split("\"");
//			result.add(temp[0]);
//		}
//		return result;
//	}
//	
//	public static int find_wordCnt(String page,String word) {
//		String l_page=page.toLowerCase();
//		String l_word=word.toLowerCase();
//		int word_cnt=0;
//		int idx=0;
//		boolean before=false;
//		boolean next=false;
//		for(int i=0;i<l_page.length();i++) {
//			if(idx==l_word.length()) {
//				if(i==0) before=true;
//				else if((l_page.charAt(i-l_word.length()-1)>='a'&&l_page.charAt(i-l_word.length()-1)<='z'))
//					before=false;
//				else before=true;
//				
//				if(i==l_page.length()-1) next=true;
//				else if((l_page.charAt(i)>='a'&&l_page.charAt(i)<='z'))
//					next=false;
//				else next=true;
//				
//				if(next&&before) {
//					word_cnt++;
//					idx=0;
//				}else idx=0;
//			}
//			
//			if(l_page.charAt(i)==l_word.charAt(idx)) {
//				idx++;
//			}else idx=0;
//		}
//		return word_cnt;
//	}
//}
