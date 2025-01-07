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

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int dong = Integer.parseInt(st.nextToken());
            arr[i][0] = index;
            arr[i][1] = gold * 1000003 + silver * 1000002 + dong * 1000001;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1]; // 두번째 숫자 기준 오름 차순
            }
        });

        arr[0][2] = 1;
        for(int i=1;i<N;i++) {
            arr[i][2] = i+1;
            if(arr[i-1][1]==arr[i][1]) {
                arr[i][2] = arr[i-1][2];
            }
        }

        System.out.println(arr[K-1][2]);

    }

}