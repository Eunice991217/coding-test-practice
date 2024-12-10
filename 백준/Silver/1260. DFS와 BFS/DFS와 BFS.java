import java.util.*;
import java.io.*;

class Main {

    static int N, M, V; // 정점, 간선, 시작할 정점 번호
    static int[][] map;
    static int[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 인접 행렬 만들기
            map[x][y] = 1;
            map[y][x] = 1;
        }

        visited = new int[N+1];
        dfs(V);
        System.out.println();
        visited = new int[N+1];
        bfs(V);

    }

    static void dfs(int v) {
        // v : 시작 정점
        System.out.print(v + " ");
        visited[v] = 1;
        for(int i=1;i<=N;i++) {
            if(map[v][i]==1 && visited[i]==0) {
                visited[i]=1;
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        // v : 시작 정점
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[v] = 1;
        q.add(v);

        while(!q.isEmpty()) {
            int nv = q.poll();
            System.out.print(nv + " ");
            for(int i=1;i<=N;i++) {
                if(map[nv][i]==1 && visited[i]==0) {
                    q.add(i);
                    visited[i]=1;
                }
            }
        }
    }

}