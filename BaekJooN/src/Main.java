import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Main {
	
	static int n;
	static int m;
	static int s;
	
	static int day = 0;
	static int happy = 1;
	
	static Vector<int[]> vc;
	
	static int max;
	
	static int[] visited;
	
	static void solve(int sum, int day, int c) {
		
		if(s==c) {
			max = Math.max(max, sum);
			return;
		}
		
		solve(0, 0, c+1);
		
		for(int i=0;i<s;i++) {
			int t[] = vc.get(i);
			
			if(visited[i] == 0) {
				visited[i] = 1;
				solve(sum +  t[happy], day + t[day], i);
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
		m = sc.nextInt();
		s = sc.nextInt();
		
		vc = new Vector<int[]>();
		visited = new int[m];
		
		for(int i=0; i<s;i++) {
			int[] t = new int[2];
			t[day] = sc.nextInt();
			t[happy] = sc.nextInt();
			
			vc.add(t);
		}
		
		solve(0, 0, 0);
		
	}
}

