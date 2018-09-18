import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[][] dp;
	
	static int[] tx = new int[2];
	static int[] ty = new int[2];
	
	static int[] lx = {-1, 1, 0, 0};
	static int[] ly = {0, 0, -1, 1};
	
	static int turnStatus(int s, int c) {

		int ret = 0;
		
		switch(s) {
			case 0 : // 왼쪽 진행 중
					if(c == 2) {
						ret = 0;
					}else {
						ret = 1;
					}
				
				break;
				
			case 1 : // 오른쪽 진행 중
				
				if(c == 2) {
					ret = 0;
				}else {
					ret = 1;
				}
				break;
				
			case 2 : // 위쪽 진행 중
					ret = c;
				break;
			
			case 3 : // 아래쪽 진행중
				if(c == 1) {
					ret = 0;
				}else {
					ret = 1;
				}
				break;
			}
			
		return ret;
		
	}
	
	static int solve (int r, int c, int s, int[] st) {
		
		System.out.println(c + " " + r);
		
		if(r==tx[1] && c==ty[1]) { 
			return 1;
		}
		
		if (st[0] > 2 || st[1] > 2) {
			return 0;
		}
		
		dp[c][r] = 0;
		
		for(int i=0; i<4; i++) {
			
			int nx = r + lx[i];
			int ny = c + ly[i];
			
			if(dp[ny][nx] == -1 && map[ny][nx] == 0) {
					
				if(s == -1) {
					s=i;
				}else if(s != i){
					st[turnStatus (s, i)] += 1;
					s=i;
					
					if(turnStatus (s, i) == 0) {
						st[1] = 0;
					}else if(turnStatus (s, i) == 1) {
						st[0] = 0;
					}
				}
				
				
					solve(nx, ny, s, st);
			}
				
		}
		
		return map[c][r];
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Users//영훈//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new int[n+1][m+1];
		dp  = new int[n+1][m+1];
		
		for(int[] t : dp) {
			Arrays.fill(t, -1);
		}
		
		for(int[] t : map) {
			Arrays.fill(t, 1);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j] == -1) {
					tx[0] = j;
					ty[0] = i;
				}else if(map[i][j] == -2) {
					tx[1] = j;
					ty[1] = i;
				}
			}
		}
		
		int[] st = new int[4];
		solve(tx[0], ty[0], -1, st);
	}
}