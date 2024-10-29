class Solution {
    
    static int sizeX, sizeY;
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // 가로, 세로 
        sizeX=0;
        sizeY=0;
        
        // 노란색과 갈색으로 색칠된 격자 개수 
        // 갈색 brown 
        // 노란색 yellow 
        
        // 가로, 세로 크기 
        // 가로가 세로보다 길다. 
        // 세로 기준 맞추기 (세로 무조건 3이상 이어야 하니까)
        int num = brown + yellow; 
        go(num, brown);
        
        answer[0]=sizeX;
        answer[1]=sizeY;
        return answer;
    } 
    
    static void go(int num, int brown) {
        // num : 가로, 세로 길이 합
        // 1. 세로 3부터 시작
        for(int i=3;i<=num;i++) {
            if(num%i==0) {
                // 가로 길이 
                int garo = num/i; 
                // brown 크기 
                int brownSize = (i*2 + garo*2)-4; // 4 : 꼭지점 겹치는 부분 빼주기
                if(brownSize==brown) {
                    sizeX = garo;
                    sizeY = i;
                    return;
                }
            }
        }
    }
    
}