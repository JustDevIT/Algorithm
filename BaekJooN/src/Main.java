import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	
	static int c;
	
	static int[] score;
	static int[] statis;
	
	static int[] visited;
	
	static int ret;
	static int retScore;
	
	static int[] dp;
	

	/*
	static void dfs(int _idx, int _score, int _statis) {

		if(_idx == c) {
			
			if(_score>=n) {
				ret = Math.max(ret, _statis);
			}
			
			return;
		}
		
		dfs(_idx+1, _score, _statis);
		
		if(_score + score[_idx] <=m) {
			dfs(_idx+1, _score + score[_idx], _statis+statis[_idx]);
		}
		
	}
	*/
	
	static void dp() {
		
		//1 2 3
		/*
			
		 */
		
		for(int i=1; i<c;i++) {
			
			for(int j=1; j<c;j++) {
				if(i== (i-1) + score[j]) {
					dp[i] = Math.max(dp[i-1] + statis[j], dp[i]);
				}
			}
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//회사PC
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		//데스크탑
		//System.setIn(new FileInputStream("C://Algorithm/workspace/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		//노트북
		//System.setIn(new FileInputStream("C://Algorithm/Test/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		c = sc.nextInt();
		
		score = new int[c];
		statis = new int[c];
		
		dp = new int[c];
		
		for(int i=0;i<c;i++) {
			score[i] = sc.nextInt();
			statis[i] = sc.nextInt();
			
			if(score[i] == 0 && statis[i] > 0) {
				dp[0] +=  statis[i];
			}
			
		}
		
		//dfs(0, 0, 0);
		
		dp();
		
		System.out.println(ret);
		
	}
	
}

