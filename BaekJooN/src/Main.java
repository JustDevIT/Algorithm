import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	
	static int n;
	static int m;
	
	
	
	
	static void move(int c) {
		
	}
	
	static void dfs(int depth, int[] r, int[] b) {
		
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map= new int[n][m];
		
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
	}
}