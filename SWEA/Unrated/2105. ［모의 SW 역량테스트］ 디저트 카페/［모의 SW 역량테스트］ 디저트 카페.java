import java.io.*;
import java.util.*;

class Solution {

    static int n, map[][], max=-1, v[][], ans=-1;
    static int sx, sy;
    static int dx[] = {-1, -1, 1, 1};
    static int dy[] = {-1, 1, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            v = new int[n][n];
            max=-1;
            ans=-1;
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 0, 0
            // 0, n-1
            // n-1, 0
            // n-1, n-1
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if((i==0 && j==0) || (i==0 && j==n-1) || (i==n-1 && j==0) || (i==n-1 && j==n-1)) continue;
                    // 시작 지점
                    sx = i;
                    sy = j;
                    solve(i, j, 0, 1, new HashSet<>());
                }
            }

            System.out.println("#" + tc + " " + ans);
        }

    }

    static void solve(int x, int y, int dir, int depth, Set<Integer> set) {
        set.add(map[x][y]);
        v[x][y]=1;

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위 안에 있을 때
            if(nx>=0 && nx<n && ny>=0 && ny<n) {
                if(depth==1 || dir==i || (dir+1)%4==i) {
                    if(nx==sx && ny==sy) {
                        ans = Math.max(ans, depth);
                    }
                    if(!set.contains(map[nx][ny]) && v[nx][ny]==0) {
                        set.add(map[nx][ny]);
                        v[nx][ny]=1;
                        solve(nx, ny, i, depth+1, set);
                        set.remove(map[nx][ny]);
                        v[nx][ny]=0;
                    }
                }
            }
        }

    }

}