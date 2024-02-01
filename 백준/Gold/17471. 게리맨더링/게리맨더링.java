import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[], n;
    static boolean visited[];
    static boolean check[];
    static List<Integer> list[];
    static int ret=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        visited = new boolean[n];
        check = new boolean[n];
        list = new ArrayList[n];

        for(int i=0;i<n;i++) {
            list[i] = new ArrayList<Integer>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt=0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt;j++) {
                int tmp = Integer.parseInt(st.nextToken());
                list[i].add(tmp-1);
            }
        }

        combi(0,0);

        if(ret==Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(ret);
        }

    }

    public static void combi(int start, int depth) {
        int groupCnt=0;
        int aTeam=0, bTeam=0;
        Arrays.fill(check, false);
        for(int i=0;i<n;i++) {
            if(!check[i]) {
                bfs(i, visited[i]);
                groupCnt++;
            }
        }
        for(int i=0;i<n;i++) {
            if(visited[i]) aTeam+=arr[i];
            else bTeam+=arr[i];
        }
        if(groupCnt==2) {
            ret = Math.min(ret, Math.abs(aTeam-bTeam));
        }

        for(int i=start;i<n;i++) {
            if(!visited[i]) {
                visited[i]=true;
                combi(i, depth+1);
                visited[i]=false;
            }
        }
    }

    public static void bfs(int u, boolean team) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        check[u] = true;

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int i = 0; i < list[x].size(); i++) {
                int next = list[x].get(i);
                if(!check[next] && visited[next]==team) {
                    q.add(next);
                    check[next]=true;
                }
            }
        }
    }

}