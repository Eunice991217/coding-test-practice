

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static boolean map[][];
	static boolean[] checkCol;
	static boolean[] checkLeft;
	static boolean[] checkRight;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		checkCol = new boolean[16];
		checkLeft = new boolean[40];
		checkRight = new boolean[40];
		go(0);
		System.out.println(cnt);
	}

	static void go(int x) {
		if(x == n) {
			cnt++;
			return;
		}
		for(int y=0;y<n;y++) {
			if(checkCol[y] || checkLeft[x+y] || checkRight[x-y+n])continue;
			checkCol[y]= true;
			checkLeft[x + y] = true;
			checkRight[x - y + n] = true;
			go(x+1);
			checkCol[y] = false;
			checkLeft[x+y] = false;
			checkRight[x-y+n] = false;
		}
	}
	
	

}
