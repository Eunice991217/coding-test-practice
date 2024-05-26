import java.io.*;
import java.util.*;

class Solution {

    static int n, ans;
    static int dx[] = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int dy[] = {1, 1, 1, 0, -1, -1, -1, 0};
    static int v[][], res[][];
    static char map[][];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {

            n = Integer.parseInt(br.readLine());

            map = new char[n][n];
            res = new int[n][n];
            v = new int[n][n];
            for(int i=0;i<n;i++) {
                String line = br.readLine();
                for(int j=0;j<n;j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            // 지회가 있는 칸 -> 파핑 파핑
            // 지뢰가 없는 칸 -> 변이 맞닿아 있거나 꼭지점이 맞닿아 있는 최대 8칸에 대해
            // 몇 개의 지뢰가 있는 지 0-8사이의 숫자로 클릭한 칸에 표시

            // 지뢰 : *
            // 없는 칸 : .
            // 클릭한 지뢰가 없는 칸 : c
            ans = 0;
            // 지뢰가 없는 칸 부터 늘리고
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    char cnt = cal(i, j);
                    if(cnt=='0' && v[i][j]==0 && map[i][j]=='.') {
                        map[i][j] = cnt;
                        bfs(i,j);
                        ans++;
                    }
                }
            }

            // 지뢰가 있는 칸 늘려
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(v[i][j]==0 && map[i][j]=='.') {
                        map[i][j] = cal(i, j);
                        ans++;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }

        br.close();

    }

    static void print() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void bfs(int x, int y) {
        // 연쇄적 폭발
        // if(cal==0) 이면 주변 다 0 으로 채우고
        // 큐에 넣기
        // 빼면서 또 세고 0 이면 연쇄 폭발
        Queue<Pair> q = new ArrayDeque<>();
        v[x][y]=1;
        q.add(new Pair(x, y));

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            for(int i=0;i<8;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && v[nx][ny]==0 && map[nx][ny]!='*') {
                    char cnt = cal(nx, ny);
                    map[nx][ny] = cnt;
                    v[nx][ny]=1;
                    if(cnt=='0'){
                        // 다시 q 에 넣어
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

    }

    static char cal(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] == '*') {
                    cnt++;
                }
            }
        }
        return (char) (cnt+'0');
    }

}

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
