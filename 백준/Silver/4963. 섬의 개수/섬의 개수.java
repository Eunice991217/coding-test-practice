import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] visited;
    static int[][] arr;

    static int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            arr = new int[54][54];
            visited = new int[54][54];

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0) break;

            for(int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt=0;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(visited[i][j]==0 && arr[i][j]==1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }
    private static void dfs(int x, int y) {
        visited[x][y] = 1;

        for(int i=0;i<8;i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if(ny<0 || nx<0 || ny>=n || nx >=m) continue;

            if(visited[nx][ny]==0 && arr[nx][ny]==1) {
                dfs(nx, ny);
            }
        }
    }
}