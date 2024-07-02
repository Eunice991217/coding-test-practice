import java.io.*;
import java.util.*;

public class Main {

    static int n, m; // 행렬
    static int[][] map, sum;
    static int maxN;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        sum = new int[n+1][m+1];
        maxN = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + map[i][j];
            }
        }

        for(int x=1;x<=n;x++) {
            for(int y=1; y<=m;y++) {
                for(int xe=x;xe<=n;xe++) {
                    for(int ye=y;ye<=m;ye++) {
                        maxN = Math.max(maxN, sum[xe][ye] - sum[x-1][ye] - sum[xe][y-1] + sum[x-1][y-1]);
                    }
                }
            }
        }

        System.out.println(maxN);
    }
}