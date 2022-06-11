package PG;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG_42891 {
    class Solution {
        public class Food {
            long time;
            int num;

            public Food(int num, long time) {
                this.num = num;
                this.time = time;
            }
        }

        public int solution(int[] food_times, long k) {
            int answer = -1;

            PriorityQueue<Food> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o.time));

            int n = food_times.length;

            for(int i = 0; i < n; i++) {
                priorityQueue.add(new Food(i + 1, food_times[i]));
            }

            long time = (priorityQueue.peek().time) * n;

            while (!priorityQueue.isEmpty()) {
                if (k + 1 <= time) {
                    ArrayList<Food> listNumOrder = new ArrayList<>(priorityQueue);
                    listNumOrder.sort(Comparator.comparingInt(o -> o.num));

                    int idx = (int) ((k + 1) % n);
                    if (idx == 0) {
                        return listNumOrder.get(n - 1).num;
                    }
                    return listNumOrder.get(idx - 1).num;
                } else {
                    Food now = priorityQueue.poll();
                    k -= time;
                    n--;
                    if (!priorityQueue.isEmpty()) {
                        time = (priorityQueue.peek().time - now.time) * n;
                    }
                }
            }

            return answer;
        }
    }
}
