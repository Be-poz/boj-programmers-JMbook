import java.util.*;

public class boj_1005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            boolean flag=false;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int destination;
            Queue<Integer> que = new LinkedList<>();                    //계산하기 위한 큐 선언
            ArrayList<Integer>[] direction = new ArrayList[n + 1];      //점이 가리키고 있는 점들의 모임 list
            ArrayList<Integer>[] r_dir = new ArrayList[n + 1];          //이 점을 가리기고 있는 점들의 모임 list
            int[] targeted = new int[n + 1];                            //이 점을 가리키고 있는 점들의 개수 0인 것들은 que에 넣어서 연산
            int[] times = new int[n + 1];                               //해당 점(건물) 수행 시간 저장
            int[] before_times = new int[n + 1];                        //이전 건물 총 수행시간을 넣어둠
            for (int i = 1; i <= n; i++) {
                times[i] = sc.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                direction[i] = new ArrayList<>();
                r_dir[i] = new ArrayList<>();
            }
            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                targeted[b]++;
                direction[a].add(b);
                r_dir[b].add(a);
            }
            destination = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                if(targeted[i]==0){
                    if (i == destination) {
                        System.out.println(times[i]);
                        flag=true;
                        break;
                    }
                    que.add(i);
                    before_times[i] = times[i];
                }
            }
            if(flag) continue;
            while (!que.isEmpty()) {
                int tmp=que.poll();
                for (int i = 0; i < direction[tmp].size(); i++) {
                    PriorityQueue<Integer> pque = new PriorityQueue<>(Comparator.reverseOrder());
                    int getArrowNode = direction[tmp].get(i);                                       //가리키고 있는 건물
                    targeted[getArrowNode]--;
                    if (targeted[getArrowNode] == 0) {                                              //이 놈을 가리키던 간선 다 끊기면 고고
                        for (int j = 0; j < r_dir[getArrowNode].size(); j++) {                      //이 놈을 가리켰던 애들의 before_times를 우선순위큐에 넣어줌
                            pque.add(before_times[r_dir[getArrowNode].get(j)]);
                        }
                        que.add(getArrowNode);                                                      //이 놈을 que 에 집어넣음
                        before_times[getArrowNode] = pque.poll() + times[getArrowNode];             //가리키던 놈들 중 가장 시간이 긴 녀석 뽑고 그것에다가 현재 건물 건축시간 더해서 before_times에 저장
                        if(getArrowNode==destination){
                            System.out.println(before_times[getArrowNode]);                         //만약 가리키던 놈이 완료 건물이었으면 출력하고 flag 값 바꾸고 탈출
                            flag=true;
                            break;
                        }
                    }
                }
                if(flag) break;
            }
        }
    }
}
