import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_1701_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        int n = str.length();
        int max = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max, getPi(str.substring(i, n)));
        }
        System.out.print(max);

        scanner.close();
    }
    private static int getPi(String str){
        int n = str.length();
        int[] pi = new int[n];
        int max = 0;

        int j=0;
        for(int i=1; i<n; i++){
            while(j>0 && str.charAt(i)!=str.charAt(j)){
                j=pi[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                max = Math.max(pi[i]=++j, max);
            }
        }
        return max;
    }
}