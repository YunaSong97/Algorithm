import java.util.Scanner;

public class Main_BOJ_12904 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();
        String T = scanner.next();
        int A = 0;

        while(S.length()<T.length()){
            if(T.charAt(T.length()-1)=='A'){
                T=T.substring(0, T.length()-1);
            }else{
                T= new StringBuffer(T.substring(0, T.length()-1)).reverse().toString();
            }
            if(T.equals(S)){
                A = 1;
                break;
            }
        }

        System.out.print(A);
        scanner.close();
    }
}