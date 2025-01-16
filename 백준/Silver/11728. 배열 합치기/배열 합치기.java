import java.util.*;
import java.io.*;

public class Main {

    static long[] a, b, c;
    static int aSize, bSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        aSize = Integer.parseInt(st.nextToken());
        bSize = Integer.parseInt(st.nextToken());

        a = new long[aSize];
        b = new long[bSize];
        c = new long[aSize+bSize];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<aSize;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<bSize;i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<aSize;i++) {
            c[i] = a[i];
        }

        for(int i=aSize, j=0;i<aSize+bSize;i++, j++) {
            c[i] = b[j];
        }

        Arrays.sort(c);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<aSize+bSize;i++) {
            sb.append(c[i] + " ");
        }

        System.out.println(sb);

    }




}