package PG;

import java.util.ArrayList;
import java.util.HashMap;

public class PG_92334 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
            HashMap<String, Integer> reportHashMap = new HashMap<>();

            for (String id : id_list) {
                hashMap.put(id, new ArrayList<>());
            }
            for (String str : report) {
                String[] tokens = str.split(" ");
                if (!hashMap.get(tokens[0]).contains(tokens[1])) {
                    hashMap.get(tokens[0]).add(tokens[1]);
                    reportHashMap.put(tokens[1], reportHashMap.getOrDefault(tokens[1], 0) + 1);
                }
            }

            int cnt = 0;
            for (String id : id_list) {
                for (String reportId : hashMap.get(id)) {
                    if (reportHashMap.get(reportId) >= k) {
                        answer[cnt]++;
                    }
                }
                cnt++;
            }
            return answer;
        }
    }
}
