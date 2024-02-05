import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static List<List<Integer>> list;
    static int visited[];

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new int[5004];

        Arrays.fill(visited, -1);

        for(int i=0;i<5004;i++) {
            list.add(new ArrayList<>());
        }

        int x=0, y=0;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        int sum=0;
        int minCnt=Integer.MAX_VALUE;
        int ret=0;
        for(int i=1;i<=n;i++) {
            bfs(i);
            for(int j=1;j<=m;j++) {
                sum+=(visited[j]);
            }
            if(minCnt>sum) {
                minCnt = sum;
                ret = i;
            }
            Arrays.fill(visited, -1);
            sum=0;
        }

        System.out.println(ret);

    }

    public static void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u] = 1;

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int i=0;i<list.get(x).size();i++) {
                int next = list.get(x).get(i);
                if(visited[next]==-1) {
                    q.add(next);
                    visited[next] = visited[x]+1;
                }
            }
        }
    }

}