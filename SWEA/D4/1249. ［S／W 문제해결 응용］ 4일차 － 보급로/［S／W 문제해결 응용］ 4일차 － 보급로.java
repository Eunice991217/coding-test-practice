import java.io.*;
import java.util.*;

class Solution {

    static int n, ans;
    static int map[][], v[][], sum[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            v = new int[n][n];
            sum = new int[n][n];
            for(int i=0;i<n;i++) {
                String line = br.readLine();
                for(int j=0;j<n;j++) {
                    map[i][j] = line.charAt(j)-'0';
                }
            }

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    sum[i][j]=Integer.MAX_VALUE;
                }
            }

            sum[0][0]=0;
            solve();
            System.out.println("#" + tc + " " + sum[n-1][n-1]);
        }

    }

    static void solve() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.d-o2.d;});
        q.add(new Node(0, 0, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.d;
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n) {
                    if(sum[nx][ny]>map[nx][ny]+sum[x][y]) {
                        sum[nx][ny] = map[nx][ny]+sum[x][y];
                        q.add(new Node(nx, ny, d+1));
                    }
                }
            }
        }
    }

}

class Node{
    int x;
    int y;
    int d;
    Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}