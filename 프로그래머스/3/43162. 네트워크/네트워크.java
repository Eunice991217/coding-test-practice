import java.util.*;
import java.io.*;

// dfs 
class Solution {
    
    static boolean[] v;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n];
        
        for(int i=0;i<n;i++) {
            if(v[i]==false) {
                answer++;
                dfs(i, n, computers);
            }
        } 
        
        return answer;
    }
    
    static void dfs(int node, int n, int[][] computers) {
        v[node] = true;
        
        for(int i=0;i<n;i++) {
            if(v[i]==false && computers[node][i]==1) {
                dfs(i, n, computers);
            }
        }
    }
}