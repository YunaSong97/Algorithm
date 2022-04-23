import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17086 {
    static int[] dx= {-1, -1, 0, 1, 1, 1, 0, -1};//북 북동 동 남동 남 남서 서 북서
    static int[] dy= {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] visit;
    static int[][] map;
    static int N;
    static int M;
    static Queue<int[]> queue = new LinkedList<>();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.print(ans);
    }
    private static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.add(new int[]{x ,y});
        for (boolean[] arr : visit) Arrays.fill(arr, false);
        visit[x][y] = true;
        int dist = 0;

        while(!queue.isEmpty()){
            int size = queue.size();//size를 먼저 받기

            for (int j = 0; j < size; j++) {
                int[] now = queue.poll();

                if(map[now[0]][now[1]]==1){
                    ans = Math.max(ans, dist);

                    return;
                }
                for (int i = 0; i < 8; i++) {
                    int x_next, y_next;
                    x_next = now[0] + dx[i];
                    y_next = now[1] + dy[i];

                    if(x_next<N && y_next<M && x_next>=0 && y_next>=0 && !visit[x_next][y_next]){
                        visit[x_next][y_next]=true;
                        queue.add(new int[]{x_next, y_next});
                    }
                }
            }
            dist++;
        }
    }
}
