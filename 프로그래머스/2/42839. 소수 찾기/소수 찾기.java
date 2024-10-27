import java.util.*;
import java.io.*;

class Solution {
    
    static int answer, size;
    static char[] arr;
    static boolean[] v;
    static HashSet<Integer> set;
    
    public int solution(String numbers) {
        answer = 0;
        size = numbers.length();
        arr = new char[size];
        v = new boolean[size];
        set = new HashSet<>();
        
        for(int i=0;i<size;i++) {
            arr[i] = numbers.charAt(i);
        }
        
        go(0, "");
        
        answer = set.size();
        return answer;
    }
    
    // 만들 수 있는 수 구하기 
    static void go(int idx, String str) {
        if(str!="") {
            int n = Integer.parseInt(str);
            if(check(n)) {
                System.out.println(n);
                set.add(n);
            }
        }
        if(idx==size) {    
            return;
        }
        
        for(int i=0;i<size;i++) {
            if(v[i]) continue;
            v[i] = true;
            go(idx+1, str+arr[i]);
            v[i] = false;
        }
    }
    
    // 소수 판별 
    static boolean check(int num) {
        if(num<=1) return false;
        
        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num%i==0) return false;
        }
        return true;
        
    }
    
    
}