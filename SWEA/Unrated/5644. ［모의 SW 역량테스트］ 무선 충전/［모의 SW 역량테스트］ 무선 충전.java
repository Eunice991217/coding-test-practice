import java.io.*;
import java.util.*;

class Solution {

    static int M, A, ans=0;

    // 상 우 하 좌 1 2 3 4
    static int dy[] = {0, -1, 0, 1, 0};
    static int dx[] = {0, 0, 1, 0, -1};
    static int moveA[], moveB[];
    static List<Node> listBC;

    public static void main(String[] args) throws Exception, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            listBC = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 총 이동 시간
            A = Integer.parseInt(st.nextToken()); // BC 의 개수

            // 위치 : x, y
            st = new StringTokenizer(br.readLine());
            moveA = new int[M+1];
            moveB = new int[M+1];

            for(int i=1;i<=M;i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=M;i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }
            // 충전 범위 : c
            // 성능 : p
            for(int i=0;i<A;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken()); // 거리
                int p = Integer.parseInt(st.nextToken()); // 충전량
                listBC.add(new Node(x, y, c, p)); // BC 정보 저장 list
            }

            ans = solve();
            System.out.println("#" + tc + " " + ans);

        }

    }

    static int solve() {
        int sum=0;

        // A -> (0, 0)
        // B -> (9, 9)
        // 처음 위치에 대한 경우 (0초)
        int ax=1, ay=1;
        int bx=10, by=10;
        sum+=cal(ax, ay, bx, by);

        // 1초 부터 cal
        for(int i=1;i<=M;i++) {
            ax = ax + dx[moveA[i]]; // A의 x 좌표
            ay = ay + dy[moveA[i]]; // A의 y 좌표
            bx = bx + dx[moveB[i]]; // B의 x 좌표
            by = by + dy[moveB[i]]; // B의 y 좌표
            // cal 함수 에서 return 한 걸 다 더해 주면 총 충전한 양
            sum+=cal(ax, ay, bx, by);
        }

        return sum;
    }

    // 매 초 마다 충전한 A, B의 합 return
    static int cal(int ax, int ay, int bx, int by) {
        int total=0;

        for(int a=0;a<listBC.size();a++) {
            for(int b=0;b<listBC.size();b++) {
                int sum=0;
                int aSum = disCheck(a, ax, ay);
                int bSum = disCheck(b, bx, by);

                // 두 충전소 다르면 충전량 나누지 X
                if(a != b) { // disCheck 함수 에서 충전 불가능 하면 0 을 return 하므로
                    sum += aSum + bSum;
                }else {
                    // 충전소 같으면 둘 중 큰 값
                    sum = Math.max(aSum, bSum);
                }
                // sum 이 가장 큰 값 찾기
                total = Math.max(total, sum);
            }
        }

        return total;
    }

    static int disCheck(int idx, int x, int y) {
        // 충전기 에서 (x, y) 까지 거리가 충전 할 수 있는 거리 라면
        // 충전 량을 보내 주고,
        // 충전을 못 한다면 0 return
        return Math.abs(listBC.get(idx).x-x) + Math.abs(listBC.get(idx).y-y) <= listBC.get(idx).c ? listBC.get(idx).p : 0;
    }


}

class Node{
    int x;
    int y;
    int c; // 거리
    int p; // 충전량
    Node(int x, int y, int c, int p){
        this.x = x;
        this.y = y;
        this.c = c;
        this.p = p;
    }
}
