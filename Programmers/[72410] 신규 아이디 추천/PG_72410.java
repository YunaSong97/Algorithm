public class PG_72410 {
    class Solution {
        public String solution(String new_id) {
            String answer = "";

            //1
            String step1 = new_id.toLowerCase();

            //2
            int n = step1.length();
            StringBuilder step2 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = step1.charAt(i);
                if (Character.isDigit(c) || Character.isAlphabetic(c) || c == '.' || c == '_' || c == '-') {
                    step2.append(c);
                }
            }
            //3
            StringBuilder step3 = new StringBuilder();
            n = step2.length();
            for (int i = 0; i < n; i++) {
                if (step2.charAt(i) != '.') {
                    step3.append(step2.charAt(i));
                } else {
                    step3.append(step2.charAt(i));
                    while (step2.charAt(i) == '.') {
                        i++;
                        if (i == n) {
                            break;
                        }
                    }
                    i--;
                }
            }
            System.out.println(step3);

            //4
            n = step3.length();
            if (n != 0) {
                if (step3.charAt(n - 1) == '.') {
                    step3.deleteCharAt(n - 1);
                }
            }

            n = step3.length();
            if (n != 0) {
                if (step3.charAt(0) == '.') {
                    step3.deleteCharAt(0);
                }
            }

            //5
            if (step3.toString().equals("")) {
                step3 = new StringBuilder("a");
            }

            //6
            String step6 = String.valueOf(step3);
            if (step3.length() >= 16) {
                step6 = step3.substring(0, 15);
                if (step6.charAt(14) == '.') {
                    step6 = step6.substring(0, 14);
                }
            }

            //7
            StringBuilder step7 = new StringBuilder(step6);
            if (step6.length() <= 2) {
                while (step7.length() <= 2) {
                    step7.append(step6.charAt(step6.length() - 1));
                }
            }
            return step7.toString();
        }
    }
    class Solution2 {
        public String solution(String new_id) {
            String answer = "";
            String temp = new_id.toLowerCase();

            temp = temp.replaceAll("[^-_.a-z0-9]","");
            System.out.println(temp);
            temp = temp.replaceAll("[.]{2,}",".");
            temp = temp.replaceAll("^[.]|[.]$","");
            System.out.println(temp.length());
            if(temp.equals(""))
                temp+="a";
            if(temp.length() >=16){
                temp = temp.substring(0,15);
                temp=temp.replaceAll("^[.]|[.]$","");
            }
            if(temp.length()<=2)
                while(temp.length()<3)
                    temp+=temp.charAt(temp.length()-1);

            answer=temp;
            return answer;
        }
    }
}


