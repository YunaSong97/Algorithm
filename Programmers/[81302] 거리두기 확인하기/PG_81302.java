import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PG_81302 {
    int k, ans;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visit = new boolean[5][5];

    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (k = 0; k < places.length; k++) {
            ans = 1;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (boolean[] arr : visit) Arrays.fill(arr, false);

                    if(places[k][i].charAt(j) == 'P'){
                        visit[i][j]=true;
                        //dfs(i, j, places, 0);
                        bfs(i, j, places);
                    }
                }
            }

            answer[k]=ans;
        }

        return answer;
    }
    private void bfs(int x, int y, String[][] places){
        int cnt = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visit[x][y] = true;

        while (!q.isEmpty() && cnt < 2) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pair now = q.poll();
                x = now.x;
                y = now.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (isIn(nx, ny) && !visit[nx][ny] && places[k][nx].charAt(ny) != 'X') {
                        if (places[k][nx].charAt(ny) == 'P') {
                            ans = 0;
                            return;
                        }
                        visit[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
            cnt++;
        }
    }
    private void dfs(int x, int y, String[][] places, int cnt){

        if (places[k][x].charAt(y) == 'P' && cnt > 0) {
            ans = 0;
            return;
        }

        if(cnt == 2){
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isIn(nx, ny) && !visit[nx][ny] && places[k][nx].charAt(ny) != 'X') {
                visit[nx][ny]=true;
                dfs(nx, ny, places, cnt + 1);
                visit[nx][ny]=false;
            }
        }
    }

    private boolean isIn(int i, int j){
        return i < 5 && j < 5 && i >= 0 && j >= 0;
    }
}