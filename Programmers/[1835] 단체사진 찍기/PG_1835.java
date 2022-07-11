package PG;

import java.util.ArrayList;
import java.util.HashMap;

public class PG_1835 {
    class Solution {
        class Data{
            Character start, end;
            int dist;
            int op;

            public Data(int op, Character start, Character end, int dist) {
                this.op = op;
                this.end = end;
                this.start = start;
                this.dist = dist;
            }
        }

        static ArrayList<Data> arrayList = new ArrayList<>();
        static HashMap<Character, Integer> hashMap = new HashMap<>();
        static int answer = 0;

        public int solution(int n, String[] data) {
            answer = 0;
            arrayList = new ArrayList<>();

            dataMapping(data);

            findPermutations("ACFJMNRT", n);
            return answer;
        }

        private void dataMapping(String[] data) {
            for (String s : data) {
                String[] token = s.split("~");
                Data now;
                if (token[1].charAt(1) == '=') {
                    now = new Data(0, token[0].charAt(0), token[1].charAt(0), Integer.parseInt(String.valueOf(token[1].charAt(2))));
                } else if (token[1].charAt(1) == '>') {
                    now = new Data(1, token[0].charAt(0), token[1].charAt(0), Integer.parseInt(String.valueOf(token[1].charAt(2))));
                }else{
                    now = new Data(-1, token[0].charAt(0), token[1].charAt(0), Integer.parseInt(String.valueOf(token[1].charAt(2))));
                }
                arrayList.add(now);
            }
        }

        private static void swap(char[] chars, int i, int j)
        {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        private static void permutations(char[] chars, int currentIndex, int n)
        {
            if (currentIndex == chars.length - 1) {
                for (int i = 0; i < 8; i++) {
                    hashMap.put(chars[i], i);
                }
                for (int j = 0; j < n; j++) {
                    Data now = arrayList.get(j);
                    if (now.op == 0) {
                        if (Math.abs(hashMap.get(now.start) - hashMap.get(now.end)) != now.dist + 1) {
                            break;
                        }
                    } else if (now.op == 1) {
                        if (Math.abs(hashMap.get(now.start) - hashMap.get(now.end)) <= now.dist + 1) {
                            break;
                        }
                    } else {
                        if (Math.abs(hashMap.get(now.start) - hashMap.get(now.end)) >= now.dist + 1) {
                            break;
                        }
                    }
                    if (j == n - 1) {
                        answer++;
                    }
                }
            }

            for (int i = currentIndex; i < chars.length; i++)
            {
                swap(chars, currentIndex, i);
                permutations(chars, currentIndex + 1, n);
                swap(chars, currentIndex, i);
            }
        }

        public static void findPermutations(String str, int n) {

            if (str == null || str.length() == 0) {
                return;
            }

            permutations(str.toCharArray(), 0, n);
        }
    }
}
