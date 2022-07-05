package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1979 {
    static boolean[][] visit;

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
            visit = new boolean[m][m];

            int[][] map = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j]=sc.nextInt();
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        dfs(map, i, j);
                    }
                }
            }


        }
    }

    static void dfs(int map[][], int x, int y){
        int dx[] = {1, 0};
        int dy[] = {0, 1};

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(map[nx][ny]==1)
        }
    }

}
