import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[], tmp[];
    static boolean visited[];
    static boolean check[];
    static List<Integer> list[];
    static int ret=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[11];
        tmp = new int[11];

        visited = new boolean[101];
        check = new boolean[101];
        list = new ArrayList[11];

        Arrays.fill(visited, false);

        for(int i=0;i<11;i++) {
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

        combi(0,0, n);

        if(ret==Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(ret);
        }


    }

    public static void combi(int start, int depth, int r) {
        if(depth<=r) {
            int groupCnt=0;
            int aTeam=0, bTeam=0;
            Arrays.fill(check, false);
            for(int i=0;i<r;i++) {
                if(!check[i]) { // 같은 팀 확인 용도
                    bfs(i, visited[i]);
                    groupCnt++;
                }
            }
            for(int i=0;i<r;i++) {
                if(visited[i]) aTeam+=arr[i];
                else bTeam+=arr[i];
            }
            if(groupCnt==2) {
                ret = Math.min(ret, Math.abs(aTeam-bTeam));
            }
        }

        for(int i=start;i<r;i++) {
            if(!visited[i]) {
                visited[i]=true;
                combi(i, depth+1, r);
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