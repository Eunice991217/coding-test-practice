import java.io.*;
import java.util.*;

class Main {
    static int n, arr[], map[][], v[], ans=Integer.MAX_VALUE, res[]; // map : 인접 행렬

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        v = new int[n+1];
        for(int i=1;i<=n;i++) {
            // 선거구 인구
            arr[i] = Integer.parseInt(st.nextToken());
        }

        map = new int [n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++){
                // 인접 행렬 만들기
                map[i][Integer.parseInt(st.nextToken())]=1;
            }
        }

        // 선거구 2개로 나누기
        subs(1);
        // 두 선거구 인구 차이의 최솟값 출력
        System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);

    }

    // 선거구 2개로 나누기
    static void subs(int depth) {

        if(depth==n+1) {
            // 두 팀 연결 되어 있는지 확인
            if(bfs(1) && bfs(0)) {
                ans = Math.min(ans, cal());
            }
            return;
        }

        v[depth] = 1;
        subs(depth+1);
        v[depth] = 0;
        subs(depth+1);
    }

    // 연결 확인
    static boolean bfs(int flag) {
        int check[] = new int[n+1];
        LinkedList<Integer> list = new LinkedList<>();

        // 시작점 찾기
        for(int i=1;i<=n;i++) {
            if(v[i]==flag) {
                list.addLast(i);
                check[i]=1;
                break;
            }
        }

        while(!list.isEmpty()) {
            int cur = list.poll();

            for(int i=1;i<=n;i++) {
                // 시작점 또는 flag 와 다른 팀이면 continue
                if(check[i]==1 || flag!=v[i]) continue;
                if(map[cur][i]==1) {
                    list.addLast(i);
                    check[i]=1;
                }
            }
        }

        // 같은 팀인데 방문 안 한 곳이 있는지 확인
        for(int i=1;i<=n;i++) {
            // 모든 정점이 연결 되어 있지 않은 것
            if(v[i]==flag && check[i]==0) return false;
        }

        return true;
    }

    // 두 팀 점수 차 계산
    static int cal() {
        int teamA=0, teamB=0;

        for(int i=1;i<=n;i++){
            if(v[i]==1) teamA+=arr[i];
            else teamB+=arr[i];
        }

        return Math.abs(teamA-teamB);
    }


}