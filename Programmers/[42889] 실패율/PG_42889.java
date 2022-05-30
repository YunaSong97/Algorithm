package PG;

import java.util.*;

public class PG_42889 {
    class Stage implements Comparable<Stage>{
        int num;
        double failRate;
        int reachNum = 0;
        int notClear = 0;

        public Stage(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Stage o) {
            if(this.failRate < o.failRate)
                return 1;

            else if (this.failRate == o.failRate)
                return this.num - o.num;

            return -1;
        }

        void calFailRate(){
            if(this.reachNum == 0){
                this.failRate = 0;
            }else{
                this.failRate = this.notClear/(double)this.reachNum;
            }
        }
    }
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            PriorityQueue<Stage> priorityQueue = new PriorityQueue<>();
            Map<Integer, Stage> stageMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                stageMap.put(i + 1, new Stage(i + 1));
            }

            for (int stage : stages) {
                if (stage == N + 1) {
                    for (int j = 1; j < stage; j++) {
                        stageMap.get(j).reachNum++;
                    }
                }else{
                    stageMap.get(stage).notClear++;

                    for (int j = 1; j <= stage; j++) {
                        stageMap.get(j).reachNum++;
                    }
                }
            }

            for (int i = 1; i < stageMap.size()+1; i++) {
                stageMap.get(i).calFailRate();
                priorityQueue.add(stageMap.get(i));
            }

            int a = 0;
            while(!priorityQueue.isEmpty()){
                answer[a] = priorityQueue.poll().num;
                a++;
            }
            return answer;
        }
    }
}
