import java.io.*;
import java.util.*;

class Solution {

    static int n, map[][], ans=Integer.MAX_VALUE, v[], res[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            map = new int[n+1][n+1];
            v = new int[n+1];
            res = new int[n+1];
            for(int i=1;i<=n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1;i<=n;i++) {
                res[i]=i;
            }

            ans=Integer.MAX_VALUE; // 맛의 차이가 최소
            solve(1);
            System.out.println("#" + tc + " " + ans);
        }


    }

    static void solve(int depth){
        // 식재료 절반은 A
        // 나머지 절반은 B
        if(depth==n+1) {
            String strA="", strB="";
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            for(int i=1;i<=n;i++) {
                if(v[i]==1) { // A
                    listA.add(res[i]);
                }else { // B
                    listB.add(res[i]);
                }
                if(listA.size()==listB.size() && listA.size()+listB.size()==n) { // 절반
                    ans = Math.min(ans, cal(listA, listB));
                }
            }
            return;
        }

        v[depth]=1;
        solve(depth+1);
        v[depth]=0;
        solve(depth+1);
    }

    static int cal(List<Integer> A, List<Integer> B) {

        // A 음식의 맛
        int cntA=0;
        for(int i=0;i<A.size();i++) {
            for(int j=i+1;j<A.size();j++) {
                int x = A.get(i);
                int y = A.get(j);
                cntA+=(map[x][y] + map[y][x]);
            }
        }

        // B 음식의 맛
        int cntB=0;
        for(int i=0;i<B.size();i++) {
            for (int j = i + 1; j < B.size(); j++) {
                int x = B.get(i);
                int y = B.get(j);
                cntB += (map[x][y] + map[y][x]);
            }
        }

        return Math.abs(cntA-cntB);

    }


}