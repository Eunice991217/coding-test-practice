import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, m, sx, sy, ex, ey, ret=Integer.MAX_VALUE;
    static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int map[][], visited[][];
    static PriorityQueue<Pair> pq;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수

        for(int tc=1;tc<=n;tc++) {

            // 체스 판의 크기
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            // 시작
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            // 끝
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            // 초기화
            map = new int[m+1][m+1];
            visited = new int[m+1][m+1];
            pq = new PriorityQueue<>((o1, o2) -> {return o1.d - o2.d;});
            ret=Integer.MAX_VALUE;

            // 탐색
            go();

            // 결과
            System.out.println(ret);

        }


    }

    public static void go() {
        pq.add(new Pair(sx, sy, 0));

        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.d;
            if(x==ex && y==ey) {
                ret = d;
                return;
            }
            for(int i=0;i<8;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<m && visited[nx][ny]==0) {
                    pq.add(new Pair(nx, ny, d+1));
                    visited[nx][ny]=1;
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

