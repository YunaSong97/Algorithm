import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, ans = 0;
        int l = 0, h = 0;
        while (true) {
            // sum이 M보다 커지면 l을 증가시킨다.(구간 감소)
            // sum이 M보다 작으면 h를 증가시킨다.(구간 증가)
            // sum == M이면 ans++, l증가
           if (sum >= M) {
               sum -= A[l++];
           } else if (h == N) {
               break;
           } else {
               sum += A[h++];
           }
           if (sum == M) {
               ans++;
           }
        }
        System.out.print(ans);
    }
}
