import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_17143 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans = 0;

    static {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Shark> sharks = new ArrayList<>();
    static int R = Integer.parseInt(st.nextToken());
    static int C = Integer.parseInt(st.nextToken());
    static int M = Integer.parseInt(st.nextToken());

    static int[][] map = new int[R][C];
    static ArrayList<Integer> del_idx = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            if (d == 0 || d == 1)
                s = s % ((R - 1) * 2);
            else
                s = s % ((C - 1) * 2);

            map[r][c]=i;
            sharks.add(new Shark(i, r, c, s, d, z));
        }

        catchShark();
        System.out.print(ans);
    }
    private static void catchShark(){
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (map[j][i] != 0) {//상어발견
                    ans+=getShark(map[j][i]).z;
                    sharks.remove(getShark(map[j][i]));//상어잡기
                    break;
                }
            }
            map = new int[R][C];
            //상어이동
            for(Shark shark : sharks){
                shark.move();
            }
            //먹기
            for(Shark shark : sharks){
                if(map[shark.r][shark.c]!=0){
                    if(getShark(map[shark.r][shark.c]).z>shark.z){
                        del_idx.add(shark.idx);
                    }else{
                        del_idx.add(getShark(map[shark.r][shark.c]).idx);
                        map[shark.r][shark.c] = shark.idx;
                    }
                }else{
                    map[shark.r][shark.c] = shark.idx;
                }
            }

            for (Integer delIdx : del_idx) {
                sharks.remove(getShark(delIdx));
            }

            del_idx = new ArrayList<>();

        }
    }
    public static Shark getShark(int idx){
        for(int i=0; i< sharks.size();i++){
            if(sharks.get(i).idx==idx){
                return sharks.get(i);
            }
        }
        return null;
    }
    static class Shark{
        int r, c, s ,d, z, idx;
        public Shark(int idx, int r, int c, int s, int d, int z) {
            this.idx = idx;//상어번호
            this.r = r;//row
            this.c = c;//col
            this.s = s;//속력
            this.d = d;//이동방향
            this.z = z;//크기
        }
        public void move(){
            int[] dr = {-1, 1, 0, 0};//d = 0위, 1아래, 2오, 3왼
            int[] dc = {0, 0, 1, -1};

            for (int i = 0; i < this.s; i++) {
                int x = this.r + dr[this.d];
                int y = this.c + dc[this.d];
                if (!(0 <= x && x < R && 0 <= y && y < C)) {
                    turn();
                    x = this.r + dr[this.d];
                    y = this.c + dc[this.d];
                }
                this.r = x;
                this.c = y;
            }

        }
        public void turn(){
            switch (this.d) {
                case 0:
                    this.d = 1;
                    break;
                case 1:
                    this.d = 0;
                    break;
                case 2:
                    this.d = 3;
                    break;
                case 3:
                    this.d = 2;
            }
        }
    }
}