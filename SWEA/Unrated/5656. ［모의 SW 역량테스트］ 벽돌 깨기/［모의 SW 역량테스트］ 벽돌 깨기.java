import java.util.*;
import java.io.*;

class Solution {

    static int N, W, H, map[][], ans=Integer.MAX_VALUE, temp[][], res[];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 구슬 쏠 수 있는 횟수
            W = Integer.parseInt(st.nextToken()); // y
            H = Integer.parseInt(st.nextToken()); // x

            map = new int[H][W];
            temp = new int[H][W];
            res = new int [N];

            for(int i=0;i<H;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans=Integer.MAX_VALUE;

            // 0 : 빈 공간
            // 그 외 숫자 : 벽돌
            // 벽돌 1~9
            solve(0);
            System.out.println("#" + tc + " " + ans);

        }
    }

    // 열이랑 행을 다 보고 상대적 으로 1 보다 큰 수가 많은 열이나 행을 뿌셔
    // 구슬은 좌, 우 로만 움직임 -> 항상 맨 위에 있는 벽돌만 깨트릴 수 있음

    // 중복 순열
    static void solve(int depth) {
        // 남은 벽돌 개수 구하기 -> ans (이게 최소가 되도록)
        // ans 가 최소가 되도록 (ans : 남은 벽돌 개수)
        if(ans==0) return; // 최소값이 0 이면 더 확인할 필요 x
        if(depth==N) { // N 개 만큼 뽑는 거임 (N 번 쏠 수 있으니까)
            // 새로운 구슬 이면 벽돌 상태 초기화
            temp = new int[H][W];
            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    temp[i][j] = map[i][j];
                }
            }
            ans = Math.min(ans, shooting());
            return;
        }

        for(int i=0;i<W;i++) { // 열까지
            res[depth] = i; // 구슬 쏘는 열의 위치
            solve(depth+1);
        }

    }

    // 구슬 쏘기
    static int shooting() {
        for(int p=0;p<N;p++) {
            int shootPos = res[p];

            for(int i=0;i<H;i++) {
                if (temp[i][shootPos] != 0) { // 벽돌이 있으면
                    fill(i, shootPos, temp[i][shootPos] - 1); // 벽돌 깨기
                    down(); // 내리기
                    break;
                }
            }
        }

        // 남은 벽돌 세기
        int cnt=0;
        for(int[] m : temp) {
            for(int val : m) {
                if(val!=0) cnt++;
            }
        }

        return cnt++;
    }

    // 폭발 했으면 0 으로 fill
    static void fill(int x, int y, int val) {
        temp[x][y]=0;
        if(val==0) return;

        // n-1 만큼 뿌셔
        // 구슬이 명중한 벽돌 -> 상하좌우로 -1 칸만큼 같이 제거
        for(int k=1;k<=val;k++) {
            for(int d=0;d<4;d++) {
                int nx = x + dx[d]*k;
                int ny = y + dy[d]*k;

                // 범위 안에 있고, 벽돌 이면
                if(nx>=0 && nx<H && ny>=0 && ny<W && temp[nx][ny]!=0) {
                    fill(nx, ny, temp[nx][ny]-1);
                }
            }
        }

    }

    // 밑으로 떨어 지게 (0 이 아닐 때 까지)
    static void down() {
        for(int j=0;j<W;j++) {
            int sx = H-1;

            // 0 인 위치 찾기
            for(int i=sx;i>=0;i--) {
                if(temp[i][j]==0) {
                    sx = i;
                    break;
                }
            }

            // 벽돌이면 시작점과 위치 바꾸기
            for(int i=sx-1; i>=0; i--) {
                if(temp[i][j]!=0 && temp[sx][j]==0) {
                    temp[sx][j] = temp[i][j];
                    temp[i][j] = 0;
                    sx--;
                }
            }
        }
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