package PG;

import java.util.*;

public class PG_42890 {
    class Solution {
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();

        public int solution(String[][] relation) {
            int answer = 0;
            int colSize = relation[0].length;
            Set<String> setNum = new HashSet<>();

            int[] arr = new int[colSize];

            for (int i = 0; i < colSize; i++) {
                arr[i] = i;
            }
            for (int i = 1; i < colSize + 1; i++) {
                boolean[] visited = new boolean[colSize];
                comb(arr, visited, 0, colSize, i);
            }

            queue.addAll(list);

            while(!queue.isEmpty()){
                Set<String> set = new HashSet<>();
                String now = queue.poll();
                boolean flag = false;

                for (String s : setNum) {
                    if (now.contains(s)) {
                        flag = true;
                        break;
                    }
                    for (int i = 0; i < s.length(); i++) {
                        if(!now.contains(Character.toString(s.charAt(i)))){
                            break;
                        }
                        if (i == s.length() - 1) {
                            flag = true;
                        }
                    }
                }

                if (flag)
                    continue;

                for (String[] str : relation) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < now.length(); j++) {

                        sb.append(str[Character.getNumericValue(now.charAt(j))]).append(" ");

                    }
                    set.add(String.valueOf(sb));
                }

                if (set.size() == relation.length) {
                    System.out.println(now);
                    answer++;
                    setNum.add(now);
                }
            }

            return answer;
        }

        void comb(int[] arr, boolean[] visited, int start, int n, int r) {
            if(r == 0) {
                addQueue(arr, visited);
            } else {
                for(int i = start; i < n; i++) {
                    visited[i] = true;
                    comb(arr, visited, i + 1, n, r - 1);
                    visited[i] = false;
                }
            }
        }

        void addQueue(int[] arr, boolean[] visited) {
            StringBuilder toAdd = new StringBuilder();

            for(int i = 0; i < arr.length; i++) {
                if(visited[i])
                    toAdd.append(arr[i]);
            }

            list.add(String.valueOf(toAdd));
        }
    }
}
