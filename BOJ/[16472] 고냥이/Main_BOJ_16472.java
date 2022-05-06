package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_16472 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        int cur = 0;
        int ans = 0;
        Queue<Character> q = new LinkedList<>();//문자열 저장하는 큐
        Set<Character> set =  new HashSet<>();//문자열에 알파뱃 종류

        while (cur<str.length()) {
            char c = str.charAt(cur);
            q.add(c);
            set.add(c);

            if (set.size() > N) {
                while (true) {
                    char del = q.poll();
                    if (!q.contains(del)) {
                        set.remove(del);
                        break;
                    }
                }
            }
            cur++;

            ans = Math.max(ans, q.size());
        }
        System.out.print(ans);
    }
}
