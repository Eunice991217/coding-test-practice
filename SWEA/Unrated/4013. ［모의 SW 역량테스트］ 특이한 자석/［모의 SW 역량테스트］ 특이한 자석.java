import java.io.*;
import java.util.*;

class Solution {

    static int k, map[][], ans, n, dir, arr[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            map = new int[5][9];

            // 4개의 자석
            for(int i=1;i<=4;i++) {
                st = new StringTokenizer(br.readLine());
                // 각 자석은 8개의 '날' 을 가지고 있음
                for(int j=1;j<=8;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // k 번 회전
            for(int i=0;i<k;i++) {
                arr = new int[5];
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken()); // 몇 번
                dir = Integer.parseInt(st.nextToken()); // 방향
                solve(n , dir); // 회전 할 때마다
                // map 은 공통 으로 활용
            }

//            for(int i=1;i<=4;i++) {
//                for(int j=1;j<=8;j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            ans = 0;
            // 1 번 -> N극 0점 S극 1점 (2 의 0승)
            // 2 번 -> N극 0점 S극 2점 (2 의 1승)
            // 3 번 -> N극 0점 S극 4점 (2 의 2승)
            // 4 번 -> N극 0점 S극 8점 (2 의 3승)
            for(int i=1;i<=4;i++) {
                if(map[i][1]==1) { // S극 일 때만 점수
                    ans+=Math.pow(2, i-1);
                }
            }

            // 임의의 자석 1 칸씩 k 번 회전
            // 하나의 자석이 1칸 회전 될 때,
            System.out.println("#" + tc + " " + ans);

        }

    }

    // 처음 : 화살표 위치
    // S극 : 1
    // N극 : 0
    // 시계 : 1, 반시계 : -1
    static void solve(int x, int d){
        arr[x] = d; // 방향 배열

        // idx : 3이랑 7 이랑 물려 있음
        // 1. idx 에 물려 있는 값 먼저 확인
        // x 랑 x+1
        // 2. 값이 다르면 서로 다른 극
        // 3. 서로 반대 방향 으로 회전

        // 오른쪽
        for(int i=x+1;i<=4;i++) {
            if(map[i][7]==map[i-1][3]) {
                break;
            }
            else arr[i] = -arr[i-1];
        }

        // 왼쪽
        for(int i=x-1;i>=1;i--) {
            if(map[i+1][7]==map[i][3]) {
                break;
            }
            else arr[i] = -arr[i+1];
        }

//        System.out.println("arr");
//        for(int i=1;i<=4;i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

        rotation();

    }

    // map 회전
    static void rotation() {
        // x : 행 번호
        for(int i=1;i<=4;i++) {
            if(arr[i]==0) continue;
            else if(arr[i]==1) {
                // 시계
                // 1. 마지막 값을 tmp 에 저장
                int tmp = map[i][8];
                // 2. 한 칸 식 오른쪽
                for(int y=8;y>=2;y--) {
                    map[i][y] = map[i][y-1];
                }
                // 3. tmp 에 저장한 값 처음에 다시 저장
                map[i][1] = tmp;
            }else if(arr[i]==-1) {
                // 반시계
                // 1. 처음 값을 tmp 에 저장
                int tmp = map[i][1];
                // 2. 한 칸 씩 왼쪽
                for(int y=1;y<=7;y++) {
                    map[i][y] = map[i][y+1];
                }
                // 3. tmp 에 저장한 값  마지막에 다시 저장
                map[i][8] = tmp;
            }
        }
    }
}