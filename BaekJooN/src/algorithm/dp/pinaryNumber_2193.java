package algorithm.dp;

public class pinaryNumber_2193 {
	
	static void pinaryNumber(int n) {
		long[][] k = new long[100][100];
		
		k[1][0] = 0;
		k[1][1] = 1;
		
		for(int i = 2; i<=n; i++) {
			k[i][0] = k[i-1][0] + k[i-1][1]; 
			k[i][1] = k[i-1][0];
		}
		
		System.out.print(k[n][0] + k[n][1]);
		
	}
	
}
