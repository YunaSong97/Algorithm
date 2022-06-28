package PG;//combination, HashMap

import java.util.*;

public class PG_72411 {
    class Solution {
        HashMap<String, Integer> hashMap;

        public String[] solution(String[] orders, int[] course) {
            ArrayList<String> arrayList = new ArrayList<>();
            String[] answer = {};

            int cnt = 0;
            for (String order : orders) {
                char[] charArr = order.toCharArray();
                Arrays.sort(charArr);
                orders[cnt++] = new String(charArr);
            }

            for (int i = 0; i < course.length; i++) {
                hashMap = new HashMap<>();
                for (int j = 0; j < orders.length; j++) {
                    boolean[] visited = new boolean[orders[j].length()];
                    combination(orders[j], visited, 0, orders[j].length(), course[i]);
                }

                if (!hashMap.isEmpty()) {
                    int max = Collections.max(hashMap.values());
                    for (Map.Entry<String, Integer> entrySet : hashMap.entrySet()) {
                        if (entrySet.getValue() == max && entrySet.getValue() > 1) {
                            arrayList.add(entrySet.getKey());
                        }
                    }
                }
            }

            Collections.sort(arrayList);
            answer = new String[arrayList.size()];
            cnt = 0;
            for (String str : arrayList) {
                answer[cnt++] = str;
            }
            return answer;
        }

        void combination(String order, boolean[] visited, int start, int n, int r) {
            if (r == 0) {
                StringBuilder course = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        course.append(order.charAt(i));
                    }
                }
                hashMap.put(course.toString(), hashMap.getOrDefault(course.toString(), 0) + 1);
                return;
            }

            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(order, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}


