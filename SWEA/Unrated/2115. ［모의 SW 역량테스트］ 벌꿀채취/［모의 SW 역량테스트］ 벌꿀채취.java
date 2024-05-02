import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

    static int n, m, c, ans=0, work1=0, work2=0;
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
            ans=0;
            work1=0;
            work2=0;

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve();
            System.out.println("#" + tc + " " + ans);
        }
    }

    // 조합 (벌통 2개 뽑기, 일꾼 2명)
    static void solve() {
        int check[][] = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n-m+1;j++) {

                for(int k=j;k<j+m;k++) {
                    check[i][k] = 1;
                }

                int flag=0;
                for(int a=0;a<n;a++) {
                    for(int b=0;b<n-m+1;b++) {
                        for(int c=0;c<m;c++) {
                            if(check[a][b+c]==1) {
                                flag=1;
                                break;
                            }
                        }
                        if(flag==1) continue;

                        // 벌통 다 선택 했으면
                        // 수익 계산
                        cal(i, j, a, b, 0);
                        ans = Math.max(ans, work1+work2);
                        work1 = 0;
                        work2 = 0;
                    }
                }

                // backtracking
                for(int k=j;k<j+m;k++) {
                    check[i][k] = 0;
                }

            }
        }
    }

    // 부분 집합 (뽑은 벌통들 중에 수익의 합 최대)
    static void cal(int i, int j, int a, int b, int depth) {
        if(depth==m) {
            int cnt1=0, cnt2=0, profit1=0, profit2=0;
            // cnt1, cnt2 : c 보다 작은지 확인
            // profit1, profit2 : 수익의 합
            for(int k=0;k<m;k++) {
                if(v[k]==1) {
                    cnt1+=map[i][j+k];
                    profit1+=(int) Math.pow(map[i][j+k], 2);
                    cnt2+=map[a][b+k];
                    profit2+=(int) Math.pow(map[a][b+k], 2);
                }
            }
            if(cnt1<=c) work1 = Math.max(work1, profit1);
            if(cnt2<=c) work2 = Math.max(work2, profit2);
            return;
        }

        v[depth]=1;
        cal(i, j, a, b, depth+1);
        v[depth]=0;
        cal(i, j, a, b, depth+1);
    }

}