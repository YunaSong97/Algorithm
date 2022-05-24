package PG;

import java.util.ArrayList;
import java.util.Collections;

public class PG_17678 {
    class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            String answer = "";
            int ans = 24 * 60;
            ArrayList<Integer> timetableNum = new ArrayList<>();

            for (String s : timetable) {
                timetableNum.add(calTime(s));
            }

            Collections.sort(timetableNum);

            int shuttle = 540;
            int mCnt = 0;
            int nCnt = 1;

            while (nCnt <= n) {
                if(timetableNum.isEmpty()){//다 태웠는데
                    if (nCnt == n) {// 셔틀 안남음
                        ans = shuttle;
                        nCnt++;
                    } else {// 셔틀 남았으면
                        shuttle += t;
                        nCnt++;
                        ans = shuttle;
                    }
                    continue;
                }
                if (timetableNum.get(0) <= shuttle) {//크루 태우기
                    ans = timetableNum.get(0) - 1;
                    timetableNum.remove(0);
                    mCnt++;
                    if (mCnt == m) {//꽉차면 출발
                        shuttle += t;
                        nCnt++;
                        mCnt = 0;
                    }
                } else {//태울 크루 없으면 다음 셔틀
                    ans = shuttle;
                    shuttle += t;
                    nCnt++;
                    mCnt = 0;
                }
            }
            answer = calAns(ans);
            System.out.println(answer);
            return answer;
        }
        private int calTime(String time){
            int hour = Integer.parseInt(time.split(":")[0]);
            int min = Integer.parseInt(time.split(":")[1]);

            return hour * 60 + min;
        }

        private String calAns(int ans) {
            return String.format("%02d",ans / 60) + ":" + String.format("%02d",ans % 60);
        }
    }
}
