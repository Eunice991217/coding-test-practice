import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int n; // 집의 크기
    static int ret = 0;
    static int map[][];
    static int dy[] = {1, 1, 0};
    static int dx[] = {0, 1, 1};

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        if (map[n][n]==1) {
    	   System.out.println(0);
    	   return;
    	}

        bfs(1, 2, 0);
        System.out.println(ret);

    }

    public static void bfs(int x, int y, int d) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, d));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int nx = cur.x;
            int ny = cur.y;
            int nd = cur.d;

            if (nx == n && ny == n) {
                ret++;
                continue;
            }

            for (int i = 0; i < 3; i++) {
                // 0 : 가로, 1 : 대각선, 2 : 세로
                if (nd == 0 && i == 2) { // 가로
                    continue;
                }
                if (nd == 2 && i == 0) { // 세로
                    continue;
                }
                int ax = dx[i] + nx;
                int ay = dy[i] + ny;
                if (ax >= 1 && ax <= n && ay >= 1 && ay <= n && map[ax][ay] != 1) {

                    // 다음 꺼가 대각선 일 때
                    // 가로, 세로, 대각선 중에 1이 있으면
                    // break;
//                    if (map[ax][ay] == 1) {
//                        continue;
//                    }
                    if (i == 1) {
                        if (map[nx][ny + 1] == 1) {
                            continue; // 가로
                        }
                        if (map[nx + 1][ny] == 1) {
                            continue; // 세로
                        }
                    }
                    q.add(new Pair(ax, ay, i));
                }
            }
        }

    }


}

class Pair {
    int x;
    int y;
    int d;

    Pair(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}



