package SWEA;

import java.util.Scanner;

public class SWEA_2001 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            int max = -1;
            for (int k = 0; k <= n - m; k++) {
                for (int l = 0; l <= n - m; l++) {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            sum += map[k+i][l+j];
                        }
                    }
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }

            System.out.println("#"+test_case+" "+max);
        }
    }
}
