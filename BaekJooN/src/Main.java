import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {
	
	static int n;
	static int m;
	static int s;
	
	static int[] dp;
	
	static Queue<int[]> q;
	
	static int S = 0;
	static int H = 1;
	
	static void solve() {
		
		for(int i=1; i<=m; i++) {
			
			int[] selected = new int[2];
			for(int[] t : q) {
				if(t[S] + (i-1) == i) {
					if(dp[i] < dp[i-1] + t[H]) {
						dp[i] = dp[i-1] + t[H];
						selected = t;
					}
				}
			}
			
			q.remove(selected);
		}
		
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
		s = sc.nextInt();
		
		//dp = new int[1000001];
		dp = new int[10];
		
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
				
		q = new LinkedList<int[]>();
		
		for(int i=0; i<s;i++) {
			int[] t = new int[2];
			
			t[S] = sc.nextInt();
			t[H] = sc.nextInt();
			
			if(t[S] == 0 && t[H]>0) {
				dp[0] += t[H];
			}else {
				q.add(t);
			}
		}
		
		solve();
		
		int ret=0;
		for(int i=n; i<=m;i++) {
			ret = Math.max(ret, dp[i]);
		}
		
		System.out.print(ret);
	}
}

