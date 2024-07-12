import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // 문자열일때는 length(), 배열이면 length 
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        // name size랑 yearning size랑 같음 
        for(int i=0;i<name.length;i++) {
            map.put(name[i], yearning[i]);
        }
        
        // 저장해둔 list에 맞게 계산
        for(int i=0;i<photo.length;i++) {
            int sum=0;
            for(int j=0;j<photo[i].length;j++) {
                // 그리움 점수를 모두 합산한 값 = 해당 사진의 추억 점수
                if(map.containsKey(photo[i][j])) {
                    // 이름에 맞게 그리움 점수를 더함 
                    sum+=map.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}


