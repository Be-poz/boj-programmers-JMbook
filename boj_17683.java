import java.util.ArrayList;

public class boj_17683 {

    static class info{
        int time;
        String name;
        String music;

        info(int time, String name, String music) {
            this.time=time;
            this.name=name;
            this.music=music;
        }
    }

    public static void main(String[] args) {
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution("CC#BCC#BCC#BCC#B",musicinfos));
    }

    static String solution(String m, String[] musicinfos) {
        String answer="";
        m=getMusic(m);
        ArrayList<info> list = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String[] tokens=musicinfos[i].split(",");
            int time=getTime(tokens[0],tokens[1]);
            String name=tokens[2];
            String music=getMusic(tokens[3]);
            String musics="";
            for (int j = 0; j < time; j++) {
                musics += music.charAt(j % music.length());
            }
            list.add(new info(time,name,musics));
        }
        int answer_time=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).music.contains(m)) {
                if (!answer.equals("")) {
                    if (list.get(i).time > answer_time) {
                        answer = list.get(i).name;
                        answer_time=list.get(i).time;
                    }
                } else {
                    answer=list.get(i).name;
                    answer_time=list.get(i).time;
                }
            }
        }
        if(answer.equals("")) return "(None)";
        return answer;
    }

    static int getTime(String start, String end) {
        String[] startTime=start.split(":");
        String[] endTime=end.split(":");
        int startNum=Integer.parseInt(startTime[0])*60+Integer.parseInt(startTime[1]);
        int endNum=Integer.parseInt(endTime[0])*60+Integer.parseInt(endTime[1]);
        return endNum-startNum;
    }

    static String getMusic(String music) {
        String answer="";
        boolean flag=false;
        for (int i = music.length()-1; i >=0; i--) {
            char c = music.charAt(i);
            if(flag) {
                answer += (c + "").toLowerCase();
                flag=false;
                continue;
            }
            if (c == '#') {
                flag = true;
                continue;
            } else {
                answer+=c;
            }
        }
        return new StringBuffer(answer).reverse().toString();
    }
}
