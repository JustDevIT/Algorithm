package algorithm.dp;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DAG_Algorithm {
	
	static int n, m, k;
	static int[][] ticket;
	static int[][] cache;
	
	static int Search(int idx, int visit) {
		
		if(idx != n && visit == m) {
			return Integer.MIN_VALUE;
		}
		if(idx==n) {
			return 0;
		}
		
		if(cache[idx][visit] != -1) {
			return cache[idx][visit];
		}
		
		for(int to = idx + 1; to <=n; to++) {
			System.out.println(to + " " + (visit+1));
			if(ticket[idx][to] > 0) {
				cache[idx][visit]  = Math.max(cache[idx][visit], ticket[idx][to] + Search(to, visit + 1));
			}
		}
		
		return cache[idx][visit] ;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//데스크탑
		System.setIn(new FileInputStream("C://Algorithm/workspace/Algorithm/BaekJooN/TestCase/Sample.txt"));

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		ticket = new int[k+1][k+1];
		cache = new int[k+1][k+1];
		
		
		for(int[] t : ticket) {
			Arrays.fill(t, -1);
		}
		
		for(int[] t : cache) {
			Arrays.fill(t, -1);
		}
		
		for(int i =0; i < k; i++) {
			int city1, city2, taste;
			
			city1 = sc.nextInt();
			city2 = sc.nextInt();
			taste = sc.nextInt();
			
			ticket[city1][city2] = Math.max(ticket[city1][city2], taste);
		}
		
		System.out.println(Search(1, 1));
	}
}
