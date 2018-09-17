import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static int n, m;
	static int[][] map, k;
	
	static int[] nx = {-1, 0};
	static int[] ny = {0, -1};
	
	static void candy() {
		
		for(int i =1; i<=n; i++) {
			for(int j =1; j<=m; j++) {
				
				if(i==1 && j==1) {
					k[i][j] = map[i][j];
					continue;
				}
				
				if(i==1) {
					// 왼쪽에서만 들어오는 값
					k[i][j] = k[i+ny[0]][j+nx[0]] + map[i][j]; 
				} else if(j==m && i==1 && i!=n || j == 1) {
					// 위에서만 들어오는 값 
					k[i][j] = k[i+ny[1]][j+nx[1]] + map[i][j]; 
				} else {
					// 왼쪽, 위쪽에서 들어오는 값
					k[i][j] = Math.max(k[i+ny[0]][j+nx[0]] + map[i][j], k[i+ny[1]][j+nx[1]] + map[i][j]);
					
				}
				
			}
		}
		
		System.out.println(k[n][m]);
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Users//영훈//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
				
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+1][m+1];
		k = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		candy();
		
	}
}