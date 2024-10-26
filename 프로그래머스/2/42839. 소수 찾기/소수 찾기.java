import java.util.*;
import java.io.*;

class Solution {
    
    static int size, answer;
    static char[] arr;
    static boolean[] v;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        answer = 0;
        size = numbers.length();
        arr = new char[size];
        v = new boolean[size];
        
        for(int i=0;i<size;i++) {
            arr[i] = numbers.charAt(i); // arr : 0, 1, 1 
        }
        
        go(0, "");
        
        answer = set.size();
        return answer;
    }
    
    static void go(int idx, String str) {
        int n;
        if(str!="") {
            n = Integer.parseInt(str);
            if(check(n)) {
                set.add(n); // 소수면 set 에 넣어줌 
            }
        }
        if(idx==size) return;
        
        for(int i=0;i<size;i++) {
            if(v[i]) continue;
            v[i] = true;
            go(idx+1, str+arr[i]);
            v[i] = false;
        }
    }
    
    static boolean check(int num) {
         if(num<=1)
            return false;
        
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    
}