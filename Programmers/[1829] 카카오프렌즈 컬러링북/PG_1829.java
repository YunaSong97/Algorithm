package PG;

import java.util.LinkedList;
import java.util.Queue;

public class PG_1829 {
    class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        boolean[][] visit;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        Queue<Node> queue;

        public int[] solution(int m, int n, int[][] picture) {
            visit = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && picture[i][j] != 0) {
                        visit[i][j] = true;
                        bfs(picture, m, n, i, j, 0);
                        numberOfArea++;
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;

            return answer;
        }

        void bfs(int[][] picture, int m, int n, int x, int y, int cnt) {
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            queue = new LinkedList<>();
            queue.add(new Node(x, y));

            while (!queue.isEmpty()) {
                Node now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (isIn(m, n, nx, ny) && picture[nx][ny] == picture[x][y] && !visit[nx][ny]) {
                        queue.add(new Node(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
                cnt++;
            }
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
        }

        boolean isIn(int m, int n, int x, int y) {
            return x < m && x >= 0 && y < n && y >= 0;
        }
    }
}

