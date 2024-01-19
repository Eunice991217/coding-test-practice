

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, k;
	
	static Stack<Integer> stk = new Stack<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			if(m==1) {
				k = Integer.parseInt(st.nextToken());
				stk.push(k);
			}else if(m==2) {
				if(!stk.isEmpty()) {
					sb.append(stk.lastElement()).append("\n");
					stk.pop();
				}else {
					sb.append(-1).append("\n");
				}
			}else if(m==3) {
				sb.append(stk.size()).append("\n");
			}else if(m==4) {
				if(stk.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else {
				if(!stk.isEmpty()) {
					sb.append(stk.lastElement()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
