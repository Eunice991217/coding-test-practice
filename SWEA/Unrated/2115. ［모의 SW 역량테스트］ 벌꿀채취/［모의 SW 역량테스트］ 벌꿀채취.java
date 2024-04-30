import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

    static int n, m, c, cost1, cost2, ans=0;
    static int map[][], v[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            v = new int[m];

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cost1 = 0;
            cost2 = 0;
            ans=0;
            solve();
            System.out.println("#" + tc + " " + ans);
        }
    }

    static void solve() {
        int[][] check = new int[n][n];
        int flag=0;
        // 일꾼 1 벌통 위치 찾기
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-(m-1);j++) {
                // 일꾼 1 벌통 방문 처리
                for(int k=j;k<j+m;k++) {
                    check[i][k] = 1;
                }

                // 일꾼 2 벌통 위치 찾기
                for(int a=0;a<n;a++) {
                    for(int b=0;b<n-(m-1);b++) {
                        flag=1;
                        for(int c=0;c<m;c++) { // 일꾼 1 이랑 겹치는 지 체크
                            if(check[a][b+c]==1) {
                                flag=0;
                                break;
                            }
                        }
                        if(flag==0) continue; // 겹치면 통과

                        check(i, j, a, b, 0);
                        ans = Math.max(ans, cost1+cost2);
                        cost1=0;
                        cost2=0;
                    }
                }

                // 일꾼 1 백트래킹
                for(int k=j;k<j+m;k++) {
                    check[i][k] = 0;
                }
            }
        }
    }

    static void check(int i, int j, int a, int b, int depth) {
        if(depth==m) {
            int cnt1=0, cnt2=0, c1=0, c2=0;
            for(int k=0;k<m;k++) {
                if(v[k]==1) {
                    cnt1 += map[i][j+k];
                    c1 += (int) Math.pow(map[i][j+k], 2);
                    cnt2 += map[a][b+k];
                    c2 += (int) Math.pow(map[a][b+k], 2);
                }
            }
            if(cnt1<=c) cost1 = Math.max(cost1, c1);
            if(cnt2<=c) cost2 = Math.max(cost2, c2);
            return;
        }

        // 부분 집합
        v[depth]=1;
        check(i, j, a, b, depth+1);
        v[depth]=0;
        check(i, j, a, b, depth+1);
    }

}
