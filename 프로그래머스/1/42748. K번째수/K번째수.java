import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // i 번째 숫자부터 j 번째 숫자까지 자르고 
        for(int i=0;i<commands.length;i++) {
            answer[i] = solve(array, commands[i]);
        }
        // k 번째 수 
        
        return answer;
    }
    
    static int solve(int[] array, int[] command) {
        int i = command[0];
        int j = command[1];
        int k = command[2];
        
        int size = j-i+1;
        int[] newArr = new int[size];
        // 2 1
        // 5 4
        
        int cnt=0;
        for(int x=i-1;x<j;x++) {
            newArr[cnt++] = array[x];
        }
        
        Arrays.sort(newArr);
        
        return newArr[k-1];
    }
}