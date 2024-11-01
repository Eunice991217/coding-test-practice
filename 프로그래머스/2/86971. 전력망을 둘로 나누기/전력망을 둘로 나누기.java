import java.util.*;
import java.io.*;

class Solution {
    
    static int[][] arr;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        arr = new int[n+1][n+1];
        
        for(int i=0;i<wires.length;i++){
            arr[wires[i][0]][wires[i][1]]=1;
            arr[wires[i][1]][wires[i][0]]=1;
        }
        
        // 선 끊기
        int a, b;
        for(int i=0; i<wires.length; i++){
            a = wires[i][0];
            b = wires[i][1];
            
            //선을 하나 끊고
            arr[a][b]=0;
            arr[b][a]=0;
            
            //bfs
            answer= Math.min(answer, bfs(n, a));
            
            //선 다시 복구
            arr[a][b]=1;
            arr[b][a]=1;
        }
        
        return answer;
    }
    
    public int bfs(int n, int start){
        int[] visit = new int[n+1];
        int cnt=1;
        
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int point= queue.poll();
            visit[point]= 1;
            
            for(int i=1; i<=n; i++){
                if(visit[i]==0 && arr[point][i]==1) {
                    queue.add(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt); //cnt-(n-cnt);
    }
}