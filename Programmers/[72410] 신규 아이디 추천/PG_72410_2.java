package PG;

public class PG_72410 {
    class Solution {
        public String solution(String new_id) {
            String answer = new_id;

            //1
            answer = answer.toLowerCase();

            //2 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)
            answer = answer.replaceAll("[^\\w-_.]", "");

            //3
            answer = answer.replaceAll("[.]+", ".");

            //4
            answer = answer.replaceAll("^[.]|[.]$", "");

            //5
            if (answer.equals("")) {
                answer = "a";
            }

            //6
            if (answer.length() >= 16) {
                answer = answer.substring(0, 15);
                answer = answer.replaceAll("^[.]|[.]$", "");
            }

            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
            return answer;
        }
    }
}