package algorithm.dfs;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class dfs_bfs_14500 {
	
	static int n;
	static int m;
	static int[][] map;
	static int[][] visited;
	static int[] X = {-1, 1, 0, 0};
	static int[] Y = {0, 0, -1, 1};
	static int max = 0;
	
	static int _X = 0;
	static int _Y = 1;
	
	static void bfs(int i, int j) {
			int min = Integer.MAX_VALUE;
			int sum = map[i][j];
			int block = 0;
			
			// 십자가 모양으로 찾는다.
			for(int k=0; k<4; k++) {
				
				int ny = i + Y[k];  
				int nx = j + X[k]; 
				
				
				if(map[ny][nx] != -1) {
					sum+=map[ny][nx];
					
					min = Math.min(min, map[ny][nx]);
					block++;
				}
			}
			
			if(block == 4) {
				sum-=min;
			}
			
			max = Math.max(sum, max);
	}
	
	static void dfs(int sum, int c, int _x, int _y) {
		
		if(c == 4) {
				max = Math.max(sum, max);
			return;
		}
		
		for(int k=0; k<4; k++) {
			
			int nx = _x + X[k];
			int ny = _y + Y[k];
			
			if(map[ny][nx] != -1 && visited[ny][nx] != 1) {
				
				visited[ny][nx] = 1;
				
				dfs(sum + map[ny][nx], c+1, nx, ny);
				
				visited[ny][nx] = 0;
				
			}
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
		
		map = new int[n+2][m+2];
		visited = new int[n+2][m+2];
		
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
				visited[i][j] = 1;
				dfs(map[i][j], 1, j, i);
				bfs(i, j);
				visited[i][j] = 0;
				
				
			}
		}
		
		System.out.println(max);
	}
}

