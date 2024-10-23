import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
    
        // 가장 높은 점수를 받은 사람 return 
        // 여럿이면 return 하는 값 오름차순 정렬 
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int s1N=0, s2N=0, s3N=0;
        
        for(int i=0;i<answers.length;i++) {
            if(s1[i%5]==answers[i]) s1N++;
            if(s2[i%8]==answers[i]) s2N++;
            if(s3[i%10]==answers[i]) s3N++;
        }
        
        // 최대 점수 구하기 
        int max = Math.max(s1N, Math.max(s2N, s3N));
        
        List<Integer> list = new ArrayList<>();
        if(max==s1N) list.add(1);
        if(max==s2N) list.add(2);
        if(max==s3N) list.add(3);
        
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}