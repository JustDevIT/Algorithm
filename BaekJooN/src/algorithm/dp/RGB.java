package algorithm.dp;

import java.io.FileInputStream;
import java.util.Scanner;

public class RGB {
	static int[][] K = new int[2000][3];
	
	static void rgb(int n) {
		long[][] rgb = new long[2000][3];
		long[] s = new long[2000];
		
		rgb[1][0] = K[1][0];
		rgb[1][1] = K[1][1];
		rgb[1][2] = K[1][2];
			
		
		for(int i = 2; i<=n; i++) {
			rgb[i][0] = Math.min(rgb[i-1][1] + K[i][0], rgb[i-1][2] + K[i][0]);
			rgb[i][1] = Math.min(rgb[i-1][0] + K[i][1], rgb[i-1][2] + K[i][1]);
			rgb[i][2] = Math.min(rgb[i-1][0] + K[i][2], rgb[i-1][1] + K[i][2]);
			
			s[i] = Math.min(rgb[i][0], rgb[i][1]);
			s[i] = Math.min(s[i], rgb[i][2]);
		}
		
		System.out.print(s[n]);
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
				K[i][0] = sc.nextInt();
				K[i][1] = sc.nextInt();
				K[i][2] = sc.nextInt();
		}
		
		rgb(n);
		
	}
	
	
}
