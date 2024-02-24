import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st =new StringTokenizer(br.readLine());
		
		dp = new int[1000004];
				
		n = Integer.parseInt(st.nextToken());
		
		dp[1] = 0;
		dp[2]=1;
		dp[3]=1;
		
		for(int i=4;i<=n;i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			} if(i%3==0) {
				dp[i] = Math.min(dp[i/3]+1, dp[i]);
			}
		}
		
		System.out.println(dp[n]);
		
	}
	
	
}
