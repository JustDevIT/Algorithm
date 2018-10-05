package algorithm.dfs;

//BFS 문제를 DFS 로 푼 문제....
//깊이 탐색 중 삽질 방지를 위한 코드를 추가함
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dfs_13460 {
	
	static String[][] map;
	
	static int n;
	static int m;
	
	static int min;
	
	static int[] pathX = {-1,1,0,0};
	static int[] pathY = {0,0,-1,1};
	
	static int Y = 0;
	static int X = 1;
	
	static int BY = 2;
	static int BX = 3;
	
	static class Ball {
		String color;
		int x;
		int y;
	}
	
	static int[] move(int c, int k[]) {
		
		Queue<Ball> q = new LinkedList<Ball>();
		int[] ret = new int[4];
		
		// 먼저 굴릴 공을 찾는다.
		int nx = k[X];
		int ny = k[Y];
		
		boolean isBlue = false;
		while(true) {
			nx += pathX[c];
			ny += pathY[c];
			
			if(map[ny][nx].equalsIgnoreCase("#")) {
				break;
			}else if(map[ny][nx].equalsIgnoreCase("B")) {
				isBlue = true;
				break;
			}
			
		}
			
		// 우선순위는 R 이 먼저지만, 앞에 B가 있는 경우 B가 먼저 굴러 간다.
		if (isBlue) {
			Ball ballB = new Ball();
			ballB.color = map[k[BY]][k[BX]]; 
			ballB.x = k[BX];
			ballB.y = k[BY];
			q.add(ballB);
			
			Ball ballA = new Ball();
			ballA.color = map[k[Y]][k[X]]; 
			ballA.x = k[X];
			ballA.y = k[Y];
			q.add(ballA);
		}else {
			Ball ballA = new Ball();
			ballA.color = map[k[Y]][k[X]]; 
			ballA.x = k[X];
			ballA.y = k[Y];
			q.add(ballA);
			
			Ball ballB = new Ball();
			ballB.color = map[k[BY]][k[BX]]; 
			ballB.x = k[BX];
			ballB.y = k[BY];
			q.add(ballB);
		}
		
		while(!q.isEmpty()) {
			Ball b = q.poll();
			
			map[b.y][b.x] = ".";
			
			while(true) {
				
				int tx = b.x;
				int ty = b.y;
				
				b.x +=  pathX[c];
				b.y +=  pathY[c];
				
				if(map[b.y][b.x].equalsIgnoreCase("#") || map[b.y][b.x].equalsIgnoreCase("R") || map[b.y][b.x].equalsIgnoreCase("B")) {

					if(b.color.equalsIgnoreCase("R")) {
						ret[X] = tx;
						ret[Y] = ty;
					}else {
						ret[BX] = tx;
						ret[BY] = ty;
					}
					
						map[ty][tx] = b.color;
					
					break;
				}else if(map[b.y][b.x].equalsIgnoreCase("O") || map[b.y][b.x].equalsIgnoreCase("G") || map[b.y][b.x].equalsIgnoreCase("F")) {
					
					if(b.color.equalsIgnoreCase("R") && !map[b.y][b.x].equalsIgnoreCase("F")) {
						map[b.y][b.x] = "G";
					}else if(b.color.equalsIgnoreCase("B")) {
						map[b.y][b.x] = "F";
					}
					
					break;
				}
			}
		}
	
		return ret;
	}
	
	static int chkgoal() {
		
		int ret = 0;
		
		for(String t[] : map) {
			for(String s : t) {
				if(s.equalsIgnoreCase("G")) {
					ret = 1;
					return ret;
				}else if(s.equalsIgnoreCase("F")) {
					ret = 2;
					return ret;
				}
			}
		}
		
		return ret;
		
	}
	
	static void dfs(int depth, int x, int y, int bx, int by, int bPath) {
		
		if(depth>10 || chkgoal() == 2 || min < depth) {
			return;
		}
		
		if(chkgoal()==1) {
			if(min > depth) {
				min = depth;
			}
			
			return;
		}
		
		for(int i=0;i<4;i++) {
				
				int nx = x + pathX[i];
				int ny = y + pathY[i];
				
				int bnx = bx + pathX[i];
				int bny = by + pathY[i];
				
				int si = 0;
				String[][] tmap = new String[n+2][m+2];
				
				for(String[] s : map) {
					System.arraycopy(s, 0, tmap[si++], 0, m+2);
				}
				
				boolean isPath = false;
				
				if(!map[ny][nx].equalsIgnoreCase("#")) {
					isPath = true;
				}
				
				if(!map[bny][bnx].equalsIgnoreCase("#")) {					
					isPath = true;
				}
				
				if(isPath && !isBack(bPath, i)) {
					int t[] = new int[4];
					
					t[Y] = y;
					t[X] = x;
					t[BY] = by;
					t[BX] = bx;
					
					int[] k = move(i,  t);
					
					dfs(depth+1, k[X], k[Y], k[BX], k[BY], i);
				
				}
				
				si=0;
				for(String[] s : tmap) {
					System.arraycopy(s, 0, map[si++], 0, m+2);
				}
				
		}
	}
	
	static boolean isBack(int p, int g) {
		boolean ret = false;
		
		if(p==0) {
			if(g==1) {
				ret = true;
			}
		}else if(p==1) {
			if(g==0) {
				ret = true;
			}
		}else if(p==2) {
			if(g==3) {
				ret = true;
			}
		}else if(p==3) {
			if(g==2) {
				ret = true;
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map= new String[n+2][m+2];
		
		min = Integer.MAX_VALUE;
		
		int[] r = new int[2];
		int[] b = new int[2];
		
		for(String t[] : map) {
			Arrays.fill(t, "#");
		}
		
		
		for(int i=1; i <= n; i++) {
			String tmp = sc.next();
			
			for(int j=1; j<= m; j++) {
				
				map[i][j] =  Character.toString(tmp.charAt(j-1));
				
				if(map[i][j].equalsIgnoreCase("B")) {
					b[Y] = i;
					b[X] = j;
				}else if(map[i][j].equalsIgnoreCase("R")) {
					r[Y] = i;
					r[X] = j;
				}
			}
		}
		
		dfs(0, r[X], r[Y], b[X], b[Y], 5);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
	}
}
