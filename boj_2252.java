import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> result =new ArrayList<>();       //결과 값 저장하는 list
        Queue<Integer> que = new LinkedList<>();            //수행을 위한 큐
        int n = sc.nextInt();                               //점의 개수
        int m = sc.nextInt();                               //간선의 개수
        int[] targeted=new int[n+1];                        //선택받은 횟수를 저장하기 위한 배열 n+1로 설정하여 [0]을 패스했다.
        ArrayList<Integer>[] direction=new ArrayList[n+1];  //해당 점이 선택한 다른 점들을 저장하기 위한 arraylist 배열
        for (int i = 0; i < n+1; i++) {
            direction[i] = new ArrayList<>();               //배열 당 arraylist 선언
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();                       //시작 점 입력
            int end = sc.nextInt();                         //가리킨 점 입력
            targeted[end]++;                                //가리킨 점의 선택받은 횟수 추가
            direction[start].add(end);                      //시작 점이 선택한 점 list에 가리킨 점 추가
        }
        for (int i = 1; i <= n; i++) {
            if(targeted[i]==0) que.add(i);                  //시작 점들 큐에 다 집어 넣는 작업
        }

        while (!que.isEmpty()) {
            int currentNode = que.poll();                   //큐에서 하나 빼내어 result에 추가
            result.add(currentNode);
            for (int i = 0; i < direction[currentNode].size(); i++) {
                int getArrowNode = direction[currentNode].get(i);   //가리킨 점을 가지고 와서 그 점의 선택받은 횟수 차감 후 그 값이 0이면 큐에 추가
                targeted[getArrowNode]--;
                if (targeted[getArrowNode] == 0) {
                    que.add(getArrowNode);
                }
            }
        }
        for (Integer ans : result) {
            System.out.println(ans+" ");
        }
    }
}
