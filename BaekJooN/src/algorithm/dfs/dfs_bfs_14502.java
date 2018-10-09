package algorithm.dfs;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dfs_bfs_14502 {
	static int[][] map;
	static int n;
	static int m;
	static int max;
	
	static int X = 0;
	static int Y = 1;
	
	static int[] NX = {-1, 1, 0, 0};
	static int[] NY = {0, 0, -1, 1};
	
	static Queue<int[]> q;
	
	static void bfs() {
		
		Queue<int[]> _q = new LinkedList<int[]>(q);
		
		
		while(!_q.isEmpty()) {
			
			int[] t = _q.poll();
			
			for(int i=0; i<4;i++) {
				int _nx = t[X] + NX[i];
				int _ny = t[Y] + NY[i];
				
				if(map[_ny][_nx] == 0) {
					map[_ny][_nx] = 2;
					
					int s[] = new int[2];
					s[X] = _nx;
					s[Y] = _ny;
					_q.add(s);
				}
			}
		}
	}
	
	static int cnt() {
		int ret=0;
		
		bfs();
		
		for(int[] t : map) {
			for(int c : t) {
				if(c==0) {
					ret++;
				}
			}
		}
		
		return ret;
	}
	
	static void dfs(int firewall) {
		
		if(firewall > 3) {
			int ret = cnt();
			if(max < ret) {
				max = ret;
			}
			
			return;
		}
		
		int[][] tmap = new int[n+2][m+2];
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=m; j++) {
				if(map[i][j] == 0) {
					
					int idx=0;
					for(int[] t : map) {
						System.arraycopy(t, 0, tmap[idx++], 0, m+2);
					}
					
					map[i][j] = 7;
					dfs(firewall + 1);
					
					idx=0;
					for(int[] t : tmap) {
						System.arraycopy(t, 0, map[idx++], 0, m+2);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Algorithm/workspace/Algorithm/BaekJooN/TestCase/Sample.txt"));
		System.setIn(new FileInputStream("C://Algorithm/Test/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+2][m+2];
		
		q = new LinkedList<int[]>();
		
		for(int t[] : map) {
			Arrays.fill(t, -1);
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=m; j++) {
				int t = sc.nextInt();
				
				map[i][j] = t;
				
				if(t==2) {
					int[] tq = new int[2];
					tq[X] = j;
					tq[Y] = i;
					
					q.add(tq);
				}
			}
		}
		
		dfs(1);
		
		System.out.println(max);
	}
}

