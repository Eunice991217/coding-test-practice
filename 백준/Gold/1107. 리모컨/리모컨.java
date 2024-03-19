

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

	static int n, m;
	static boolean chan[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 이동 하려고 하는 채널
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		// 고장난 버튼 개수
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		// 고장난 버튼
		chan = new boolean[11];

		if (m != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int x = Integer.parseInt(st.nextToken());
				chan[x] = true;
			}
		}

		String str = n + "";
		int ans = Math.abs(n - 100);
		for (int i = 0; i <= 1000000; i++) {
			if (check(i))
				continue;
			String tmp = i + "";
			int sum = 0;
			sum = tmp.length() + Math.abs(i - n);
			ans = Math.min(ans, sum);
		}
		
		System.out.println(ans);

	}

	public static boolean check(int n) {
		if (n == 0) {
			return chan[0];
		}
		while (n > 0) {
			if (chan[n % 10])
				return true;
			n /= 10;
		}
		return false;
	}

}
