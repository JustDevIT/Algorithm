package algorithm.bfs;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs_1697 {

	static int n, m;
	static int[] nx = {-1, 1, 2};
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] visited = new int[100001];
	
	static void solve() {
		
		int num=0;
		
		if(n > m) {
			System.out.println(n-m);
			return;
		}
		
		while(!q.isEmpty()) {
			
			
			int[] s = q.poll();
			
			visited[s[0]] = 1;
			
			if(s[0]==m) {
				System.out.print(s[1]);
				break;
			}
			
			for(int i=0; i<3;i++) {
				
				int next = 0;
				
				if(i<=1) {
					next = s[0] + nx[i]; 
				}else {
					next = s[0] * 2;
				}
				
				if(next < 100001 && next >= 0 && visited[next] != 1) {
					
					int[] ns = new int[2];
					ns[0] = next;
					ns[1] = s[1] + 1;
					
					q.add(ns);
					
				}
				
			}
			
			
		}
		
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Users//¿µÈÆ//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		int[] s = new int[2];
		s[0] = n;
		s[1] = 0;
		
		q.add(s);
		solve();
	}
		
}