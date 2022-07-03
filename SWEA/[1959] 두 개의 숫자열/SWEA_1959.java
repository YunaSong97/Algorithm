package SWEA;

import java.util.Scanner;

public class SWEA_1959 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int max=-99999;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] intAry1 = new int[n];
            int[] intAry2 = new int[m];

            for (int i = 0; i < n; i++) {
                intAry1[i]=sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                intAry2[i]=sc.nextInt();
            }

            if (n >= m) {
                for (int i = 0; i < n - m + 1; i++) {
                    int sum = 0;
                    for (int j = 0; j < m; j++) {
                        sum += intAry1[j + i] * intAry2[j];
                    }
                    max = Math.max(sum, max);
                }
            } else {
                for (int i = 0; i < m - n + 1; i++) {
                    int sum = 0;
                    for (int j = 0; j < n; j++) {
                        sum += intAry1[j] * intAry2[j+i];
                    }
                    max = Math.max(sum, max);
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}
