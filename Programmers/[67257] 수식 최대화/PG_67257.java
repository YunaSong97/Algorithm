import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PG_67257 {
    ArrayList<Long> numList = new ArrayList<>();
    ArrayList<String> opList = new ArrayList<>();
    long answer = 0;

    public long solution(String expression) {

        Pattern numPattern = Pattern.compile("\\d+"); //숫자만
        Pattern opPattern = Pattern.compile("[+]|[-]|[*]"); //숫자만

        Matcher matcher = numPattern.matcher(expression);
        while(matcher.find()){
            numList.add(Long.valueOf(matcher.group()));
        }
        matcher = opPattern.matcher(expression);
        while(matcher.find()){
            opList.add(matcher.group());
        }

        permutation(0, 3, new String[] {"+", "-", "*"}, new boolean[3], new String[3]);

        return answer;
    }

    private void permutation(int startDept, int targetDepth, String[] arr, boolean[] check, String[] result) {
        if (startDept == targetDepth) {
            ArrayList<Long> numList2 = new ArrayList<>(numList);
            ArrayList<String> opList2 = new ArrayList<>(opList);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < opList2.size(); j++) {
                    if (opList2.get(j).equals(result[i])) {
                        long temp = calc(numList2.get(j), numList2.get(j + 1), opList2.get(j));
                        opList2.remove(j);
                        numList2.remove(j);
                        numList2.remove(j);
                        numList2.add(j, temp);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(numList2.get(0)));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    result[startDept] = arr[i];
                    permutation(startDept + 1, targetDepth, arr, check, result);
                    check[i] = false;
                }
            }
        }
    }

    private long calc(long a, long b, String op){
        if(Objects.equals(op, "+")){
            return a + b;
        }else if(Objects.equals(op, "-")){
            return a - b;
        }else{
            return a * b;
        }
    }
}
