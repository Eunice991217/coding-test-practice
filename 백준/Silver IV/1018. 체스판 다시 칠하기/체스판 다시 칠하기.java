import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char s[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        s = new char[n][m];

        for(int i=0;i<n;i++) {
            String line = br.readLine();
            for(int j=0;j<m;j++) {
                s[i][j] = line.charAt(j);
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i+7<n && j+7<m) {
                    min = Math.min(check(i, j, s), min);
                }
            }
        }

        System.out.println(min);

    }

    public static int check(int x, int y, char s[][]) {
        int cnt=0;
        char prev='W';

        for(int i=x;i<x+8;i++) {
            for(int j=y;j<y+8;j++) {
                if(s[i][j]!=prev) {
                    cnt++;
                }
                if(prev=='W') {
                    prev='B';
                }else {
                    prev='W';
                }
            }
            if(prev=='W') {
                prev='B';
            }else {
                prev='W';
            }
        }

        cnt = Math.min(cnt, 64-cnt);

        return cnt;
    }


}
