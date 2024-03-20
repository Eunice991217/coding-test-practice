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

    static int n;
    static char star[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        star = new char[8000][8000];

        for(int i=0;i<8000;i++) {
            for(int j=0;j<8000;j++) {
                star[i][j]=' ';
            }
        }

        go(1, n, n);

        int n2 = n*2;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n2;j++) {
                sb.append(star[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());

    }

    public static void go(int x, int y, int n) {
        if(n==3) {
            // 가장 작은 삼각형 만들기
            star[x][y] = '*';
            star[x+1][y-1] = '*';
            star[x+1][y+1] = '*';
            for(int i=y-2;i<=y+2;i++) {
                star[x+2][i] = '*';
            }
            return;
        }

        int n2 = n/2;
        // 중앙
        go(x, y, n2);
        // 왼쪽
        go(x+n2, y-n2, n2);
        // 오른쪽
        go(x+n2, y+n2, n2);

    }

}

