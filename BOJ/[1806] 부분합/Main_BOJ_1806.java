import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i]= Integer.parseInt(st.nextToken());
        }

        int ans = N, sum = 0;
        int l = 0, h = 0, flag = 0;
        while (true) {
            if (sum >= S) {
                flag = 1;
                ans = Math.min(ans, h - l);
                sum -= A[l++];
            } else if (h == N) {
                break;
            } else {
                sum += A[h++];
            }
        }
        if (flag == 0) {
            ans = 0;
        }
        System.out.print(ans);
    }
}
