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

    public static class Node{
        int pre, cur, next;

        public Node(int pre, int cur, int next) {
            this.pre = pre;
            this.cur = cur;
            this.next = next;
        }
    }

    public String solution2(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
            for (int i = 0; i < n; i++) {
            pre[i] = i - 1;//처음 노드의 pre는 -1
            next[i] = i + 1;
        }
        next[n - 1] = -1;// 마지막 노드의 next는 -1
        Stack<Node> delete = new Stack<>();
        StringBuilder answer = new StringBuilder("O".repeat(n));

            for (String s : cmd) {
            char c = s.charAt(0);
            if (c == 'C') {//삭제
                delete.add(new Node(pre[k], k, next[k]));
                if (pre[k] != -1) {
                    next[pre[k]] = next[k];
                }
                if (next[k] != -1) {
                    pre[next[k]] = pre[k];
                }
                answer.setCharAt(k, 'X');
                if(next[k] != -1){//마지막행 아니면 다음 행 선택
                    k = next[k];
                } else{
                    k = pre[k]; //마지막행 이면 바로 윗 행 선택
                }
            } else if (c == 'Z') {
                Node z = delete.pop();
                if (z.pre != -1) {
                    next[z.pre] = z.cur;
                }
                if(z.next != -1){
                    pre[z.next] = z.cur;
                }
                answer.setCharAt(z.cur, 'O');
            } else if (c == 'U') {
                int up = Integer.parseInt(s.substring(2));
                while (up > 0) {
                    k = pre[k];
                    up--;
                }
            } else if (c == 'D') {
                int down = Integer.parseInt(s.substring(2));
                while (down > 0) {
                    k = next[k];
                    down--;
                }
            }
        }
            return answer.toString();
    }
}
