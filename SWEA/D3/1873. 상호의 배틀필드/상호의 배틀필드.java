import java.io.*;
import java.util.*;

public class Solution {

    static int H, W, sx, sy, dir, x, y;
    static char map[][], str[];
    static int N;
    // 상 하 좌 우 0 1 2 3
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    // U : Up 방향 변경, 한 칸 위가 평지면 그 칸으로 이동
    // D : Down 방향 변경, 한 칸 아래가 평지면 그 칸으로 이동
    // L : 왼쪽 방향 변경, 한 칸 왼쪽이 평지면 그 칸으로 이동
    // R : 오른쪽 방향 변경, 한 칸 오른쪽이 평지면 그 칸으로 이동
    // S : 전차가 바라 보고 있는 방향 으로 포탄 발사
    // 벽에 부딪 히면 포탄 소멸
    // * : 벽돌 벽 에 부딪 히면 평지로 바뀜
    // # : 강철 벽 이면 아무 일도 일어 나지 않음
    // . : 평지

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            for(int i=0;i<H;i++) {
                String line = br.readLine();
                for(int j=0;j<W;j++) {
                    map[i][j] = line.charAt(j);
                    if(map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='>' || map[i][j]=='<') {
                        // 시작 하는 전자 방향 저장
                        // 상 하 좌 우 0 1 2 3
                        // ^ : 위쪽
                        // < : 왼쪽
                        // > : 오른쪽
                        // v : 아래쪽
                        if(map[i][j]=='^') {
                            dir=0; // 현재 방향 저장
                        }else if(map[i][j]=='v') {
                            dir=1;
                        }else if(map[i][j]=='>') { // 우
                            dir=3;
                        }else { // < : 좌
                            dir=2;
                        }
                        // 시작점 저장
                        sx=i;
                        sy=j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            str = new char[N];
            String line = br.readLine();
            for(int i=0;i<N;i++) {
                str[i] = line.charAt(i);
            }

            solve();
            System.out.print("#" + tc + " ");
            print();
        }
    }

    // . : 평지 (전차 들어갈 수 있음)
    // * : 벽돌
    // # : 강철
    // - : 물 (전차 못 들어감)

    static void print() {
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void solve() {
        // 현재 방향
        x=sx;
        y=sy;

        // str 을 순회 하면서 map 순회
        for(int i=0;i<str.length;i++) {
            // dir 방향 으로 변경
            if(str[i]=='U') {
                dir=0;
                map[x][y] = '^';
                move(str[i]);
            }else if(str[i]=='D') {
                dir=1;
                map[x][y] = 'v';
                move(str[i]);
            }else if(str[i]=='L') {
                dir=2;
                map[x][y] = '<';
                move(str[i]);
            }else if(str[i]=='R'){
                dir=3;
                map[x][y] = '>';
                move(str[i]);
            }else {
                move(str[i]);
            }
//            print(i, str[i]);
        }
    }

    static void move(char type) {
        if(type=='S') {
            bomb(dir, x, y);
        }else {
            // dir 방향 으로 한 칸 확인
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            // 범위 확인
            if(nx>=0 && nx<H && ny>=0 && ny<W) {
                if(map[nx][ny]=='.') {
                    // 그 칸으로 이동
                    map[x][y] = '.';
                    dirChange(dir, nx, ny);
                    // 좌표 이동
                    x = x + dx[dir];
                    y = y + dy[dir];
                }
            }
        }
    }

    static void bomb(int d, int x, int y) {
        // 벽돌 벽 이면
        // 범위 안에서
        while(true) {
            x = x + dx[d];
            y = y + dy[d];
            if(x<0 || x>=H || y<0 || y>=W) break;
            if(map[x][y]=='#') break;
            if(map[x][y]=='*') {
                map[x][y]='.';
                break;
            }
        }
    }

    static void dirChange(int d, int x, int y) {
        if(d==0) {
            map[x][y]='^';
        }else if(d==1) {
            map[x][y]='v';
        }else if(d==2) {
            map[x][y]='<';
        }else {
            map[x][y]='>';
        }
    }
}


