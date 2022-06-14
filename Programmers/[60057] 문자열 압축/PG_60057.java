package PG;

public class PG_60057 {
    class Solution {
        public int solution(String s) {
            int answer = s.length();
            String sCopy;

            for (int i = 1; i <= s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sCopy = s;
                String header = sCopy.substring(0, i);
                sCopy = sCopy.substring(i);
                int cnt = 1;

                while (true) {
                    String next = sCopy.substring(0, Math.min(sCopy.length(), i));
                    sCopy = sCopy.substring(Math.min(sCopy.length(), i));
                    if (header.equals(next)) {
                        cnt++;
                    } else {
                        sb.append(header);
                        if (cnt != 1) {
                            sb.append(cnt);
                        }
                        cnt = 1;
                    }
                    header = next;
                    if (sCopy.length() == 0) {
                        sb.append(header);
                        if (cnt != 1) {
                            sb.append(cnt);
                        }
                        break;
                    }
                }

                answer = Math.min(answer, sb.length());
            }
            return answer;
        }
    }
}
