

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, start;
	static boolean visited[];
	static ArrayList<Integer> list[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[1001];
		visited = new boolean[1001];
		
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int x=0, y=0;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
		}
		
		
		dfs(start);
		for(int i=1;i<=n;i++) {
			visited[i] = false;
		}
		System.out.println();
		bfs(start);
		
		
		
	}
	
	public static void dfs(int x) {
		visited[x] = true;
		System.out.print(x + " ");
		for(int i=0;i<list[x].size();i++) {
			int next = list[x].get(i);
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
	
	public static void bfs(int x) {
		visited[x] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int next = q.poll();
			System.out.print(next + " ");
			for(int i=0;i<list[next].size();i++) {
				int a = list[next].get(i);
				if(!visited[a]) {
					q.add(a);
					visited[a] = true;
				}
			}
		}
	}
}
