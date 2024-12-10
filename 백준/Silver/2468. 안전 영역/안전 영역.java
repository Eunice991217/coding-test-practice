import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;
    static int Max;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Max = -1;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        for(int n=1;n<=100;n++) {
            cnt=0;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > n) {
                        cnt++;
                        dfs(i, j, n);
                    }
                }
            }
            Max = Math.max(Max, cnt);
        }

        // 아무 지역도 물에 잠기지 않으면 안정 영역의 최대 개수는 1
        if(Max!=0) System.out.println(Max);
        else System.out.println(1);

    }

    // 안전한 영역의 최대 개수
    static void dfs(int x, int y, int n) {
        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
                if(map[nx][ny]>n) {
                    visited[nx][ny]=true;
                    dfs(nx, ny, n);
                }
            }
        }
    }
}