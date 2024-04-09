import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class Solution {

    static int n, map[][], min = Integer.MAX_VALUE, b[], v[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            b = new int[n];
            v = new int[n];
            min = Integer.MAX_VALUE;

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            comb(0, 0);

            System.out.println("#" + tc + " " + min);

        }


    }

    static void comb(int cnt, int start) {
        if(cnt>=n/2) {
            int asum=0, bsum=0;
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    if(v[i]==1 && v[j]==1) {
                        asum+=map[i][j];
                        asum+=map[j][i];
                    }else if(v[i]==0 && v[j]==0){ // v[i] == 0
                        bsum+=map[i][j];
                        bsum+=map[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(asum-bsum));
            return;
        }

        for(int i=start;i<n;i++) {
            v[i] = 1;
            comb(cnt+1, i+1);
            v[i] = 0;
        }

    }

}