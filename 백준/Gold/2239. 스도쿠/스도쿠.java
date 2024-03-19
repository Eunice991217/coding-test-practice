
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int n, map[][];
    static boolean col[][]; // 열
    static boolean row[][];
    static boolean square[][];
    static boolean flag= false;

    static List<Pair> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = 9;

        row = new boolean[n][10];
        col = new boolean[n][10];
        square = new boolean[n][10];

        map = new int[n][n];

        list = new ArrayList<Pair>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';

                if (map[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
                else {
                    row[i][map[i][j]] = true;
                    col[j][map[i][j]] = true;
                    square[(i/3)*3+(j/3)][map[i][j]] = true;
                }

            }
        }

        solve(0);
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void solve(int idx) { // 행
        if(idx == list.size()) {
            flag = true;
            return;
        }

        int x = list.get(idx).x;
        int y = list.get(idx).y;

        for(int i=1;i<=9;i++) {
            if(row[x][i] || col[y][i] || square[(x/3)*3+(y/3)][i]) continue;
            row[x][i] = true;
            col[y][i] = true;
            square[(x/3)*3+(y/3)][i] = true;
            map[x][y] = i;

            solve(idx+1);
            if(flag) return;

            row[x][i] = false;
            col[y][i] = false;
            square[(x/3)*3+(y/3)][i] = false;
            map[x][y] = 0;
        }
    }

}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
