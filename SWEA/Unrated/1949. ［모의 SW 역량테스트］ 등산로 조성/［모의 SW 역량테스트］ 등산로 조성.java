import java.io.*;
import java.util.*;

class Solution {

    static int n, K, ans, map[][], temp[][], max, v[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static List<Pair> list;

    public static void main(String[] args) throws Exception, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            map = new int[n][n];
            temp = new int[n][n];
            v = new int[n][n];
            max = -1;
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    // 숫자는 각 지형의 높이를 나타 냄.
                    map[i][j] = Integer.parseInt(st.nextToken());
                    temp[i][j] = map[i][j];
                    max = Math.max(max, map[i][j]); // 봉우리 에서 가장 큰 값 찾기
                }
            }
            // 1. 등산로는 가장 높은 봉우리에서 시작
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    // 가장 높은 봉우리 idx 저장
                    if(max==map[i][j]) list.add(new Pair(i, j));
                }
            }

            ans = -1;
            for(int i=0;i<list.size();i++) {
                reset(v);
                solve(list.get(i).x, list.get(i).y, false, 1);
            }
            System.out.println("#" + tc + " " + ans);

        }

    }

    // 깊이 파고 드는 거라 dfs 활용
    static void solve(int x, int y, boolean check, int depth) {
        ans = Math.max(depth, ans); // 가장 긴 depth 가 가장 긴 경사로

        v[x][y]=1;

        // 높이가 같은 곳 혹은 낮은 지형, 대각선 방향은 연결 불가
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && v[nx][ny]==0) {
                // 2. 등산로 산으로 올라갈 수 있도록 반드시 높은 지형 에서 낮은 지형 으로
                // x, y : 현재
                // nx, ny : 다음
                // 다음은 현재 보다 작아야 함 (다음 < 현재)

                // 이미 깎은 경우
                if(check) {
                    if(map[nx][ny]<map[x][y]) { // 현재 보다 다음 꺼가 작을 때만
                        solve(nx, ny, true, depth+1);
                    }
                }else { // 안 깎은 경우
                    // 현재 보다 다음 꺼가 크면 1번 깎아 봐
                    // 3. 딱 한 곳을 정해서 최대 K 깊이 만큼 지형을 깎아
                    // k : 최대 공사 가능 깊이
                    if(map[nx][ny]>=map[x][y]) {
                        int cut = map[nx][ny]-map[x][y]+1; // 자를 수 있는 범위
                        if(cut<=K) { // 최대 자를 수 있는 게 K 보다 작거나 같으면
                            map[nx][ny]-=cut; // 깎아
                            // 깎으면 true 로 체크
                            solve(nx, ny, true, depth+1);
                            map[nx][ny]+=cut; // 다시 복구
                        }
                    }else {
                        // 현재 보다 다음 꺼가 작으면
                        // 안 깎고 다음 꺼 확인
                        solve(nx, ny, false, depth+1);
                    }
                }
            }
        }

        v[x][y]=0;

    }

    // 초기화
    static void reset(int arr[][]){
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = 0;
            }
        }
    }

    // print
    static void print(int arr[][]) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}

class Pair{
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}