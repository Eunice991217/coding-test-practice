class Solution {
    
    static int answer, size, y;
    static int[][] arr;
    static boolean[] v;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        size = dungeons.length;
        y = dungeons[0].length;
        v = new boolean[size];
        
        arr = new int[size][y];
        for(int i=0;i<size;i++) {
            for(int j=0;j<y;j++) {
                arr[i][j] = dungeons[i][j];
            }
        }
        
        // 최소 필요 피로도 : 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
        // 소모 피로도 : 탐헌한 후 소모되는 피로도
        
        // 최대한 많이 탐험하려면? 
        // 유저가 탐험할 수 있는 최대 던전 수 
        // k : 현재 피로도 
        go(0, k);
        
        return answer;
    }
    
    static void go(int idx, int now) {
        answer = Math.max(answer, idx); 
        // if(idx==size) { 
        //     return; 
        // } 
        // 처음부터 확인하고 
        // 최소 피로도 - 소모 피로도 확인 
        // 현재 피로도를 계속 update 시켜주면서 
        // depth 파고 들어서 check 
        // 그래서 depth가 최대로 나올 수 있도록 
        for(int i=0;i<size;i++) {
            if(v[i]==false & now>=arr[i][0]) {
                v[i] = true;
                // System.out.println("now : " + now + " somo : " + arr[i][1]); 
                go(idx+1, now-arr[i][1]); 
                v[i] = false;
            } 
        }
    }
}