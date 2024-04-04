import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        // 그룹 단어 : 각 문자가 연속 해서 나타 나는 경우

        int cnt=0;
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            if(check(str)) cnt++;
        }

        System.out.println(cnt);


    }

    public static boolean check(String str) {
        // 그룹 단어면 true
        int prev = 0;
        int [] alpha = new int[26];

        for(int i=0;i<str.length();i++) {
            int now = str.charAt(i);

            if(prev != now) {
                if(alpha[now-97]==0) {
                    alpha[now-97]++;
                    prev = now;
                } else {
                    return false;
                }
            }

        }

        return true;
    }



}