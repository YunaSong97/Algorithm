import java.util.*;

public class SWEA_1961 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Node> nodeArrayList = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[][] map;
        int[][] map1;
        int[][] map2;
        int[][] map3;
        nodeArrayList = new ArrayList<>();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            map = new int[N][N];
            map1 = new int[N][N];
            map2 = new int[N][N];
            map3 = new int[N][N];

            nodeArrayList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = N - 1; i > -1; i--) {
                for (int j = 0; j < N; j++) {
                    nodeArrayList.add(new Node(j, i));
                }
            }

            System.out.println("#" + test_case);

            map1 = turn90(map, N);
            map2 = turn90(map1, N);
            map3 = turn90(map2, N);

            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                int cnt = 0;
                while (cnt < N) {
                    sb.append(map1[i][cnt++]);
                }
                sb.append(" ");

                cnt = 0;
                while (cnt < N) {
                    sb.append(map2[i][cnt++]);
                }
                sb.append(" ");

                cnt = 0;
                while (cnt < N) {
                    sb.append(map3[i][cnt++]);
                }
                sb.append(" ");
                System.out.println(sb);
            }
        }
    }

    static int[][] turn90(int[][] map, int N) {
        int[][] temp = new int[N][N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Node now = nodeArrayList.get(cnt);
                cnt++;
                temp[now.x][now.y] = map[i][j];
            }
        }

        return temp;
    }
}
