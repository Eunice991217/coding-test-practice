import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, ret=0;
    static int map[][];
    static int dx[] = {0, 1, 1};
    static int dy[] = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(1, 2, 0); // 0 : 가로

        System.out.println(ret);

    }

    public static void go(int x, int y, int dir) {
        if(x<1 || x>=n+1 || y<1 || y>=n+1) return;
        if(map[x][y]==1) return;
        if(dir==1 && checkCross(x, y)) return;

        // 0 : 가로, 1 : 대각선, 2 : 세로
        if(x==n && y==n) {
            ret++;
            return;
        }

        // 가로, 세로
        if(dir==0 || dir==2) {
            go(x+dx[dir], y + dy[dir], dir); // 가로 or 세로
            go(x+dx[1], y+dy[1], 1); // 대각선
        }

        // 대각선
        else {
            for(int i=0;i<3;i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
                    go(nx, ny, i);
                }
            }
        }

    }

    public static boolean checkCross(int x, int y) {
        if(x-1>=1 && x-1<=n && map[x-1][y]==1) return true;
        if(y-1>=1 && y-1<=n && map[x][y-1]==1) return true;
        return false;
    }



}

