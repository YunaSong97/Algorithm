package SWEA;

import java.util.Scanner;

public class SWEA_1974 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        boolean[] check;
        int[][] map;
        boolean flag;

        for (int test_case = 1; test_case <= T; test_case++) {
            map = new int[9][9];
            flag = false;

            //가로 확인
            for (int i = 0; i < 9; i++) {
                check = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    int now = sc.nextInt();

                    if (check[now - 1] && !flag) {
                        System.out.println("#" + test_case + " " + 0);
                        flag = true;
                    } else {
                        check[now - 1] = true;
                    }
                    map[i][j] = now;
                }
            }
            if (flag) {
                continue;
            }
            //세로 확인
            for (int j = 0; j < 9; j++) {
                check = new boolean[9];
                for (int i = 0; i < 9; i++) {
                    int now = map[i][j];

                    if (check[now - 1]) {
                        System.out.println("#" + test_case + " " + 0);
                        flag = true;
                        break;
                    } else {
                        check[now - 1] = true;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                continue;
            }

            //9칸 확인
            for (int k = 0; k < 3; k++) {
                for (int n = 0; n < 3; n++) {
                    check = new boolean[9];

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            int now = map[k * 3 + i][n * 3 + j];

                            if (check[now - 1]) {
                                System.out.println("#" + test_case + " " + 0);
                                flag = true;
                                break;
                            } else {
                                check[now - 1] = true;
                            }
                        }
                        if (flag) {
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            if (!flag) {
                System.out.println("#" + test_case + " " + 1);
            }
        }
    }
}
