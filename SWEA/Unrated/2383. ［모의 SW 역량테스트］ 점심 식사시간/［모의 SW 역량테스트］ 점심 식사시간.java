import java.io.*;
import java.util.*;

class Solution {

    static int n, ans;
    static int map[][], v[];
    static List<Pair> listP, listS;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            listP = new ArrayList<>();
            listS = new ArrayList<>();

            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            // 방 안의 사람 들 P
            // 계단 입구 S

            int num=0, cnt=0;
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1) {
                        // 사람
                        listP.add(new Pair(num, i, j));
                        num++;
                    }else if(map[i][j]>1) {
                        listS.add(new Pair(map[i][j], i, j)); // 계단 위치 저장
                    }
                }
            }

            v = new int[listP.size()];
            // 1 : 사람
            // 2-10 : 계단 입구 (계단 길이) : K

            // 최대한 빠른 시간 내
            ans = Integer.MAX_VALUE;
            subs(0);
            System.out.println("#" + tc + " " + ans);
        }

        br.close();

    }

    // 1. 계단 개수 만큼 사람 나누기
    static void subs(int depth) {
        // 계단 개수는 반드시 2개
        if(depth==listP.size()) {
            // 계단 까지의 거리, 어떤 계단 인지, 몇 번째 사람 인지, 계단 길이
            List<Node> list1 = new ArrayList<>();
            List<Node> list2 = new ArrayList<>();
            int dis=0;
            for(int i=0;i<listP.size();i++) {
                if(v[i]==1) {
                    dis = cal(listP.get(i).x, listS.get(0).x, listP.get(i).y, listS.get(0).y);
                    list1.add(new Node(dis, 0, listP.get(i).num, listS.get(0).num, dis+1)); // 1번 계단
                } else {
                    dis = cal(listP.get(i).x, listS.get(1).x, listP.get(i).y, listS.get(1).y);
                    list2.add(new Node(dis, 1, listP.get(i).num, listS.get(1).num, dis+1)); // 2번 계단
                }
                if(list1.size()+list2.size()==listP.size()) {
                    // 2 팀으로 나눈 후
                    // 3. 계딘 별로 사람들 내려간 시간 구해서
                    int cnt1 = solve(list1); // 1번 계단 에서 사람이 다 내려간 시간
                    int cnt2 = solve(list2); // 2번 계단 에서 사람이 다 내려간 시간
                    // 4. 더 긴 시간이 최종 도착 시간
                    int time = cnt1>cnt2 ? cnt1 : cnt2;
                    // 5. 이 도착 시간이 가장 짧은 경우
                    ans = Math.min(ans, time);
                }
            }
            return;
        }

        v[depth]=1;
        subs(depth+1);
        v[depth]=0;
        subs(depth+1);

    }

    // 2. 계단 별로 전체 사람이 내려 가는 시간 구하기
    static int solve(List<Node> list) {
        // 계단 입구 도착 하면 1분 후 아래 칸으로 내려 갈 수 있음
        // 계단 위에는 동시에 최대 3명 까지만
        // 이미 계단을 3 명이 내려 가고 있는 경우
        // 그 중 1명이 완전히 내려 갈 때 까지 계단 입구 에서 대기
        // 계단 마다 길이 K가 주어짐
        // 계단에 올라 간 후 완전히 내려 가는 데 k분
        if(list.size()==0) return 0;

        int time[] = new int[list.size()+3];
        // 계단 길이
        int k = list.get(0).stairD;
        // 1. 정렬 부터 (계단 길이를 제외한 계단 까지 도착 시간을 저장 해두고)
        for(int i=0;i<list.size();i++) {
             time[i] = list.get(i).time;
        }
        Arrays.sort(time);
        // cal (거리) + k (계단 길이) + 1분 후 출발
        // 각 사람 별로 내려 가는 시간
        // 가장 긴 시간이 모든 사람이 도착한 시간
        for(int i=3;i<time.length;i++) {
            // 1. 내가 -3 앞선 사람 보다 크면 무조건 내려감
            if(time[i]+k>time[i-3]+k) {
                time[i] += k;
            }
            // 2. 단, 내가 작으면 -3 앞선 사람의 도착 시간 에서 + k 해주면 됨
            else {
                time[i] = time[i-3] + k;
            }
        }

        // 마지막 사람의 도착 시간만 확인
        return time[time.length-1];
    }

    // row, col (세로, 가로)
    // 계단 입구 까지 이동 시간
    static int cal(int pr, int sr, int pc, int sc) {
        return Math.abs(pr-sr) + Math.abs(pc-sc);
    }

}

class Pair{
    int num;
    int x;
    int y;
    Pair(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Node {
    int dis;
    int stairN;
    int personN;
    int stairD; // 계단 길이
    int time;
    int end; // 완료 시간
    Node(int dis, int stairN, int personN, int stairD, int time) {
        this.dis = dis;
        this.stairN = stairN;
        this.personN = personN;
        this.stairD = stairD;
        this.time = time;
    }
}