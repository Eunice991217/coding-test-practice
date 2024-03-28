
import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

class Main {

    static int n, ans=Integer.MAX_VALUE;
    static int map[][];
    static List<Integer> sList;
    static List<Integer> lList;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        sList = new ArrayList<>();
        lList = new ArrayList<>();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0, 0);

        System.out.println(ans);

    }

    public static void go(int idx, int sSum, int lSum) {
        if(idx>=n) {
            if(sList.size()>=1 && lList.size()>=1 && sList.size()+lList.size()==n) {
                ans = Math.min(ans, Math.abs(sSum-lSum));
            }
            return;
        }

        int ts=0;
        for(int i=0;i<sList.size();i++) {
            ts+=map[sList.get(i)][idx];
            ts+=map[idx][sList.get(i)];
        }
        sList.add(idx);
        go(idx+1, sSum+ts, lSum);
        sList.remove(sList.size()-1);
//        go(idx+1, sSum+ts, lSum);

        int ls=0;
        for(int i=0;i<lList.size();i++) {
            ls+=map[lList.get(i)][idx];
            ls+=map[idx][lList.get(i)];
        }
        lList.add(idx);
        go(idx+1, sSum, lSum+ls);
        lList.remove(lList.size()-1);
//        go(idx+1, sSum, lSum+ls);
    }



}