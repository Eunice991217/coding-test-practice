import java.io.*;
import java.util.*;

class Main {
    static int n, x, y, n1, n2, m, ans=-1;
    static int map[][], v[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 전체 사람 수

        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        v = new int[n+1];

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y]=map[y][x]=1;
            // 가족 혹은 친척들 사이의 관계 -> 촌수
        }

        bfs(n1);

        System.out.println(ans);

    }

    static void bfs(int u) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(u, 0));
        v[u] = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int d = cur.d;

            if(x==n2) {
                ans = d;
                break;
            }

            for(int i=1;i<=n;i++) {
                if(map[x][i]==1 && v[i]==0) {
                    q.add(new Node(i, d+1));
                    v[i] = 1;
                }
            }
        }
    }
}

class Node{
    int x;
    int d;
    Node(int x, int d) {
        this.x = x;
        this.d = d;
    }
}