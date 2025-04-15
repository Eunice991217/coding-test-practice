import java.util.*;
import java.io.*;

public class Main {

    static int n, ans;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n];
        dp[0] = arr[0];
        if(n==1) {
            System.out.println(dp[0]);
            return;
        }
        dp[1] = arr[0] + arr[1];
        if(n==2) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));

        for(int i=3;i<n;i++) {
            // dp[i-1] : OOX
            // dp[i-2] + arr[i] : OXO
            // dp[i-3] + arr[i-1] + arr[i] : XOO
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
        }

        System.out.println(dp[n-1]);

    }

}