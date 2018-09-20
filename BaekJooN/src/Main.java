import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int k;
	static int[][] s;
	static int ret;
	
	static void solve(int i, int sumN, int sumM) {
		
		System.out.println(i);
		if(i==k) {
			
			if(n <= sumN  && m >= sumN) {
				
				ret = Math.max(ret, sumM);
			}
			
			return;
		}

		solve(i+1,sumN,sumM);
		
		if(sumN <= m)
		{
 			solve(i+1, s[i+1][0] + sumN, s[i+1][1] + sumM);
		}
	
		
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Users//¿µÈÆ//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		k = sc.nextInt();
		
		s = new int[k+1][2];
		
		for(int i=1; i<=k; i++) {
			s[i][0] = sc.nextInt();
			s[i][1] = sc.nextInt();
		}
		
		
		solve(0, 0, 0);
		
		System.out.println(ret);
	}
		
}