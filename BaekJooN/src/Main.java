import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int w;
	static String[][] map;
	
	static int[] X = {-1, 1, 0, 0};
	static int[] Y = {0, 0, -1, 1};
	
	static int _Y = 0;
	static int _X = 1;
	
	static int L = 0;
	static int D = 1;
	
	static snake sk;
	
	static HashMap<Integer, String> hm = new HashMap<Integer, String>(); 
	
	static void solve() {
		
		sk = new snake();
		int[] tail = new int[2];
		tail[_X] = 1;
		tail[_Y] = 1;
				
		sk.tail.add(tail);
		
		map[1][1] = "V";
		sk.way = 1;
		
		int idx = 0;
		
		int nowX=1,  nowY=1;
		
		while(true) {
			
			idx+=1;
			
			nowX += X[sk.way];
			nowY += Y[sk.way];
			
			if(map[nowY][nowX].equalsIgnoreCase("A")) {
				if(!sk.tail.isEmpty()) {
					int t[] = sk.tail.poll();
					map[t[_Y]][t[_X]] = "S";
					
					map[nowY][nowX] = "S";
				}
				
			}else if(map[nowY][nowX].equalsIgnoreCase("E") || map[nowY][nowX].equalsIgnoreCase("V")) {
				break;
			}else {
				map[nowY][nowX] = "V";
				
				int t[] = new int[2];
				t[_Y] = nowY;
				t[_X] = nowX;
				
				sk.tail.add(t);
				
			}
			
			if(hm.get(idx) != null) {
				sk.setNextWay(hm.get(idx));
			}
			
		}
		
		System.out.println(idx);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new String[n+2][n+2];
		
		for(String[] t : map) {
			Arrays.fill(t, "E");
		}
		
		m = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				map[i][j] = "S";
			}
		}
		
		for(int i=0; i<m; i++){
			int t1 = Integer.parseInt(sc.next());
			int t2 = Integer.parseInt(sc.next());
			
			map[t1][t2] = "A"; 
		}
		
		
		w = sc.nextInt();
		
		for(int i=0; i<w; i++){
			hm.put(Integer.parseInt(sc.next()), sc.next());
		}
		
		solve();
	}
	
	static class snake {
		
		public int way;
		
		public Queue<int[]> tail = new LinkedList<int[]>();

		// 0(L), 1(R), 2(U), 3(D)		
		public void setNextWay(String s) {
				switch(s) {
				case "L" :
					if(way==0)
					{
						way = 3;
					}else if(way==1) {
						way = 2;
					}else if(way==2) {
						way = 0;
					}else if(way==3) {
						way = 1;
					}
						
					break;
				
				case "D" :
					if(way==0)
					{
						way = 2;
					}else if(way==1) {
						way = 3;
					}else if(way==2) {
						way = 1;
					}else if(way==3) {
						way = 0;
					}
					break;
				}
		}
	}
}
