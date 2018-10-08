package algorithm.dp;

import java.io.FileInputStream;
import java.util.Scanner;

public class dp_13458 {

	static int n;
	static int m;
	
	static int[] q;
	static int a;
	static int b;
	
	static int[] k;
	
	static void dp() {
		// 1��°�� ������ �� ������ �����ؾ��Ѵ�.
		// 2��° ���ʹ� �� �����Ҽ� �ִ� �л� �� ��ŭ �����Ѵ�.
		int corver = a;
		k[0] = 1;
		
		for(int i=1; i<=m; i++) {
			if(corver - i < 0) {
				k[i] = k[i-1] + 1;
				corver += b;
			}else {
				k[i] = k[i-1];
			}
		}
		
		
		long ret = 0;
		for(int i=1; i<=n; i++) {
			ret += k[q[i]];
		}
		
		System.out.println(ret);
		
		
	}	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Algorithm/workspace/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		Scanner  sc = new Scanner(System.in);
		  
		n = sc.nextInt();
		
		q = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			q[i] = sc.nextInt();
			
			if(q[i] > m) {
				m = q[i];
			}
		}
		
		k = new int[m+1];
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		int t = Integer.MAX_VALUE;
		
		dp();
	}
	
}

