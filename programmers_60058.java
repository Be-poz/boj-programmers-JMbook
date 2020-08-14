import java.util.Stack;

public class programmers_60058 {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }


    public static String solution(String p) {
        if(p.equals("")) return "";
        if(right(p)) return p;

        String answer=jagui(p);
        return answer;
    }

    public static String jagui(String p){
        if(p=="") return "";

        int left_cnt=0;
        int right_cnt=0;
        String result="";
        String u="";
        String v="";

        for (int i = 0; i < p.length(); i++) {      //u v 나누기
             if(p.charAt(i)=='(') left_cnt++;
            else right_cnt++;
            if(left_cnt==right_cnt){
                u=p.substring(0,i+1);
                v=p.substring(i+1);
                break;
            }
        }
        if(right(u)){                               //u가 올바르다면 v를 돌려서 붙이기
            result+=u;
            result+=jagui(v);
        }else{
            result+='(';
            result+=jagui(v);
            result+=')';
            result+=transform(u);
        }
        return result;
    }

    public static boolean right(String p){          //올바른 문자열 판단 메서드
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            if(c=='(') stack.add(c);
            if(c==')'){
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public static String transform(String p) {
        if(p.length()==2) p="";
        else p=p.substring(1,p.length()-1);
        String result="";
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)=='(')
                result+=')';
            else result+='(';
        }
        return result;
    }
}
