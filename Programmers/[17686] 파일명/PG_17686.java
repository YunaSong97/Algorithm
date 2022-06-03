package PG;

import java.util.PriorityQueue;

public class PG_17686 {
    class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        int order;

        public File(int order, String head, String number, String tail) {
            this.order = order;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.toLowerCase().equals(o.head.toLowerCase())) {
                if(Integer.parseInt(this.number) == Integer.parseInt(o.number)) {
                    return this.order - o.order;
                }
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }

            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }

    class Solution {
        String now = "";
        public String[] solution(String[] files) {
            String[] answer = new String[files.length];
            PriorityQueue<File> priorityQueue = new PriorityQueue<>();
            int i = 0;

            for (String file : files) {
                now = file;
                File fileName = new File(i++, getHead(), getNumber(), getTail());
                priorityQueue.offer(fileName);
            }

            i = 0;
            while (!priorityQueue.isEmpty()) {
                File file = priorityQueue.poll();
                answer[i] = file.head + file.number + file.tail;
                i++;
            }

            return answer;
        }

        private String getHead() {
            StringBuilder head = new StringBuilder();
            int i = 0;

            while(i < now.length() && !Character.isDigit(now.charAt(i))) {
                head.append(now.charAt(i));
                i++;
            }

            now = now.substring(i);

            return head.toString();
        }

        private String getNumber() {
            StringBuilder number = new StringBuilder();
            int i = 0;

            while (i < now.length() && Character.isDigit(now.charAt(i))) {
                number.append(now.charAt(i));
                i++;
            }
            now = now.substring(i);

            return number.toString();
        }

        private String getTail() {

            return now;
        }
    }
}