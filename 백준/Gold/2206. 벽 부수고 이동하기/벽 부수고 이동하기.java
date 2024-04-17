import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, map[][], ans=-1;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        // 0 : 이동
        // 1 : 벽
        // 벽 1 개 까지 부수고 이동 가능

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++) {
            String line = br.readLine();
            for(int j=0;j<m;j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }

        bfs();

        System.out.println(ans);

    }

    // 최단 경로 : bfs
    static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        int v[][][] = new int[n][m][2];
        // 0, 0 은 무조건 벽이 아님
        q.add(new Pair(0, 0, 1, false));
        v[0][0][0] = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.d;
            boolean c = cur.crush;
            if(x==n-1 && y==m-1) {
                ans = d;
                return;
            }
            // [0] -> 벽을 한번도 안부순 애들 탐색
            // [1] -> 벽을 한번 부수고 탐색
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    if(map[nx][ny]==0) {
                        if(c && v[nx][ny][1]==0) { // 벽을 1번 이라도 부순 적이 있다묜?
                            q.add(new Pair(nx, ny, d+1, true));
                            v[nx][ny][1]=1;
                        }else if(!c && v[nx][ny][0]==0) { // 벽을 부순 적이 없다묜?
                            q.add(new Pair(nx, ny, d+1, false));
                            v[nx][ny][0]=1;
                        }
                    }
                    else if(map[nx][ny]==1) {
                        // 벽을 부수지 않았으면 부숴 버려
                        if(!c) {
                            q.add(new Pair(nx, ny, d+1, true));
                            v[nx][ny][1]=1;
                        }
                    }
                }
            }

        }

        ans = -1;
    }


}

class Pair {
    int x;
    int y;
    int d;
    boolean crush;
    Pair(int x, int y, int d, boolean crush) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.crush = crush;
    }
}