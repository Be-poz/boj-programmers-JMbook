import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class programmers_60057 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

    public static int solution(String s){

        int length=s.length();
        if(length==1) return 1;
        int min_value=987654321;

        for(int i=1;i<=length/2;i++){
            String result="";
            String fragment=s.substring(0,i);
            int cnt=1;
            for (int j = i; j < length; j += i) {
                if(j+i>length){
                    if(cnt==1){
                        result+=fragment;
                    }else{
                        result+=cnt;
                        result+=fragment;
                    }
                    result+=s.substring(j);
                    break;
                }
                String compStr=s.substring(j,j+i);
                if(compStr.equals(fragment)){
                    cnt++;
                    if(j==length-i){
                        result+=cnt;
                        result+=fragment;
                    }
                }else{
                    if(cnt==1){
                        result+=fragment;
                    }else{
                        result+=cnt;
                        result+=fragment;
                        cnt=1;
                    }
                    fragment=compStr;
                    if(j==length-i){
                        if(cnt==1){
                            result+=fragment;
                        }else{
                            result+=cnt;
                            result+=fragment;
                        }
                    }
                }
            }
            min_value=Math.min(min_value,result.length());
        }
        return min_value;
    }

}
