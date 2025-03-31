import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // m 이상 n 이하의 소수가 하나 이상 있는
        StringBuilder sb = new StringBuilder();
        for(int i=m;i<=n;i++) {
            if(check(i)) sb.append(i).append("\n");
        }
        System.out.print(sb);


    }

    public static boolean check(int num) {

        if(num<=1) return false;
        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num%i==0) {
                return false;
            }
        }

        return true;
    }

}