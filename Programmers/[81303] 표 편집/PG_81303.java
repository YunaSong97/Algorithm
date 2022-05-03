import java.util.Stack;

class PG_81303 {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> delete = new Stack<>();

        for (String s : cmd) {
            char c = s.charAt(0);
            if (c == 'C') {//삭제
                delete.add(k);
                n--;
                if (k == n) {
                    k--;
                }
            } else if (c == 'Z') {
                int z = delete.pop();
                if (k >= z) {
                    k++;
                }
                n++;
            } else if (c == 'U') {
                k -= Integer.parseInt(s.substring(2));
            } else if (c == 'D') {
                k += Integer.parseInt(s.substring(2));
            }
        }

        //출력
        answer.append("O".repeat(Math.max(0, n)));
        while (!delete.isEmpty()) {
            answer.insert(delete.pop().intValue(), 'X');
        }
        return answer.toString();
    }
}
