class Solution {
    
    static int ret, size;
    static boolean v[];
    static String arr[];
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0; 
        ret = Integer.MAX_VALUE;
        size = words.length;
        v = new boolean[size];
        arr = new String[size];
        
        // 변환할 수 없는 경우 
        int flag=0;
        for(int i=0;i<size;i++) {
            arr[i] = words[i];
            if(target.equals(words[i])) flag=1;
        }
        
        if(flag==0) {
            return 0; // answer = 0 
        } 
        
        // 한 글자씩 달라야 함 (한 번에 한 개만 변경 가능)
        // begin != target 임 
        go(0, begin, target);
        answer = ret;
        
        return answer;
    }
    
    static void go(int idx, String str, String target) { 
        System.out.println(str);
        System.out.println(idx);
        System.out.println(ret);
        if(idx > ret) return;
        
        if(str.equals(target)) { // target 단어랑 같아지면 
            ret = Math.min(ret, idx); // idx = depth 
            return; 
        } 
        
        if(idx>size) { 
            return; 
        } 
        
        for(int i=0;i<size;i++) {
            if(check(str, arr[i])) {
                // 한글자씩 차이나면
                go(idx+1, arr[i], target);
            }
        }
        
    } 
    
    // 단어 차이가 한 개만 나는지 체크 
    static boolean check(String str1, String str2) {
        int cnt=0;
        for(int i=0;i<str1.length();i++) {
            if(str2.charAt(i)!=str1.charAt(i)){
                cnt++;
            } 
            if(cnt>=2) return false;
        }
        if(cnt==1) return true; 
        return false; 
    }
}