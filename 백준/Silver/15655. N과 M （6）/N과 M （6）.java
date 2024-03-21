import java.io.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Integer> list;
    static List<Integer> arr;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            int x = Integer.parseInt(st.nextToken());
            arr.add(x);
        }

        Collections.sort(arr);

        go(0, 0);

        bw.flush();
        bw.close();
        br.close();

    }

    public static void go(int x, int start) throws IOException {
        if(list.size()==m) {
            for(int i=0;i<m;i++) {
                bw.write(list.get(i) + " ");
            }
            bw.newLine();
            return;
        }

        for(int i=start;i<n;i++) {
            list.add(arr.get(i));
            go(arr.get(i), i+1);
            list.remove(list.size()-1);
        }

    }


}

