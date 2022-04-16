import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BOJ_1715 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;
        PriorityQueue<Integer> cards = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            cards.add(scanner.nextInt());
        }

        while(cards.size()>=2){
            int num1 = cards.poll();
            int num2 = cards.poll();
            sum += num1+num2;

            cards.add(num1+num2);
        }
        System.out.print(sum);
    }
}
