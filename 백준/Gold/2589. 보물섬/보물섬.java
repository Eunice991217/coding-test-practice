import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.io.FileInputStream;

class Main
{

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int n, m, cnt=1, max = Integer.MIN_VALUE;
    static char map[][];
    static int visited[][];

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[51][51];
        visited = new int[51][51];

        for(int i=0;i<n;i++) {
            String line = br.readLine();
            for(int j=0;j<m;j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(visited[i][j]==0 && map[i][j]=='L') {
                    bfs(i, j);
                    init(visited);
                }
            }
        }

        System.out.println(max-1);

    }

    public static void init(int[][] a) {
        for(int i=0;i<51;i++){
            for(int j=0;j<51;j++) {
                a[i][j]=0;
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        visited[x][y] = 1;
        q.add(x);
        q.add(y);

        while(!q.isEmpty()) {
            int nx = q.poll(); // x
            int ny = q.poll(); // y
            cnt++;
            for(int i=0;i<4;i++) {
                int ax = nx + dx[i];
                int ay = ny + dy[i];
                if(ax<n && ax>=0 && ay<m && ay>=0 && visited[ax][ay]==0 && map[ax][ay]=='L') {
                    visited[ax][ay] = visited[nx][ny]+1;
                    max = Math.max(max, visited[ax][ay]);
                    q.add(ax);
                    q.add(ay);
                }
            }
        }
    }

}
