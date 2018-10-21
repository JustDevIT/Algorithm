import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	
	static int[][] dp;
	
	static int[] w;
	static int[] p;
	
	static int n;
	static int m;
	
	static void knapsack() {
		
		int capacity = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				capacity = j - w[i];
				
				if(w[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], p[i] + dp[i-1][capacity]);
				}else {
					dp[i][j] = dp[i-1][j]; 
				}
			}
		}
		
		System.out.println(dp[n][m]);
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//회사PC
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		//데스크탑
		System.setIn(new FileInputStream("C://Algorithm/workspace/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		//노트북
		//System.setIn(new FileInputStream("C://Algorithm/Test/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		w = new int[n+1];
		p = new int[n+1];
		
		
		dp = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			w[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		knapsack();
	}
	
}
