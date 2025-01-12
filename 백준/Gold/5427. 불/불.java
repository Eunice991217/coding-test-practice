import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m;

    static char[][] map;
    static Queue<Node> fq, pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // 4
            m = Integer.parseInt(st.nextToken()); // 3

            map = new char[m][n];
            fq = new ArrayDeque<>(); // 불
            pq = new ArrayDeque<>(); // 상근

            for(int i=0;i<m;i++) {
                String line = br.readLine();
                for(int j=0;j<n;j++) {
                    map[i][j] = line.charAt(j);
                    if(map[i][j]=='*') {
                        fq.add(new Node(i, j, 0));
                    } else if(map[i][j]=='@') {
                        pq.add(new Node(i, j, 0));
                    }
                }
            }

            int ans = bfs();
            if(ans==-1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans);
            }

        }

    }

    // 탈출 하는 데 가장 빠른 시간 return

    // 벽에는 불이 붙지 않음
    // 이동 시간 1초
    // 불이 옮겨진 칸 or 불이 붙으려는 칸으로 이동 불가
    // 상근이 벽 통과 불가능
    // 상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸 이동 가능

    // . : 빈 공간
    // # : 벽
    // @ : 상근이 시작 위치
    // * : 불
    static int bfs() {
        int ret = -1;

        while(!pq.isEmpty()){

            int fSize = fq.size();
//            System.out.println("fSize : " + fSize);
            for(int s=0;s<fSize;s++) {
                Node node = fq.poll();
                for(int i=0;i<4;i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if(nx>=0 && nx<m && ny>=0 && ny<n) {
                        if(map[nx][ny]=='.' || map[nx][ny]=='@') {
                            map[nx][ny] = '*';
                            fq.add(new Node(nx, ny, 0));
                        }
                    }
                }
            }

            int pSize = pq.size();
//            System.out.println("pSize : " + pSize);
            for(int s=0;s<pSize;s++) {
                Node node = pq.poll();
                for(int i=0;i<4;i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if(nx<0 || nx>=m || ny<0 || ny>=n) {
                        ret = node.d + 1;
                        return ret;
                    }

                    if(map[nx][ny]=='.') {
                        map[nx][ny] = '@';
//                        System.out.println("nx : " + nx + " ny : " + ny);
                        pq.add(new Node(nx, ny, node.d + 1));
                    }
                }
            }

        }

        return ret;
    }

    static class Node{
        int x, y, d;
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }


}