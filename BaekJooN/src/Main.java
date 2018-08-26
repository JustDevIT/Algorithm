import java.io.FileInputStream;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] map = new int[1001][1001];
	static boolean[] visited;
	
	static void dfs(int c) {
		// 1 2
		// 2 4
		
		visited[c] = true;
		System.out.print(c) ;
		
		for(int i=1; i< visited.length; i++) {
			if(map[c][i]==1 && !visited[i]) {
				
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		// 4 5 1
		int n = sc.nextInt();
		int s = sc.nextInt();
		int c = sc.nextInt();
		
		visited = new boolean[s+1];
		
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		
		for(int i =0;i<s;i++) {
			int s1 = sc.nextInt();
			int t1 = sc.nextInt();
			
			map[s1][t1] = map[t1][s1] = 1;
		}
		
		dfs(c);
	}
	

}
