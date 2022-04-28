public class PG_42747 {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            int cnt = 0;
            int cnt2 = 0;

            int n = citations.length;
            for (int h = n; h >= 0; h--) {
                for (int citation : citations) {
                    if (citation > h) {
                        cnt++;
                    } else if (citation < h) {
                        cnt2++;
                    } else {
                        cnt++;
                        cnt2++;
                    }
                }
                if (cnt>=h && cnt2<=h) {
                    answer = h;
                    return answer;
                }
                cnt = 0;
                cnt2 = 0;
            }
            return answer;
        }
    }
}
