import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int s;
	
	static int max;
	
	static int[] dp;
	static int[] visited;
	
	static int happy[];
	static int score[];

	static void solve() {
		
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//회사PC
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		//데스크탑
		//System.setIn(new FileInputStream("C://Algorithm/workspace/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		//노트북
		System.setIn(new FileInputStream("C://Algorithm/Test/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		s = sc.nextInt();
		
		score = new int[s];
		happy = new int[s];
		
		dp = new int[s+1];
		
		//Arrays.fill(dp, Integer.MIN_VALUE);
		
		for(int i=0; i<s;i++) {
			int[] t = new int[2];
			
			t[0] = sc.nextInt();
			t[1] = sc.nextInt();
			
			if(t[0]==0) {
				if(t[1] > 0) {
					dp[t[0]] += t[1];
				}
			}else {
				score[i] = t[0];
				happy[i] = t[1];
			}
			max = Math.max(score[i], max);
		}
		
		visited = new int[max+1];
		
		solve();
		
		System.out.print(max);
		
	}
}

