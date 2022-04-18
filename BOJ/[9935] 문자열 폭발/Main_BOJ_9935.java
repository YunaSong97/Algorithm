import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String bomb = reader.readLine();
        int bomb_len = bomb.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
            if(stack.size()>=bomb_len){
                if(isBomb(stack, bomb)){
                    for(int j=0; j<bomb_len; j++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        if(stack.isEmpty()){
            System.out.print("FRULA");
        }else{
            for (Character character : stack) {
                sb.append(character);//하나씩 print 하면 시간초과
            }
            System.out.print(sb);
        }

    }
    private static boolean isBomb(Stack<Character> stack, String bomb){
        int bomb_len = bomb.length();
        for(int i=0; i<bomb_len; i++){
            if(stack.get(stack.size()-bomb_len+i)!=bomb.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
//String.replaceAll (regex, replacement) 접근 방식을 사용하면 한 번의 호출로 겉보기에는 교체를 수행 할 수 있지만
//내부적으로 많은 추가 GC(Garbage Collection) 적격 객체가 생성된다.
//따라서 문자열 교체는 다른방법 사용