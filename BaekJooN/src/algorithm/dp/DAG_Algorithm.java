package algorithm.dp;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DAG_Algorithm {
	
	static int n;
	static int m;
	static int c;
	
	static int[][] ticket;
	static int[][] cache;
	
	
	static int solve(int idx, int visit) {
		
		// base case
		if(idx != n && visit ==m) {
			return Integer.MIN_VALUE;
		}
		
		if(idx == n) {
			return 0;
		}
		
		if(cache[idx][visit]>0) {
			return cache[idx][visit];
		}
		
		
		for(int to=idx+1; to<=n; to++) {
			if(ticket[idx][to] > 0) {
				cache[idx][visit] = Math.max(cache[idx][visit], ticket[idx][to] + solve(to, visit + 1));
			}
		}
		
		
		return cache[idx][visit];
		
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		c = sc.nextInt();
		
		ticket = new int[301][301];
		cache = new int[301][301];
		
		for(int[] t : ticket) {
			Arrays.fill(t, -1);
		}
		
		for(int[] t : cache) {
			Arrays.fill(t, -1);
		}
		
		for(int i=0; i<c; i++) {
			int city1 = sc.nextInt();
			int city2 = sc.nextInt();
			int taste = sc.nextInt();
			
			ticket[city1][city2] = Math.max(ticket[city1][city2], taste);
		} 
		
		System.out.println(solve(1,1));
		
	}
	
}
