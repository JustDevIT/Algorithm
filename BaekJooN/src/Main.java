import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int ret;

	static int[][] map;
	static int[] visited;
	
	static int SEQ = 0;
	static int DATA = 1;
	
	static Queue<Integer> q = new PriorityQueue<Integer>();
	
	static Queue<Integer> dp = new PriorityQueue<Integer>();
	
	static void dp(int _pos, int _sum) {
		
		if(visited[_pos] == 1) {
			
			if(ret < _sum) {
				ret = Math.max(ret, _sum);
				dp.clear();
				
				for(int i=1; i<=n;i++) {
					if(visited[i]==1) {
						dp.add(i);
					}
					
				}
			}
			
			return;
		}
		
		visited[_pos] = 1;
				
		int nextSeq = map[_pos][SEQ];
		
		for(int i=1;i<=n;i++) {
			if(visited[i] !=1 && map[i][DATA] == nextSeq) {
				visited[i] = 1;
				dp(map[i][SEQ], _sum + map[i][SEQ]);
				visited[i] = 0;
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
		
		map = new int[n+1][2];
		
		visited = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			map[i][SEQ] = i;
			map[i][DATA] = sc.nextInt();
			
			if(map[i][SEQ] == map[i][DATA]) {
				q.add(map[i][DATA]);
			}
				
		}

		for(int i=1;i<=n;i++) {
			dp(1, map[1][SEQ]);	
		}
		
		while(!q.isEmpty()) {
			dp.add(q.poll());
		}
		
		System.out.println(dp.size());
		while(!dp.isEmpty()) {
			System.out.println(dp.poll());
		}
		
	}
}

