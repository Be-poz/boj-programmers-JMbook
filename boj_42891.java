import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_42891 {
    static class FoodIdx{
        int food;
        int idx;

        FoodIdx(int food, int idx) {
            this.food = food;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        int[] food_times = {2,1,4,2,3,4,1,2,3,2,1};
        System.out.println(solution(food_times,5));
    }

    static int solution(int[] food_times, long k) {
        long total=0;
        PriorityQueue<FoodIdx> timeQue=new PriorityQueue<>(new Comparator<FoodIdx>() {
            @Override
            public int compare(FoodIdx o1, FoodIdx o2) {
                return o1.food-o2.food;
            }
        });
        PriorityQueue<FoodIdx> indexQue=new PriorityQueue<>(new Comparator<FoodIdx>() {
            @Override
            public int compare(FoodIdx o1, FoodIdx o2) {
                return o1.idx-o2.idx;
            }
        });
        for (int i = 0; i < food_times.length; i++) {
            total += food_times[i];
            timeQue.add(new FoodIdx(food_times[i], i + 1));
        }
        if(total<=k) return -1;
        long cycle=food_times.length;
        long time=0;
        int end=0;
        while (true) {
            long remains=k-time;
            FoodIdx min = timeQue.peek();
            min.food -= end;
            if (remains >= cycle * min.food) {
                timeQue.poll();
                if (remains == cycle * min.food) {
                    indexQue.addAll(timeQue);
                    return indexQue.peek().idx;
                } else {
                    time += min.food * cycle;
                    end += min.food;
                    cycle--;
                }
            } else {
                indexQue.addAll(timeQue);
                remains%=cycle;
                while(true){
                    FoodIdx answer=indexQue.poll();
                    if(remains==0) return answer.idx;
                    remains--;
                }
            }
        }
    }
}
