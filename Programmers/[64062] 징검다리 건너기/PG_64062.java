package PG;

public class PG_64062 {
    class Solution {
        public int solution(int[] stones, int k) {
            int answer = 0;
            int min = 0;
            int max = Integer.MAX_VALUE;

            while (min <= max) {
                int mid = (min + max) / 2;
                if (canJump(mid, k, stones)) {
                    min = mid + 1;
                    answer = mid;
                } else {
                    max = mid - 1;
                }
            }

            return answer;
        }
        private boolean canJump(int mid, int k, int[] stones) {
            int cnt = 0;
            for (int stone : stones) {
                if (stone < mid) {
                    cnt++;
                    if (cnt == k) {
                        return false;
                    }
                } else {
                    cnt = 0;
                }
            }
            return true;
        }
    }
}