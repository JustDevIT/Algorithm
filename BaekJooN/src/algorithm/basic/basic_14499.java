package algorithm.basic;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Dice {
	
	// 0 À­¸é, 1 ¾Æ·§¸é, 2 µ¿ÂÊ, 3¼­ÂÊ, 4 ºÏÂÊ, 5³²ÂÊ
	int[] m = new int[6];
	
	void move(int s) {
		
		int t[] = new int[6];
		int idx = 0;
		for (int tmp : m) {
			t[idx++] = tmp;
		}
		
		switch(s) {
			case 1:
				m[0] = t[3];
				m[1] = t[2];
				m[2] = t[0];
				m[3] = t[1];
				break;
			case 2:
				m[0] = t[2];
				m[1] = t[3];
				m[2] = t[1];
				m[3] = t[0];
				break;
			case 3:
				// 0 À­¸é, 1 ¾Æ·§¸é, 2 µ¿ÂÊ, 3¼­ÂÊ, 4 ºÏÂÊ, 5³²ÂÊ
				m[0] = t[5];
				m[1] = t[4]; 
				m[4] = t[0];
				m[5] = t[1];
				break;
			case 4:
				m[0] = t[4];
				m[1] = t[5];
				m[4] = t[1];
				m[5] = t[0];
				break;
		}
	}
	
	void copyNumber(int c) {
		m[1] = c;
	}
	
	int bottom() {
		return m[1];
	}
	

	int top() {
		return m[0];
	}
}

public class basic_14499 {
	 
	static int n;
	static int m;
	
	static int[][] map;
	static int[] order;
	
	static int[] X = {0, 1, -1, 0, 0};
	static int[] Y = {0, 0, 0, -1, 1};
	
	static void solve(int x, int y) {
		// µ¿ÂÊÀº 1, ¼­ÂÊÀº 2, ºÏÂÊÀº 3, ³²ÂÊÀº 4·Î ÁÖ¾îÁø´Ù.
		Dice dice = new Dice();
		
		/* 
		 *  4 2 0 0 8
			0 2
			3 4
			5 6
			7 8
			4 4 4 1 3 3 3 2
		 */
		int nowX = x;
		int nowY = y;
		
		for(int i=0; i<order.length; i++) {
			int nx = nowX + X[order[i]]; 
			int ny = nowY + Y[order[i]];
			if(map[ny][nx] == -1 ) {
				continue;
			}else if(map[ny][nx] == 0 ) {
				dice.move(order[i]);
				
				nowX = nx; 
				nowY = ny;
				
				map[ny][nx] = dice.bottom();
				
				System.out.println(dice.top());
			}else {
				dice.move(order[i]);
				
				nowX = nx; 
				nowY = ny;
				
				dice.copyNumber(map[ny][nx]);
				map[ny][nx] = 0;
				
				System.out.println(dice.top());
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		System.setIn(new FileInputStream("C://Algorithm/workspace/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		int sy = sc.nextInt();
		int sx = sc.nextInt();
		
		int s = sc.nextInt();
		
		order = new int[s];
		
		map = new int[n+2][m+2];
		
		for(int[] t : map) {
			Arrays.fill(t, -1);
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<s; i++) {
			order[i] = sc.nextInt();
		}
		
		solve(sx+1, sy+1);
	}
	
}

