package PG;

import java.util.HashMap;

public class PG_77484 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int lotto : lottos) {
                hashMap.put(lotto, hashMap.getOrDefault(lotto, 0) + 1);
            }

            int matchCnt = 0;
            for (int lotto : win_nums) {
                if (hashMap.containsKey(lotto)) {
                    matchCnt++;
                }
            }

            int zeroCnt = hashMap.getOrDefault(0, 0);
            int maxCnt = zeroCnt + matchCnt;

            switch (matchCnt) {
                case 6:
                    answer[1] = 1;
                    break;
                case 5:
                    answer[1] = 2;
                    break;
                case 4:
                    answer[1] = 3;
                    break;
                case 3:
                    answer[1] = 4;
                    break;
                case 2:
                    answer[1] = 5;
                    break;
                default:
                    answer[1] = 6;
            }

            switch (maxCnt) {
                case 6:
                    answer[0] = 1;
                    break;
                case 5:
                    answer[0] = 2;
                    break;
                case 4:
                    answer[0] = 3;
                    break;
                case 3:
                    answer[0] = 4;
                    break;
                case 2:
                    answer[0] = 5;
                    break;
                default:
                    answer[0] = 6;
            }
            return answer;
        }
    }
}