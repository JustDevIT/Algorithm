import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static int[] X = {-1, 1, 0, 0};
	static int[] Y = {0, 0, -1, 1};
	static int max = 0;
	
	static void bfs() {
		
	}
	
	static void dfs(int sum, int c, int _x, int _y) {
		
		if(c > 4) {
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		int[][] tmap = new int[n+2][m+2];
		for(int k=0; k<4; k++) {
			int nx = _x + X[k];
			int ny = _y + Y[k];
			if(map[ny][nx] != -1 && map[ny][nx] !=-2) {
				int idx = 0;
				for(int t[] : map) {
					System.arraycopy(t, 0, tmap[idx++], 0, m+2);
				}
				
				int num = map[_y][_x]; 
				map[_y][_x] = -2;
				
				dfs(sum + num, c+1, nx, ny);
				
				idx = 0;
				for(int t[] : tmap) {
					System.arraycopy(t, 0, map[idx++], 0, m+2);
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
		
		map = new int[n+2][m+2];
		
		for(int t[] : map) {
			Arrays.fill(t, -1);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dfs(0, 1, j, i);
			}
		}
		
		System.out.println(max);
		
	}
}

