package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Pattern numPattern = Pattern.compile("\\d+");
        ArrayList<StringBuilder> ans = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            Matcher matcher = numPattern.matcher(str);
            Deque<Integer> numList = new ArrayDeque<>();

            while(matcher.find()){
                numList.add(Integer.valueOf(matcher.group()));
            }

            StringBuilder sb = new StringBuilder();//cmd 결과
            boolean error = false;
            boolean head = true;

            for (int j = 0; j < cmd.length(); j++) {
                char c = cmd.charAt(j);

                switch (c) {
                    case 'R' :
                        //Collections.reverse(numList);
                        head = !head;
                        break;
                    case 'D' :
                        if (numList.size() == 0) {
                            error = true;
                            sb.append("error");
                            break;
                        }
                        if (head) {
                            numList.pollFirst();
                        } else {
                            numList.removeLast();
                        }
                }
                if (error) {
                    break;
                }
            }

            if (!error) {
                sb.append('[');

                if (head) {//순방향
                    while (!numList.isEmpty()) {
                        sb.append(numList.pollFirst());
                        if (!numList.isEmpty()) {
                            sb.append(',');
                        }
                    }

                } else {//역방향
                    while (!numList.isEmpty()) {
                        sb.append(numList.removeLast());
                        if (!numList.isEmpty()) {
                            sb.append(',');
                        }
                    }
                }

                sb.append(']');
            }
            ans.add(sb);
        }

        for (StringBuilder an : ans) {
            System.out.println(an);
        }
    }
}
