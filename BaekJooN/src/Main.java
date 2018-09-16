import java.io.FileInputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static int[][] map, k;
	
	// left, right, up, down
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n, m;
	
	static int Kudarizaka(int x, int y) {
		
		System.out.print(map[y][x] + " ");
		
		if(y == m-2 && x == n-2) {
			return 1;
		}
		
		
		if(k[y][x] == 0) {
			for(int i=0;i<4;i++) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(map[ny][nx] < map[y][x] && map[ny][nx] > 0 ) {
					k[y][x] += Kudarizaka(nx, ny);
				}
			}
		}
		
		return k[y][x];
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		System.setIn(new FileInputStream("C://Users//¿µÈÆ//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt() + 2;
		n = sc.nextInt() + 2;
		
		map = new int[m][n];
		k = new int[m][n];
		
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				
				if(i==0 || i==(m-1) || j==0 || j==(n-1)) {
					map[i][j] = -1;
				}else {
					map[i][j] = sc.nextInt();	
				}
			}
		}
		
		Kudarizaka(1, 1);
		
		System.out.println(k[1][1]);
	}
}