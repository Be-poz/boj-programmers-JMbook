package programmers;
import java.util.HashSet;

//후보키
class programmers_42890 {
    public int solution(String[][] relation) {
        int answer;								//답
		int colLen=relation[0].length;			//열 길이
		int rowLen=relation.length;				//행 길이
		HashSet<String> set=new HashSet<>();			//유일성 비교하기 위한 set
		HashSet<Integer> candidates=new HashSet<>();	//후보키 set
		for(int bit=0;bit<(1<<colLen);++bit) {			//비트마스크 수대로 반복문 돌림
			set.clear();
			for(int j=0;j<rowLen;++j) {					//행 접근
				StringBuilder str=new StringBuilder();
				for(int col=0;col<colLen;++col) {		//열 접근
					if((bit&(1<<col))==0) continue;		//비트마스크로 표현한 bit에서 해당 열이 없으면 continue
					str.append(relation[j][col]);		//있으면 string 만듬
				}
				set.add(str.toString());				//만든 값을 유일성 비교하는 set에 넣음
			}
			if(set.size()==rowLen) {					//set사이즈랑 행 길이 같다는 건 유일성 참이니깐 실행
				push(candidates,bit);
			}
		}
		answer=candidates.size();						//후보키 개수
        return answer;
    }
    public void push(HashSet<Integer> candidates,int bit) {
		for(int cmp:candidates) {								//cmp랑 bit &연산하면서 그대로 cmp라는 것은 최소성 탈락
			if((cmp&bit)==cmp)
				return;
		}
		candidates.add(bit);									//아니라면 후보키군에 넣음
	}
}
