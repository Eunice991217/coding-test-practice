import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[] citations) {
        int answer = 0;
        
        // 정렬 
        Arrays.sort(citations);
        
        // 순서대로 확인
        for(int i=0;i<citations.length;i++) {
            // 남은 논문의 개수 
            int h = citations.length - i; 
            
            // 현재 비교 논문의 인용된 횟수가 남은 논문의 개수보다 크거나 같으면
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }

}