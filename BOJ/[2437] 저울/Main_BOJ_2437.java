import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2437 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum=0;
        int n = scanner.nextInt();
        int[] weight = new int[n];
        for(int i=0; i<n; i++){
            weight[i]=scanner.nextInt();
        }

        Arrays.sort(weight);

        for(int i=0;i<n;i++){
            if(sum+1 < weight[i]){
                break;
            }
            sum+=weight[i];
        }
        System.out.print(sum+1);

        scanner.close();
    }
}
