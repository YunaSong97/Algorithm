import java.util.Scanner;

public class Main_BOJ_16916 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        String pattern = scanner.next();

        if(KMP(str, pattern)){
            System.out.print(1);
        }else{
            System.out.print(0);
        }

        scanner.close();
    }
    private static boolean KMP(String str, String pattern){
        int len = str.length();
        int j = 0;
        int[] pi = getPi(pattern);
        for(int i=0; i<len; i++){
            while(j>0 && str.charAt(i)!=pattern.charAt(j)){
                j=pi[j-1];
            }
            if(str.charAt(i)==pattern.charAt(j)){
                if(j==pattern.length()-1){
                    return true;
                }else{
                    j++;
                }
            }
        }
        return false;
    }
    private static int[] getPi(String pattern){
        int len = pattern.length();
        int[] pi = new int[len];
        int j = 0;
        for(int i=1; i<len; i++){
            while(j>0 && pattern.charAt(i) != pattern.charAt(j)){
                j=pi[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                pi[i]=++j;
            }
        }
        return pi;
    }
}