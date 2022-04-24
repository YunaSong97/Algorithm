import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class PG_62048 {
    static int[][] visit;
    static int n;
    static int cnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};//상 하 좌 우

    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    int[] parent;

    int find(int a) {
        if(parent[a] < 0) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false; //사이클
        parent[b] = a;//a에 b추가
        return true;
    }

    public int solution(int[][] land, int height) {
        int answer = 0;
        n = land.length;//2차원 배열 length = row
        visit = new int[n][n];
        for(var a : visit) Arrays.fill(a, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == -1) {
                    dfs(i, j, land, height);
                    cnt++;
                }
            }
        }
        //edge 구하기
        ArrayList<Edge> e = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (!isIn(nx, ny, n)) continue;
                    if (visit[x][y] == visit[nx][ny]) continue;

                    int comp1 = visit[x][y];
                    int comp2 = visit[nx][ny];

                    int p = Math.abs(land[x][y] - land[nx][ny]);
                    e.add(new Edge(comp1, comp2, p));
                }
            }
        }
        if (e.size() == 0) return 0;//다 갈수있음

        //MST(Kruskal) 1. 오름차순 정렬 2. cycle 없이 순서대로 선택 3. 합
        parent = new int[cnt];
        Arrays.fill(parent, -1);

        //1. 정렬
        Collections.sort(e, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.w, o2.w);//같으면 0, x<y 이면 음수, x>y 이면 양수
            }
        });

        int ladder_cnt = 0;
        for (int i = 0; ; i++) {
            if (union(e.get(i).u, e.get(i).v)) {//사이클이면 false
                //추가했으면
                answer += e.get(i).w;
                if (++ladder_cnt == cnt - 1) break;
            }
        }

        return answer;
    }
    private void dfs(int x, int y, int[][] land, int height) {

        visit[x][y] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isIn(nx, ny, n) && visit[nx][ny] == -1) {
                int height_diff = Math.abs(land[x][y] - land[nx][ny]);

                if (height_diff <= height) {
                    //연결
                    dfs(nx, ny, land, height);
                }
            }
        }
    }

    private boolean isIn(int x, int y, int n) {
        return x < n && y < n && x >= 0 && y >= 0;
    }
}