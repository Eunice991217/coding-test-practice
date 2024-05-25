import java.io.*;
import java.util.*;

class Solution {

    static int n, map[][], ans, v[][], sx, sy;
    static int dx[] = {1, 1, -1, -1};
    static int dy[] = {1, -1, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {

            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            v = new int[n][n];
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {
                    if((i==0 && j==0) || (i==0 && j==n-1) || (i==n-1 && j==0) || (i==n-1 && j==n-1)) continue;
                    Set<Integer> set = new HashSet<>();
                    set.add(map[i][j]);
                    v[i][j]=1;
                    sx = i;
                    sy = j;
                    solve(i, j, 0, set);
                }
            }

            if(ans==Integer.MIN_VALUE) {
                ans = -1;
            }

            System.out.println("#" + tc + " " + ans);
        }

        br.close();

    }

    // 왔던 길 다시 돌아 가는건 visit 로 체크
    // 중복 디저트 냠냠 set 으로 체크
    static void solve(int x, int y, int dir, Set<Integer> set) {
        if(dir>=4) {
            // 디저트 수
//            ans = Math.max(ans, set.size());
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx==sx && ny==sy) {
            ans = Math.max(ans, set.size());
            return;
        }
        if(nx>=0 && nx<n && ny>=0 && ny<n && v[nx][ny]==0) {
            if(!set.contains(map[nx][ny])) {
                // 디저트 포함 되어 있지 않으면 추가
                set.add(map[nx][ny]);
                // 왔던 길 체크
                v[nx][ny]=1;
                // 2 방향 으로 갈 수 있음
                // 현재 방향
                solve(nx, ny, dir, set);
                // 다음 방향
                solve(nx, ny, dir+1, set);
                // back tracking
                v[nx][ny]=0;
                // 다시 뱉어
                set.remove(map[nx][ny]);
            }
        }
    }

}

