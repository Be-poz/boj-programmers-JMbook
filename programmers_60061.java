import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class programmers_60061 {

    static class xya{
            int x;
            int y;
            int a;
            xya(int x, int y, int a) {
                this.x=x;
                this.y=y;
                this.a=a;
            }
    }

    public static void main(String[] args) {
        int [][]build_frame={{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        int [][]result=solution(5,build_frame);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n, int[][] build_frame) {
        int [][]answer;
        ArrayList<xya> list = new ArrayList<>();

        for (int[] build : build_frame) {
            int x=0,y=0,s_type=0,b_type=0;      //structure_type 과 build_type
            for (int i = 0; i < 4; i++) {
                switch(i){
                    case 0:
                        x=build[i];
                        break;
                    case 1:
                        y=build[i];
                        break;
                    case 2:
                        s_type=build[i];
                        break;
                    case 3:
                        b_type=build[i];
                        break;
                    default: break;
                }
            }

            if(b_type==1){
                list.add(new xya(x,y,s_type));
                if (circuit_ok(list) == false) {
                    list=remove(x,y,s_type,list);
                }
            }
            if(b_type==0){
                list=remove(x,y,s_type,list);
                if(circuit_ok(list)==false)
                    list.add(new xya(x,y,s_type));
            }
        }
        Collections.sort(list, new Comparator<xya>() {
            @Override
            public int compare(xya o1, xya o2) {
                int x1=o1.x;
                int x2=o2.x;
                int y1=o1.y;
                int y2=o2.y;
                int t1=o1.a;
                int t2=o2.a;
                if(x1>x2) return 1;
                else if(x1<x2) return -1;
                else{
                    if(y1>y2) return 1;
                    else if(y1<y2) return -1;
                    else{
                        if(t1>t2) return 1;
                        else return -1;
                    }
                }
            }
        });
        answer=new int[list.size()][3];
        int index=0;
        for(xya tmp:list){
            answer[index][0]=tmp.x;
            answer[index][1]=tmp.y;
            answer[index][2]=tmp.a;
            index++;
        }
        return answer;
    }

    private static ArrayList<xya> remove(int x, int y, int s_type,ArrayList<xya> list) {
        int index=0;
        for(int i=0;i<list.size();i++){
            int tmp_x=list.get(i).x;
            int tmp_y=list.get(i).y;
            int tmp_a=list.get(i).a;
            if(x==tmp_x&&y==tmp_y&&s_type==tmp_a){
                index=i;
                break;
            }
        }
        list.remove(index);
        return list;
    }

    private static boolean contain_check(int x,int y,int s_type,ArrayList<xya> list) {
        for(int i=0;i<list.size();i++){
            int tmp_x=list.get(i).x;
            int tmp_y=list.get(i).y;
            int tmp_a=list.get(i).a;
            if(x==tmp_x&&y==tmp_y&&s_type==tmp_a){
                return true;
            }
        }
        return false;
    }

    public static boolean circuit_ok(ArrayList<xya> list) {
        for (xya xya : list) {
            int x=xya.x;
            int y=xya.y;
            int a=xya.a;
            if(a==0){
                if(y==0||contain_check(x,y-1,0,list)||contain_check(x-1,y,1,list)||
                        contain_check(x,y,1,list)) continue;
                else return false;
            }
            if(a==1){
                if(contain_check(x,y-1,0,list)||contain_check(x+1,y-1,0,list)) continue;
                if(contain_check(x-1,y,1,list)&&contain_check(x+1,y,1,list)) continue;
                return false;
            }
        }
        return true;
    }
}
