import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int n, m, max=-1;
    static int map[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[21][21];
            max = -1;
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 운영 비용
            // k * k + (k-1) * (k-1)
            // 보안 회사의 이익
            // m * (1의 개수) - 운영 비용

            int oneCnt=0;
            for(int k=1;k<=21;k++) {
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++) {
                        // 제공 받는 집 개수
                        oneCnt = bfs(i, j, k);
                        // 운영 비용
                        int price = k*k + (k-1)*(k-1);
                        // 보안 회사의 이익이 손해를 보지 않는다. (0 이상)
                        if(m*oneCnt - price>=0) {
                            // 최대 몇 개 집 까지 제공 가능 한지
                            max = Math.max(max, oneCnt);
                        }
                    }
                }
            }

            System.out.println("#" + tc+ " " + max);


        }


    }

    static int bfs(int x, int y, int k) {
        int v[][] = new int[21][21];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y, 1));
        v[x][y]=1;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int ck = cur.k;
            if(ck==k) {
                // 제공 받는 집 return
                return check(v);
            }
            for(int i=0;i<4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && v[nx][ny]==0) {
                    v[nx][ny]=1;
                    q.add(new Pair(nx, ny, ck+1));
                }
            }
        }

        return 0;
    }

    static int check(int v[][]) {
        int cnt=0;
        // v == 1 일 때 map 이 1 이면 그게 제공 받는 집
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(v[i][j]==1 && map[i][j]==1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}

class Pair{
    int x;
    int y;
    int k;
    Pair(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }
}