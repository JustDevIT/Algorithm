import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static int n;
	static int tt;
	
	static void move(int c) {
		
		tt =3;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		switch(c) {
		
		case 0: // up
			for(int i=0; i<n;i++) {
				for(int j=0; j<n;j++) {
					if(map[j][i] != 0) {
						q.add(map[j][i]);
						
						map[j][i] = 0;
					}
					
					
				}
				
				int idx = 0;
				
				while(!q.isEmpty()) {
					int t = q.poll();
					
					if(map[idx][i]==0) {
						map[idx][i] = t;
					}else if(map[idx][i]==t) {
						map[idx][i] *= t;
						idx ++;
					}else {
						map[++idx][i] = t;
					}
						
				}
				
			}
			
			break;
		
		case 1: // down
			
			break;
			
		case 2: // left
			
			break;
			
		case 3: //right
			
			break;
		
		}
		
		
		
	}
	
	static void dfs(int depth) {
		
		if(depth==5) {
			return;
		}
		
		// temp 저장
		int tmp = tt;
		
		for (int i = 0; i<4; i++) {
			move(i);
			dfs(depth+1);
			
			// 초기화
			tt = tmp;
		}
		
		
	}
	
	static void init() {
		
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map= new int[n][n];
		
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		dfs(1);
		
	}
		
		
}