import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14226 {

    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        bfs(S);
    }
    private static void bfs(int s) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        boolean[][] visited = new boolean[1001][1001];
        visited[0][1] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();

            if(current.total == s) {
                System.out.println(current.time);
                return;
            }

            // 1. 화면에 있는 이모티콘 클립보드에 저장
            q.add(new Node(current.total, current.total, current.time + 1));


            // 2. 클립보드에 있는 이모티콘 붙여넣기. 
            // 클립보드 비어있지 않아야하고, 붙여넣은 후 개수가 총 개수보다 적어야 하며, 이전에 방문한적 없어야함.
            if(current.clipboard != 0 && current.total + current.clipboard <= s && !visited[current.clipboard][current.total + current.clipboard]) {
                q.add(new Node(current.clipboard, current.total + current.clipboard, current.time + 1));
                visited[current.clipboard][current.total + current.clipboard] = true;
            }

            // 3. 화면에 있는 이모티콘 중 하나 삭제.
            // 총 개수 1보다 크거나 같아야하고, 방문한적 없어야함.
            if(current.total >= 1 && !visited[current.clipboard][current.total - 1]) {
                q.add(new Node(current.clipboard, current.total - 1, current.time + 1));
                visited[current.clipboard][current.total - 1] = true;
            }
        }
    }
    
    public static class Node {
        int clipboard;
        int total;
        int time;

        public Node(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
}
