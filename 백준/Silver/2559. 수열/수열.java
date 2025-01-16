import java.util.*;
import java.io.*;

public class Main {

    static int n, k, Max;
    static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Max = Integer.MIN_VALUE;
        arr = new int[n+1];
        sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i]=arr[i]+sum[i-1];
        }

        for(int i=0;i<=n-k;i++){
//            System.out.println(sum[i+k]-sum[i]);
            Max = Math.max(Max, sum[i+k]-sum[i]);
        }

        // 0 1 2 3 4 = sum[4]
        // 1 2 3 4 5 = sum[5]-sum[0] = -9-3 = -12 -> sum[k+i]-sum[i]

        System.out.println(Max);

    }




}