import java.io.FileInputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static int[][] map;
	// left, right, up, down
	static int[] x = {-1, 1, 0, 0};
	static int[] y = {0, 0, -1, 1};
	
	
	static void Kudarizaka(int m, int n) {
	
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt() + 2;
		int n = sc.nextInt() + 2;
		
		map = new int[m][n];
		
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				
				if(i==0 || i==(m-1) || j==0 || j==(n-1)) {
					map[i][j] = -1;
				}else {
					map[i][j] = sc.nextInt();	
				}
			}
		}
		
		Kudarizaka(m-2, n-2);
		
		
		
	}
}