package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());

        //가장 큰 값을 최대한 앞으로 옮기기

        for (int cur = 0; cur < N && S > 0; cur++) {
            int end = cur + Math.min(S, N - 1 - cur);
            int maxIdx = findMaxIdx(arr, cur, end);

            for (int i = 0; i < maxIdx - cur; i++) {
                swap(arr, maxIdx - i - 1, maxIdx - i);
                S--;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
            if (i != N - 1) {
                System.out.print(" ");
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static int findMaxIdx(int[] arr, int start, int end){
        int max = 0;
        int max_idx = -1;

        for (int i = start; i < end + 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
                max_idx = i;
            }
        }
        return max_idx;
    }
}
