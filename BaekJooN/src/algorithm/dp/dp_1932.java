package algorithm.dp;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class dp_1932 {
	
	static int[][] dp;
	static int k;
	static int[] x = {-1, 1};
	static int[] y = {-1, -1};
	
	static void solve (int n, int an) {
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<= an; j++) {
				
				int rsum = dp[i][j] + dp[i+y[0]][j+x[0]];
				int lsum = dp[i][j] + dp[i+y[1]][j+x[1]];
				
				 if(rsum > lsum) {
					 dp[i][j] += dp[i+y[1]][j+x[0]];
				 }else {
					 dp[i][j] += dp[i+y[1]][j+x[1]];
				 }
			}
		}
		
		for(int i=1; i<= an; i++) {
			k = Math.max(k, dp[n][i]);
		}
		
		System.out.println(k);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Users//¿µÈÆ//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int an = n+(n-1) + 3;
		
		dp = new int[n+1][an];
		
		for(int[] t : dp) {
			Arrays.fill(t, 0);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<= i; j++) {
				if(j==1) {
					dp[i][(n+1)-i] = sc.nextInt();
				}else {
					dp[i][(j+(n-i)) + (j - 1)] = sc.nextInt();
				}
			}
		}
		
		solve(n, an-3);
	}
}