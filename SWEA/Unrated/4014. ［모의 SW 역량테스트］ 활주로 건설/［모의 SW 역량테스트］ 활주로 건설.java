import java.io.*;
import java.util.*;

class Solution {

    static int n, x, map[][], ans=0, visited[]; // x : 경사로 길이

    public static void main(String[] args) throws Exception, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            visited = new int[n]; // 겹치는 것 처리 해주기 위한 체크 배열
            // 각 셀의 숫자 = 그 지형의 높이
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 활주로 건설할 수 있는 경우의 수 계산 : ans
            ans = solve();
            System.out.println("#" + tc + " " + ans);

        }

    }

    static int solve() {
        // 가로 또는 세로 방향 으로 건설 할 수 있는 가능성 확인
        int cnt=0;

        // 반전
        int temp[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                temp[i][j] = map[j][i];
            }
        }

        // 한 줄씩 잘라서 check 함수로 넘겨
        for(int i=0;i<n;i++) {
            // 가로
            if(check(map[i])) {
                cnt++;
            }
            // 세로
            if(check(temp[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    // true 면 활주로 건설 가능
    // 여기서 활주로 건설 가능 한지 체크
    // x : 경사로 길이, 높이는 1
    // arr 배열이 한 줄의 지형
    static boolean check(int[] arr) {
        // 활주로 : 높이가 동일한 구간 에서 건설 가능
        // 높이가 다른 구간 경우 활주로 끊어짐
        // 경사로 설치 해야만 활주로 건설
        // 낮은 지형의 높이가 동일 하게 경사로 길이 만큼 연속 되는 곳에 설치 가능 = 1 차이 경사로 설치 했으면 동일한 값 이어야 해
        // 활주로 1번 설치 할 때 x 만큼 설치 할 수 있어야 함
        // 경사로 밖을 넘으면 X

        // 각 지형의 수를 세서
        // 그 수가 x 보다 같거나 크면 경사로 설치 가능

        int idx=0;
        Arrays.fill(visited, 0); // visited 배열 초기화
        for(int i=0;i<n;i++) {
            if(arr[idx]!=arr[i]) { // 값이 달라 지면
                if(Math.abs(arr[idx]-arr[i])!=1) { // 경사로 설치 불가
                    return false; // 1 차이 넘게 난다면 경사로 설치 불가
                }
                if(arr[idx]<arr[i]) { // 앞이 더 작을 때 (올라 가는 경사로)
                    if(i-1<0) return false;
                    if(!count(i-1, arr, 1)) {
//                        print(arr);
                        return false;
                    }
                }else { // 앞이 더 클 때 (내려 가는 경사로)
                    if(!count(i, arr, 2)) {
                        return false;
                    }
                }
                idx = i;
            }
        }

//        print(arr);

        return true;
    }

    static boolean count(int idx, int arr[], int check) {
        if(check==1) { // 올라 가는 경사로
            if(idx-(x-1)<0) {
                return false; // 범위 벗어 나면 false
            }
            for(int i=idx;i>=idx-(x-1);i--) { // 왼쪽을 확인
                if(visited[i]==1) return false;
                if(arr[idx]!=arr[i]) {
                    return false; // 다르면 false
                }
                visited[i] = 1;
            }
        }else { // 내려 가는 경사로
            if(idx+(x-1)>=n) {
                return false; // 범위 벗어 나면 false
            }
            for(int i=idx;i<=idx+(x-1);i++)  { // 오른쪽을 확인
                if(visited[i]==1) return false;
                if(arr[idx]!=arr[i]) {
//                    print(arr);
                    return false; // 다르면 false
                }
                visited[i] = 1;
            }
        }
        return true;
    }

    static void print(int arr[]) {
        for(int i=0;i<n;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}