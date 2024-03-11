import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

class Main
{
    static int n, m, ret=Integer.MAX_VALUE;
    // m : 치킨 집 개수
    static int map[][];
    static List<pair> ckList, hList, v;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        ckList = new ArrayList<>();
        hList = new ArrayList<>();
        v = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                // ckList 에 배열 에서 2인 값일 때 마다 치킨 집을 저장해
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    ckList.add(new pair(i, j));
                }
                // hList 에 배열 에서 1인 값일 때 마다 집을 저장해
                if(map[i][j]==1) {
                    hList.add(new pair(i, j));
                }
            }
        }

        go(0);

        System.out.println(ret);

    }

    // 치킨 집을 먼저 선택
    // 집 이랑 거리 계산
    // 최소 찾기 depth 별로
    // 그 중에 가장 최소가 정답
    public static void go(int idx) {
        if(idx>=ckList.size()) {
            int sum=0;
            if(v.size()>m) return;
            for(int i=0;i<hList.size();i++) { // 1 : 집 list
                int Min = 9999;
                for (int j = 0; j < v.size(); j++) { // 2 : 치킨 집 list
                    // 집 이랑 거리 계산
                    Min = Math.min(Min, dis(hList.get(i).x, hList.get(i).y, v.get(j).x, v.get(j).y));
                }
                sum+=Min;
            }
            ret = Math.min(sum, ret);
            return;
        }

        v.add(ckList.get(idx));
        go(idx + 1);

        v.remove(v.size() - 1);
        go(idx + 1);
    }

    // 거리 계산
    public static int dis(int rx, int ry, int cx, int cy) {
        return Math.abs(rx-cx) + Math.abs(ry-cy);
    }


}

class pair{
    int x;
    int y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

