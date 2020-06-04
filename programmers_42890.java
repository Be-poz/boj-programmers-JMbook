package programmers;
import java.util.HashSet;

//�ĺ�Ű
class programmers_42890 {
    public int solution(String[][] relation) {
        int answer;								//��
		int colLen=relation[0].length;			//�� ����
		int rowLen=relation.length;				//�� ����
		HashSet<String> set=new HashSet<>();			//���ϼ� ���ϱ� ���� set
		HashSet<Integer> candidates=new HashSet<>();	//�ĺ�Ű set
		for(int bit=0;bit<(1<<colLen);++bit) {			//��Ʈ����ũ ����� �ݺ��� ����
			set.clear();
			for(int j=0;j<rowLen;++j) {					//�� ����
				StringBuilder str=new StringBuilder();
				for(int col=0;col<colLen;++col) {		//�� ����
					if((bit&(1<<col))==0) continue;		//��Ʈ����ũ�� ǥ���� bit���� �ش� ���� ������ continue
					str.append(relation[j][col]);		//������ string ����
				}
				set.add(str.toString());				//���� ���� ���ϼ� ���ϴ� set�� ����
			}
			if(set.size()==rowLen) {					//set������� �� ���� ���ٴ� �� ���ϼ� ���̴ϱ� ����
				push(candidates,bit);
			}
		}
		answer=candidates.size();						//�ĺ�Ű ����
        return answer;
    }
    public void push(HashSet<Integer> candidates,int bit) {
		for(int cmp:candidates) {								//cmp�� bit &�����ϸ鼭 �״�� cmp��� ���� �ּҼ� Ż��
			if((cmp&bit)==cmp)
				return;
		}
		candidates.add(bit);									//�ƴ϶�� �ĺ�Ű���� ����
	}
}
