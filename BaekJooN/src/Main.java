import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	
	static void tile1(int n) {
		long[] k = new long[1000000];
		
		k[0] = k[1] = 1;
		
		for(int i = 2; i<=n; i++) {
			k[i] = k[i-2] + k[i-1];
			k[i] %= 15746;
		}
		
		System.out.print(k[n]);
		
	}
	
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		tile1(n);
		
	}
	

}

