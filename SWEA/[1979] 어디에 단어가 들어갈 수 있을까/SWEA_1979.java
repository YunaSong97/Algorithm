package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1979 {
    static boolean[][] visit;
    static int ans;

    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            ans = 0;
            visit = new boolean[m][m];

            int[][] map = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        int cnt = 1;
                        if (j == 0 || map[i][j - 1] == 0) {
                            while (true) {
                                j++;
                                if(!isIn(i, j, m) || map[i][j] == 0){
                                    break;
                                }
                                cnt++;
                            }
                            if (cnt == n) {
                                ans++;

                            }
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[j][i] == 1) {
                        int cnt = 1;
                        if (j == 0 || map[j-1][i] == 0) {
                            while (true) {
                                j++;
                                if(!isIn(i, j, m) || map[j][i] == 0){
                                    break;
                                }
                                cnt++;
                            }
                            if (cnt == n) {
                                ans++;

                            }
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }


    static boolean isIn(int x, int y, int m) {
        return x < m && x >= 0 && y < m && y >= 0;
    }

}
