import java.util.*;
import java.io.*;

class Main {

    static int N, K;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][3];

        int rank = 1;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int dong = Integer.parseInt(st.nextToken());
            arr[index-1][0] = gold;
            arr[index-1][1] = silver;
            arr[index-1][2] = dong;
        }

        for(int i=0;i<N;i++) {
            if(arr[i][0] > arr[K-1][0]) {
                rank++;
            } else if(arr[i][0] == arr[K-1][0] && arr[i][1] > arr[K-1][1]) {
                rank++;
            } else if(arr[i][0] == arr[K-1][0] && arr[i][1] == arr[K-1][1] && arr[i][2] > arr[K-1][2]) {
                rank++;
            }
        }

        System.out.println(rank);

    }

}