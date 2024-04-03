import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.*;

class Solution {

    static int n, b, h[], ans=Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        // 탑을 쌓아서 선반 위의 물건 사용
        // 점원 1명 이상
        // 탑의 높이 => 점원 1명 : 키 / 2명 이상 : 탑을 만든 모든 점원의 키의 합
        // 탑의 높이가 B 이상인 경우 선반 위의 물건 사용 가능
        // 탑의 높이가 높을 수록 위험 -> 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            h = new int[n];
            ans = Integer.MAX_VALUE;

            // 점원의 키 h
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }

            subs(0, "");

            System.out.println("#" +  tc  + " " + (ans-b));

        }
    }

    // 모든 부분 집합을 만들고 b 보다 큰 경우
    // 그 경우 중 가장 작은 값 찾아 b 보다 큰 값 중에서
    // 그리고 그 값에서 b 만큼 빼
    static void subs(int cnt, String str) {
        if(cnt>=n) {
            int s = searchMax(str);
//            System.out.println(s);
            if(s!=0) {
                ans = Math.min(ans, s);
            }
            return;
        }

        subs(cnt+1, str+""+h[cnt]+ " ");
        subs(cnt+1, str);
    }

    // str 에 들어 있는 값 중에서
    // b 보다 큰 값이면 그 값을 뱉고 아니면 0 을 뱉어
    static int searchMax(String str) {
        int ret=0;
        String nStr="";

        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)==' ') {
                ret+=Integer.parseInt(nStr);
                nStr="";
            }else {
                nStr+=str.charAt(i);
            }
        }

        if(ret>=b) {
            return ret;
        }

        return 0;
    }

}