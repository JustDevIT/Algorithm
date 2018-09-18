import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	
	static int[] tx = new int[2];
	static int[] ty = new int[2];
	
	static int[] lx = {-1, 1, 0, 0};
	static int[] ly = {0, 0, -1, 1};
	
	static int max = 999999999;
	
	static int turnStatus(int s, int c) {

		int ret = 0;
		
		switch(s) {
			case 0 : // 왼쪽 진행 중
					if(c == 2) {
						ret = 1;
					}else {
						ret = 0;
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
	
	static boolean isUturn(int s, int t) {
		if(s == 0 && t==1 || s == 1 && t==0) {
			return false;
		}else if(s == 2 && t==3 || s == 3 && t==2) {
			return false;
		}else {
			return true;
		}
		
	}
	
	static void solve (int r, int c, int s, int mode, int st, int sum) {
		
		System.out.println(c + " " + r);
		
		if(r==tx[1] && c==ty[1]) { 
			if(max > sum) {
				max = sum;
			}
			
			return;
		}
		
		if (st > 2) {
			return;
		}
		
		if(sum > max) {
			return;
		}
		
		for(int i=0; i<4; i++) {
			
			int nx = r + lx[i];
			int ny = c + ly[i];
			
			if(map[ny][nx] == 0 && isUturn(s, i)) {
				
				if(s != i && s != -1) {
					
					int nw = turnStatus (s, i);
					
					// 방향 전환 시 초기화
					if(mode==0 && nw == 1 || mode==1 && nw == 0) {
						st = 0;
					}
			
					solve(nx, ny, i, nw, st + 1, sum + 1);
					
				}else {
					solve(nx, ny, i, mode, st, sum + 1);
				}
			}
				
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		System.setIn(new FileInputStream("C://Users//영훈//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new int[n+1][m+1];
		
		for(int[] t : map) {
			Arrays.fill(t, 1);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j] == -1) {
					tx[0] = j;
					ty[0] = i;
					
					map[i][j] = 0;
				}else if(map[i][j] == -2) {
					tx[1] = j;
					ty[1] = i;
					
					map[i][j] = 0;
				}
				
				
			}
		}
		
		solve(tx[0], ty[0], -1, 0, 0, 0);
		
		System.out.println(max);
	}
}