import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

class Main
{
    static int m, n;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int map[][], visited[][];

    static Queue<pair> q = new LinkedList<>();

    // 1 : 익은 토마토
    // 0 : 익지 않은 토마토
    // -1 : 토마토 가 없는 칸

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[1001][1001];
        visited = new int[1001][1001];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new pair(i, j));
                }
            }
        }

        bfs();

        int ret = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                ret = Math.max(ret, visited[i][j]);
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(map[i][j]==0 && visited[i][j]==0) {
                    ret=-1;
                }
            }
        }

        System.out.println(ret);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            pair p = q.poll();
            int nx = p.x;
            int ny = p.y;
            for(int i=0;i<4;i++) {
                int ax = nx + dx[i];
                int ay = ny + dy[i];
                if(ax<n && ax>=0 && ay<m && ay>=0 && map[ax][ay]==0 && visited[ax][ay]==0) {
                    visited[ax][ay]=visited[nx][ny]+1;
                    q.add(new pair(ax, ay));
                }
            }
        }
    }
}

class pair{
    int x;
    int y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

