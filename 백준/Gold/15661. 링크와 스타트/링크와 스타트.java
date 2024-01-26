import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int arr[][];
    static boolean visited[];
    static int tmp[];
    static String out[] = new String[1000004];
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n];

        int cnt=1;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<n;i++) {
            combi(0, 0, i);
        }

        System.out.print(ret);

    }

    public static void combi(int start, int depth, int r) {
        if(depth==r) {
            int sTeam=0, lTeam=0;
            for(int i=0;i<n-1;i++) {
                for(int j=i+1;j<n;j++) {
                    if(visited[i] == true && visited[j]==true) {
                        sTeam += arr[i][j] + arr[j][i];
                    }
                    else if(visited[i]==false && visited[j]==false) {
                        lTeam += arr[i][j] + arr[j][i];
                    }
                }

            }
            ret = Math.min(ret, Math.abs((sTeam-lTeam)));
            return;
        }

        for(int i=start;i<n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(i+1, depth+1, r);
                visited[i] = false;
            }
        }

    }



}