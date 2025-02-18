import java.util.*;
import java.io.*;

public class Solution {
    
    static int T, n, ans;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static char[][] arr;
    static List<Pair> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {

            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            list = new ArrayList<>();

            for(int i=0;i<n;i++) {
                String line = br.readLine();
                for(int j=0;j<n;j++) {
                    arr[i][j] = line.charAt(j);
                }
            }

            // 주변에 지뢰가 없는 칸의 좌표를 다 구해
            // 먼저 터트리고
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(arr[i][j]=='.' && count(i, j)==0) {
                        list.add(new Pair(i, j));
                    }
                }
            }

            ans = 0;
            for(int i=0;i<list.size();i++) {
                // 그 좌표를 기준 으로 폭발 시켜
                int x = list.get(i).x;
                int y = list.get(i).y;
                if(arr[x][y]=='.') {
                    solve(x, y);
                    ans++;
                }
            }

            // 나머지 칸 터트려
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(arr[i][j]=='.') {
                        ans++;
                    }
                }
            }

            // 최소 몇 번의 클릭을 해야 지뢰가 없는 모든 칸에 숫자가 표시될 것인지
            System.out.println("#" + tc + " " + ans);

        }

    }

    // 지뢰 몇 개 인지
    static int count(int x, int y) {
        int num=0;

        for(int i=0;i<8;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(rangeCheck(nx, ny)) {
                if(arr[nx][ny]=='*') {
                    num++;
                }
            }
        }

        return num;
    }

    // 폭발
    static void solve(int x, int y) {
        arr[x][y]='c';
        if(count(x, y)==0) {
            for(int i=0;i<8;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(rangeCheck(nx, ny) && arr[nx][ny]=='.') {
                    arr[nx][ny] = 'c';
                    solve(nx, ny);
                }
            }
        }

    }

    // rangeCheck
    static boolean rangeCheck(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    static class Pair{
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}