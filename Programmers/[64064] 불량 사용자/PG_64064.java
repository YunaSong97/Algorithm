package PG;

import java.util.ArrayList;
import java.util.HashSet;

public class PG_64064 {
    class Solution {
        HashSet<HashSet<String>> result;
        ArrayList<ArrayList<String>> bannedUserList;

        public int solution(String[] user_id, String[] banned_id) {
            result = new HashSet<>();
            bannedUserList = new ArrayList<>();

            for (String bannedId : banned_id) {
                // 목록의 n번째 칸에 들갈 수 있는 제재 아이디들 구함
                bannedUserList.add(compareId(user_id, bannedId));
            }

            dfs(new HashSet<>(), 0);

            return result.size();
        }

        private ArrayList<String> compareId(String[] id, String ban) {

            ArrayList<String> valueList = new ArrayList<>();
            for (String userId : id) {
                int n = userId.length();
                int m = ban.length();

                if (n != m) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if (ban.charAt(i) != '*' && ban.charAt(i) != userId.charAt(i)) {
                        break;
                    }
                    if (i == n - 1) {
                        valueList.add(userId);
                    }
                }
            }
            return valueList;
        }


        void dfs(HashSet<String> add, int depth) {
            if (depth == bannedUserList.size()) {
                // 결과 Set에 저장
                result.add(new HashSet<>(add));
                return;
            }

            // depth번째에 들어갈 수 있는 아이디 목록에서 뽑음
            for (String userId : bannedUserList.get(depth)) {
                // 이미 목록에 들어가있으면 담지 않음
                if (!add.contains(userId)) {
                    add.add(userId);
                    dfs(add, depth + 1);
                    add.remove(userId);
                }
            }
        }
    }
}
