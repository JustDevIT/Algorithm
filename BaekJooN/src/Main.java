import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static void tile2n(int n) {
		long[] k = new long[1001];
		long[][] map = new long[1001][3];
		
		map[0][2] = 1;
		map[1][1] = 1;
		
		map[2][1] = 1;
		map[2][2] = 1;
		
		k[1] = 1 % 10007;
		
		for(int i = 2; i<=n;i++) {
			map[i][1] = (map[i-1][1] + map[i-1][2]) % 10007;
			map[i][2] = (map[i-2][1]+map[i-2][2]) % 10007;
			
			k[i] = (map[i][1] + map[i][2]) % 10007;  
		}
		
		System.out.println(k[n]);
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		tile2n(n);
	}
	

}

