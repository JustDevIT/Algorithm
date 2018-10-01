import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static int n;
	static int max;
	
	static void move(int c) {
		
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
						map[idx][i] *= 2;
						idx ++;
					}else {
						map[++idx][i] = t;
					}
						
				}
				
			}
			
			break;
		
		case 1: // down
			for(int i=0; i<n;i++) {
				for(int j=n-1; j>=0;j--) {
					if(map[j][i] != 0) {
						q.add(map[j][i]);
						
						map[j][i] = 0;
					}
				}
				
				int idx = n-1;
				
				while(!q.isEmpty()) {
					int t = q.poll();
					
					if(map[idx][i]==0) {
						map[idx][i] = t;
					}else if(map[idx][i]==t) {
						map[idx][i] *= 2;
						idx --;
					}else {
						map[--idx][i] = t;
					}
						
				}
				
			}
			break;
			
		case 2: // left
			
			for(int i=0; i<n;i++) {
				for(int j=0; j<n;j++) {
					if(map[i][j] != 0) {
						q.add(map[i][j]);
						
						map[i][j] = 0;
					}
				}
				
				int idx = 0;
				
				while(!q.isEmpty()) {
					int t = q.poll();
					
					if(map[i][idx]==0) {
						map[i][idx] = t;
					}else if(map[i][idx]==t) {
						map[i][idx] *= 2;
						idx++;
					}else {
						map[i][++idx] = t;
					}
						
				}
				
			}
			
			
			break;
			
		case 3: //right
			
			for(int i=0; i<n;i++) {
				for(int j=n-1; j>=0;j--) {
					if(map[i][j] != 0) {
						q.add(map[i][j]);
						
						map[i][j] = 0;
					}
				}
				
				int idx = n-1;
				
				while(!q.isEmpty()) {
					int t = q.poll();
					
					if(map[i][idx]==0) {
						map[i][idx] = t;
					}else if(map[i][idx]==t) {
						map[i][idx] *= 2;
						idx --;
					}else {
						map[i][--idx] = t;
					}
						
				}
				
			}
			
			break;
		}
		
		
		
	}
	
	static void dfs(int depth) {
		
		if(depth==5) {
			
			for(int[] k : map) {
				for(int s : k) {
					
					if(max < s) {
						max = s;
					}
				}
			}
			
			return;
		}
		
		// temp 저장
		int[][] temp = new int[n][n];

		for (int i = 0; i<4; i++) {
			
			for(int j=0; j<n; j++) {
				System.arraycopy(map[j], 0, temp[j], 0, map.length);
			}
			
			move(i);
			dfs(depth+1);

			// 값 반환
			for(int j=0; j<n; j++) {
				System.arraycopy(temp[j], 0, map[j], 0, map.length);
			}
		}
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
		
		dfs(0);
	
		System.out.println(max);
		
	}
}