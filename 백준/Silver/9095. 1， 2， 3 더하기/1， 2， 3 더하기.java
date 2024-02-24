import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, cnt=0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            dfs(0);
            System.out.println(cnt);
            cnt=0;
        }

    }

    public static void dfs(int sum) {
        if(n<sum) {
            return;
        }

        if(sum==n) {
            cnt++;
            return;
        }

        dfs(sum+1);
        dfs(sum+2);
        dfs(sum+3);

    }



}
