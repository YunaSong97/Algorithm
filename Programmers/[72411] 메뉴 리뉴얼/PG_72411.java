package PG;//combination, HashMap
import java.util.*;

public class PG_72411 {
    class Solution {
        Map<String, Integer> hashMap = new HashMap<>();

        public String[] solution(String[] orders, int[] course) {
            ArrayList<String> answer = new ArrayList<>();

            //1. 각 order 정렬
            for (int i = 0; i < orders.length; i++) {
                char[] charArr = orders[i].toCharArray();
                Arrays.sort(charArr);
                orders[i] = String.valueOf(charArr);
            }

            //2. 각 order를 기준으로 course 만큼의 조합 만들기
            for (int i : course) {
                for (String order : orders) {
                    combination("", order, i);
                }
                //3. 가장 많은 조합을 answer에 저장
                if (!hashMap.isEmpty()) {
                    List<Integer> countList = new ArrayList<>(hashMap.values());
                    int max = Collections.max(countList);
                    if (max > 1) {
                        for (String key : hashMap.keySet()) {
                            if (hashMap.get(key) == max) {
                                answer.add(key);
                            }
                        }
                    }
                    hashMap.clear();
                }

            }

            Collections.sort(answer);
            String[] answerStr = new String[answer.size()];
            for (int i = 0; i < answerStr.length; i++) {
                answerStr[i] = answer.get(i);
            }
            return answerStr;
        }

        //order : 현재까지 조합된 코스
        //others : 아직 사용안된 알파벳
        private void combination(String order, String others, int cnt) {
            //탈출
            if (cnt == 0) {
                hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
                return;
            }
            //수행동작
            for (int i = 0; i < others.length(); i++) {
                combination(order + others.charAt(i), others.substring(i + 1), cnt - 1);
            }
        }
    }
}
