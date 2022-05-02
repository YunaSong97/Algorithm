import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_1644 {
    static boolean[] notPrime;
    static ArrayList<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 1. 에라토스테네스의 채로 소수 구하기
        notPrime = new boolean[N + 1];
        Eratos(N);

        // 2. 연속합으로 주어진 정수 구하기
        int sum = 0, ans = 0;
        int l = 0, h = 0;
        while (true) {
            // sum이 M보다 커지면 l을 증가시킨다.(구간 감소)
            // sum이 M보다 작으면 h를 증가시킨다.(구간 증가)
            // sum == M이면 ans++, l증가
            if (sum >= N) {
                sum -= prime.get(l++);
            } else if (h == prime.size()) {
                break;
            } else {
                sum += prime.get(h++);
            }
            if (sum == N) {
                ans++;
            }
        }

        System.out.print(ans);
    }

    private static void Eratos(int n) {
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!notPrime[i]) {//소수이면
                for (int j = i * i; j <= n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        for (int i = 0; i < n+1; i++) {
            if (!notPrime[i]) {
                prime.add(i);
            }
        }
    }
}
