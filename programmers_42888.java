package programmers;

import java.util.ArrayList;
import java.util.HashMap;
//오픈채팅방
public class programmers_42888 {
	static String[] record= {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
	
	static class cmdandidnick{
		String cmd="";
		String id="";
		String nick="";
		cmdandidnick(String cmd,String id,String nick){
			this.cmd=cmd;
			this.id=id;
			this.nick=nick;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<cmdandidnick> list=new ArrayList<>();
		HashMap<String, String> map=new HashMap<>();
		String result[];
		int cnt=0;
		for(int i=0;i<record.length;++i) {
			int loc=0;
			StringBuilder temp=new StringBuilder();
			String cmd="";
			String id="";
			String nick="";
			for(int j=0;j<record[i].length();++j) {
				if(record[i].charAt(j)==' '||j==record[i].length()-1) {
					if(loc==0) cmd=temp.toString();
					else if(loc==1) {
						if(j==record[i].length()-1) {
							temp.append(record[i].charAt(j));
						}
						id=temp.toString();
					}
					else if(j==record[i].length()-1) {
						temp.append(record[i].charAt(j));
						nick=temp.toString();
					}
					temp=new StringBuilder();
					loc++;
					continue;
				}
				temp.append(record[i].charAt(j));
			}
			list.add(new cmdandidnick(cmd,id,nick));
			if(cmd.equals("Change")==false) cnt++;
		}
		for(int i=0;i<list.size();++i) {
			String cmd=list.get(i).cmd;
			String id=list.get(i).id;
			String nick=list.get(i).nick;
			if(cmd.equals("Enter")==true||cmd.equals("Change")==true) {
				if(map.containsKey(id)==true)
					map.replace(id,nick);
				else map.put(id,nick);
			}
		}
		result=new String[cnt];
		int idx=0;
		for(int i=0;i<list.size();++i) {
			String cmd=list.get(i).cmd;
			String id=list.get(i).id;
			if(cmd.equals("Change")==true) continue;
			StringBuilder temp=new StringBuilder();
			temp.append(map.get(id)+"님이 ");
			if(cmd.equals("Enter"))
				temp.append("들어왔습니다.");
			else if(cmd.equals("Leave"))
				temp.append("나갔습니다.");
			result[idx++]=temp.toString();
		}
		for(int i=0;i<cnt;++i) {
			System.out.println(result[i]);
		}
	}
}
