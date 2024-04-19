import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k, map[][], ans = -1;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 0 이동, 1 벽
        bfs();
        System.out.println(ans);

    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        int v[][][] = new int[n][m][k+1];
        // 0 벽을 부순 경우
        // 1 벽을 부수지 않은 경우

        q.add(new Node(0, 0, 1, 0));
        v[0][0][0] = 1;


        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.d;
            int kCnt = cur.kCnt;
            if(x==n-1 && y==m-1) {
                ans = d;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0) { // 0 일 떄
                        // 벽을 부순 경우
                        if(v[nx][ny][kCnt]==0) {
                            v[nx][ny][kCnt] = 1;
                            q.add(new Node(nx, ny, d+1, kCnt));
                        }
                    } else { // 1 일때
                        // 이때는 무조건 벽을 부수지
                        if(kCnt<k && v[nx][ny][kCnt+1]==0) {
                            v[nx][ny][kCnt+1]=1; // 부순 경우
                            q.add(new Node(nx, ny, d+1, kCnt+1));
                        }
                    }
                }
            }
        }
    }


}

class Node {
    int x;
    int y;
    int d;
    int kCnt; // 몇번 부쉈는지

    Node(int x, int y, int d, int kCnt) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.kCnt = kCnt;
    }
}