import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class boj_17686 {

    static class fileInfo{
        String fullname;
        String head;
        int number;
        int idx;

        fileInfo(String fullname,String head, int number, int idx) {
            this.fullname=fullname;
            this.head=head;
            this.number=number;
            this.idx=idx;
        }
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] answer = solution(files);
        for (String ans : answer) {
            System.out.println(ans);
        }
    }

    static String[] solution(String[] files) {
        ArrayList<fileInfo> list = new ArrayList<>();
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            String tmp = files[i];
            String tmp2="";
            String head="";
            int number=0;
            int idx=0;
            while (!Character.isDigit(tmp.charAt(idx))) {
                tmp2+=tmp.charAt(idx++);
            }
            head=tmp2.toLowerCase();
            tmp2="";
            while (idx!=tmp.length()&&Character.isDigit(tmp.charAt(idx))) {
                tmp2+=tmp.charAt(idx++);
            }
            number=Integer.parseInt(tmp2);
            list.add(new fileInfo(tmp,head,number,i));
        }
        Collections.sort(list, new Comparator<fileInfo>() {
            @Override
            public int compare(fileInfo o1, fileInfo o2) {
                String head1=o1.head;
                String head2=o2.head;
                int number1=o1.number;
                int number2=o2.number;
                int idx1=o1.idx;
                int idx2=o2.idx;
                if (head1.compareTo(head2)>0) {
                    return 1;
                } else if (head2.compareTo(head1) > 0) {
                    return -1;
                } else if(head1.compareTo(head2)==0) {
                    if(number1>number2) return 1;
                    else if(number1<number2) return -1;
                    else{
                        if(idx1>idx2) return 1;
                        else return -1;
                    }
                }
                return 0;
            }
        });
        for (int i = 0; i < files.length; i++) {
            answer[i]=list.get(i).fullname;
        }
        return answer;
    }
}
