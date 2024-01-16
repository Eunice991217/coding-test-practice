import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m, i;

    static ArrayList<ArrayList<Integer>> L;
    static int[] visited;
    static int[] ret;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        i = Integer.parseInt(st.nextToken());

        L = new ArrayList<>();
        visited = new int[n+1];
        ret = new int[n+1];

        for(int i=0;i<=n;i++) {
            L.add(new ArrayList<>());
        }

        int x=0, y=0;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine()); // 새로운 줄 읽어 오기
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            L.get(x).add(y);
            L.get(y).add(x);
        }

        for(List<Integer> list : L) {
            Collections.sort(list);
        }

        if(visited[i]==0) {
            bfs(i);
        }

        for(int i=1;i<=n;i++) {
            System.out.println(ret[i]);
        }

    }

    private static void bfs(int u) {
        visited[u]=1;
        q.add(u);
        int cnt=1;
        ret[u] = cnt++;

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int i=0;i< L.get(x).size();i++) {
                int next = L.get(x).get(i);
                if(visited[next]==0) {
                    q.add(next);
                    visited[next]=1;
                    ret[next] = cnt++;
                }
            }
        }

    }

}