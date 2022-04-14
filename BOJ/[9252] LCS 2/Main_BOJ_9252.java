import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_9252 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str2 = scanner.next();
        String str1 = scanner.next();
        Stack<Character> ans = new Stack<>();

        int[][] m = new int[str1.length()+1][str2.length()+1];

        for(int i=1; i<str1.length()+1; i++){
            for(int j=1; j<str2.length()+1; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    m[i][j] = m[i-1][j-1] + 1;
                }else{
                    m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
                }
            }
        }
        System.out.print(m[str1.length()][str2.length()]);

        if(m[str1.length()][str2.length()] != 0){
            System.out.println();
            int i = str1.length();
            int j = str2.length();

            while(i>0 && j>0){
                if(m[i][j]==m[i-1][j]){
                    i--;
                }else if(m[i][j]==m[i][j-1]){
                    j--;
                }else{
                    ans.push(str1.charAt(i-1));
                    i--;
                    j--;
                }
            }
            while(!ans.isEmpty()){
                System.out.print(ans.pop());
            }
        }

        scanner.close();
    }
}
