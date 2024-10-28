import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] v;
    static int sizeX, sizeY;
    
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        sizeX = maps.length;
        sizeY = maps[0].length;
        v = new boolean[sizeX][sizeY];
        
        // 상대 팀 진영을 먼저 파괴하면 이기는 게임 
        // for(int i=0;i<sizeX;i++) {
        //     for(int j=0;j<sizeY;j++) {
        //         if(v[i][j]==false && maps[i][j]==1) {
        //             answer = Math.min(answer, bfs(i, j, maps));
        //         }
        //     }
        // }
        
        answer = bfs(0, 0, maps);
        
        if(answer==-1) return -1;
        
        return answer;
    }
    
    static int bfs(int x, int y, int[][] arr) {
        int ans=-1;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y, 1));
        v[x][y] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int nx = node.x;
            int ny = node.y;
            int nv = node.value;
            if(nx==sizeX-1 && ny==sizeY-1) {
                ans = Math.max(ans, nv);
                System.out.println("ans : " + ans);
                return ans;
            }
            // 1일때만 갈 수 있음 
            for(int i=0;i<4;i++) {
                int nnx = nx + dx[i];
                int nny = ny + dy[i];
                if(nnx>=0 && nnx<sizeX && nny>=0 && nny<sizeY && v[nnx][nny]==false && arr[nnx][nny]==1) {
                    v[nnx][nny]=true;
                    q.add(new Node(nnx, nny, nv+1));
                }
            }
        }
        
        return ans;
    }
    
    static class Node {
        int x, y, value;
        
        Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value; 
        }
    }
}