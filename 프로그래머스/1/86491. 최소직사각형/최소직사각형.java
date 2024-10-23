import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 1. 가로를 두 변 중에 긴 부분 
        // 2. 세로를 두 변 중에 긴 부분 
        // 3. 그래서 각각의 max 를 곱하면 가장 최소 
        
        int maxGaro = Integer.MIN_VALUE;
        int maxSero = Integer.MIN_VALUE;
        
        for(int i=0;i<sizes.length;i++) {
            // 가로, 세로 중에 큰 걸 가로에 두고, 작은 걸 세로에 두고 
            if(sizes[i][0]<sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            maxGaro = Math.max(sizes[i][0], maxGaro);
            maxSero = Math.max(sizes[i][1], maxSero);
        }
        
        answer = maxGaro * maxSero;
        
        return answer;
    }
}