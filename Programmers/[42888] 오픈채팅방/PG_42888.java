package PG;

import java.util.*;

public class PG_42888 {
    class User{
        String id;
        String nickName;

        public User(String id, String nickName) {
            this.id = id;
            this.nickName = nickName;
        }
    }
    class Record{
        User user;
        String action;

        public Record(User user, String action) {
            this.user = user;
            this.action = action;
        }
    }
    class Solution {
        public String[] solution(String[] record) {
            Map<String, String> map = new HashMap<>();
            Queue<Record> queue = new LinkedList<>();

            for (String rec : record) {
                String[] tokens = rec.split(" ");
                User user;
                Record recNow;
                if (tokens[0].equals("Enter")) {
                    user = new User(tokens[1], tokens[2]);
                    map.put(user.id, user.nickName);
                    recNow = new Record(user, tokens[0]);
                    queue.add(recNow);
                } else if (tokens[0].equals("Leave")) {
                    user = new User(tokens[1], map.get(tokens[1]));
                    recNow = new Record(user, tokens[0]);
                    queue.add(recNow);
                } else {
                    user = new User(tokens[1], tokens[2]);
                    map.put(user.id, user.nickName);
                }
            }

            String[] answer = new String[queue.size()];

            for (int i = 0; i < answer.length; i++) {
                Record rec = queue.poll();
                StringBuilder sb = new StringBuilder();
                sb.append(map.get(rec.user.id)).append("님이");

                switch (rec.action) {
                    case "Enter":
                        sb.append(" 들어왔습니다.");
                        break;
                    case "Leave":
                        sb.append(" 나갔습니다.");
                        break;
                }
                answer[i] = sb.toString();
            }

            return answer;
        }
    }
}
