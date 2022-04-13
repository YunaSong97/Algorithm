import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String formula = scanner.next();
        String[] num1;
        String[] num2;
        int sum;
        int ans = 0;

        num1 = formula.split("-");
        for(int i=0;i<num1.length;i++){
            num2 = num1[i].split("\\+");
            sum = 0;
            for (String s : num2) {
                sum += Integer.parseInt(s);
            }
            if(i==0) {
                ans = sum;
            }else{
                ans -= sum;
            }
        }

        System.out.print(ans);
        scanner.close();
    }
}
