import java.io.*;
import java.util.*;

class Main {

    static int n, m, tree[];
    static long l=0, r=1000000000, mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new int[1000001];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        long sum=0;
        while(l<=r) {
            // 나무 절단기 의 높이
            mid = (l+r)/2;

            sum=0;
            for(int i=0;i<n;i++) {
                if(tree[i]<mid) continue;
                sum+=(tree[i]-mid);
            }

            if(sum>=m) {
                l = mid+1;
            } else {
                r = mid-1;
            }

        }

        System.out.println(r);


    }


}



