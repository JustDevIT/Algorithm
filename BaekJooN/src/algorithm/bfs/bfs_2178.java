package algorithm.bfs;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class bfs_2178 {
	
	static int n, m;
	static int k[][];
	
	static int x = 0;
	static int y = 1;
	
	static int[] lx = {-1, 1, 0, 0};
	static int[] ly = {0, 0, -1, 1};
	
	static int[][] visited;
		
	static void solve(int sn, int sm) {
		
		LinkedList<int[]> ls = new LinkedList<int[]>();
		visited[sn][sm] = 1;
		
 		int[] st = new int[2];
		st[y] = sn;
		st[x] = sm;
		
		ls.addLast(st);
			
		while(!ls.isEmpty()) {
			int[] t = ls.removeFirst();
			
			boolean isnoWay = false;
			
			for(int i=0; i<4; i++) {
				
				int nx = t[x] + lx[i];
				int ny = t[y] + ly[i];
				
				int np = visited[t[y]][t[x]] + 1;
				
				if(k[ny][nx] != -1 && k[ny][nx] == 1 && visited[ny][nx] != -1 && visited[ny][nx] > np) {
					
					visited[ny][nx] = np;
					
					int c[] = new int[2];
					c[x] = nx;
					c[y] = ny;
					
					ls.addLast(c);
					
					isnoWay = true;
				}
			}
			
			if(!isnoWay && t[y] != n && t[y] != m) {
				visited[t[y]][t[x]] = -1;
			}
		}
		
		System.out.println(visited[n][m]);
	}
		

		
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Users//¿µÈÆ//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		k = new int[n+2][m+2];
		
		visited = new int[n+2][m+2];
		
		for(int[] t : k) {
			Arrays.fill(t, -1);
		}
		
		//1999999999
		
		for(int[] t : visited) {
			Arrays.fill(t, Integer.MAX_VALUE);
		}
		
		
		for(int i=1; i<=n; i++) {
			String tt = sc.next();
			for(int j=1; j<=m; j++) {	
				k[i][j] = Character.getNumericValue(tt.charAt(j-1));
			}
		}
		
		solve(1,1);
	}
}