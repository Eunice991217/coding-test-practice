import java.util.*;
import java.io.*;

class Solution {
    
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        
        go(0, "");
        
        for(int i=0;i<list.size();i++) {
            if(list.get(i).equals(word)) answer=i;
        }
        
        return answer;
    }
    
    static void go(int idx, String str) {
        list.add(str);
        
        if(idx==words.length) return;
        
        for(int i=0;i<words.length;i++) {
            go(idx+1, str+words[i]);
        }
    }
}