import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
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

    static int R = Integer.parseInt(st.nextToken());
    static int C = Integer.parseInt(st.nextToken());
    static int M = Integer.parseInt(st.nextToken());

    static private int[][] map = new int[R][C];
    static ArrayList<Shark> sharks = new ArrayList<>() ;
    static ArrayList<Shark> sharks_copy = new ArrayList<>() ;

    public static void main(String[] args) throws IOException {

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            sharks.add(new Shark(i, r, c, s, d, z));
        }
        sharks_copy = sharks;
        catchShark();
        System.out.println(ans);
    }
    private static void catchShark(){
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (map[j][i]!=0) {
                    //1. 상어잡고
                    ans+=sharks.get(map[j][i]-1).z;
                    sharks.remove(map[j][i]-1);
                    //2. 상어이동
                    for (Shark shark : sharks) {
                        shark.move();
                    }
                    break;
                }
            }
        }
    }
    private static Shark[][] makeMap(ArrayList<Shark> sharks_copy){
        map = new int[R][C];
        for (int i=0; i<sharks_copy.size();i++) {
            Shark shark = sharks_copy.get(i);
            if(map[shark.r][shark.c]!=0) {
                if (map[shark.r][shark.c].z > shark.z) {
                    shark.eaten();
                }else{
                    sharks_copy.get()
                }
            }
            map[shark.r][shark.c] = shark;
        }
        return map;
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
            int[] dr = {1, -1, 0, 0};//d = 0위, 1아래, 2오, 3왼
            int[] dc = {0, 0, 1, -1};

            for (int i = 0; i < this.s; i++) {
                if (this.r == 0 || this.r == R-1 || this.c == 0 || this.c == C-1) {
                    turn();
                }
                this.r += dr[this.d];
                this.c += dc[this.d];
            }
            
            makeMap(sharks);
        }
        public void eaten(){
            sharks.remove(this);
        }
        public void turn(){
            switch (this.d) {
                case 0 -> this.d = 1;
                case 1 -> this.d = 0;
                case 2 -> this.d = 3;
                case 3 -> this.d = 2;
            }
        }
    }

}