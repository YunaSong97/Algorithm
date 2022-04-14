import java.util.Scanner;

public class Main_BOJ_9251 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();

        int[][] m = new int[str1.length()+1][str2.length()+1];

        for(int i=1; i<str1.length()+1; i++){
            for(int j=1; j<str2.length()+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    m[i][j] = m[i-1][j-1]+1;
                }else{
                    m[i][j] = Math.max(m[i][j-1], m[i-1][j]);
                }
            }
        }
        System.out.print(m[str1.length()][str2.length()]);
        scanner.close();
    }
}
