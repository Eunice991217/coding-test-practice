import java.io.*;
import java.util.*;

class Solution {

    static int n, arr[], v[], brr[];
    static long ans;

    public static void main(String[] args) throws Exception, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            brr = new int[n];
            v = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            solve(0);
            System.out.println("#" + tc + " " + ans);

        }

    }

    // 모든 무게 추를 양팔 저울 위에 올리는 순서 N!
    // 여기는 배열을 순서 대로 정렬 하는 permu 함수
    static void solve(int depth) {
        if(depth==n) {
            subs(0, brr, 0, 0);
            return;
        }

        for(int i=0;i<n;i++){
            if(v[i]==1) continue;
            v[i] = 1;
            brr[depth] = arr[i];
            solve(depth+1);
            v[i] = 0;
        }
    }

    // 각 추를 양팔 저울의 왼쪽에 올릴 지 오른 쪽에 올릴 지 정하는 건 2의 n 승 * n!
    // 오른쪽 위에 올라가 있는 무게의 총합 < 왼쪽에 올라가 있는 무게의 총합 이어야 함
    // 선택 한 경우 -> Right
    // 선택 안한 경우 > Left
    // 부분 집합
    // 배열 순서에 맞게 재배치
    static void subs(int depth, int res[], int rSum, int lSum) {
        if(rSum>lSum) {
            return;
        }

        if(depth==n) {
            if(rSum<=lSum) {
                ans++;
            }
            return;
        }

        subs(depth+1, res, rSum+res[depth], lSum);
        subs(depth+1, res, rSum, lSum+res[depth]);
    }


}