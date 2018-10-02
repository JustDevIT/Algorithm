import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
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
	
	static int[] move(int c) {
		
		Queue<Ball> q = new LinkedList<Ball>();
		int[] ret = new int[4];
		
		switch(c) {
		
		case 0: // left
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(map[i][j].equalsIgnoreCase("R") || map[i][j].equalsIgnoreCase("B")) {
						Ball ball = new Ball();
						ball.color = map[i][j];
						ball.x = j;
						ball.y = i;
						
						q.add(ball);
						
						map[i][j] = ".";
						
					}
				}
				
				while(!q.isEmpty()) {
					Ball b = q.poll();
					
					int idx = b.x;
					boolean isGoal = false;
					for(int k=b.x;k>=1;k--) {
						if(map[i][k].equalsIgnoreCase(".") || map[i][k].equalsIgnoreCase("V")) {
							idx= k;
							map[i][k] = "V";
						}else if(map[i][k].equalsIgnoreCase("O") || map[i][k].equalsIgnoreCase("G")) {
							if(b.color.equalsIgnoreCase("R")) {
								map[i][k] = "G";
							}else if(b.color.equalsIgnoreCase("B")) {
								map[i][k] = "F";
							}
							
							isGoal = true;
							
							break;
						}else {
							break;
						}
					}
					
					if(!isGoal) {
						map[i][idx] = b.color;
						
						if(b.color.equalsIgnoreCase("R")) {
							ret[Y] = i;
							ret[X] = idx;
							
						}else if(b.color.equalsIgnoreCase("B")) {
							ret[BY] = i;
							ret[BX] = idx;
						}
					}
					
					
				}
			}
			
			break;
			
			
		case 1: // right
			for(int i=1; i<=n; i++) {
				for(int j=m+1; j>=1; j--) {
					if(map[i][j].equalsIgnoreCase("R") || map[i][j].equalsIgnoreCase("B")) {
						Ball ball = new Ball();
						ball.color = map[i][j];
						ball.x = j;
						ball.y = i;
						
						q.add(ball);
						
						map[i][j] = ".";
						
					}
				}
				
				while(!q.isEmpty()) {
					Ball b = q.poll();
					
					int idx = b.x;
					boolean isGoal = false;
					
 					for(int k=b.x;k<=m;k++) {
						if(map[i][k].equalsIgnoreCase(".") || map[i][k].equalsIgnoreCase("V")) {
							idx= k;
							map[i][k] = "V";
						}else if(map[i][k].equalsIgnoreCase("O") || map[i][k].equalsIgnoreCase("G")) {
							if(b.color.equalsIgnoreCase("R")) {
								map[i][k] = "G";
							}else if(b.color.equalsIgnoreCase("B")) {
								map[i][k] = "F";
							}
							isGoal = true;
							break;
						}else {
							break;
						}
					}
					
 					if(!isGoal ) {
						map[i][idx] = b.color; 
						
						if(b.color.equalsIgnoreCase("R")) {
							ret[Y] = i;
							ret[X] = idx;
							
						}else if(b.color.equalsIgnoreCase("B")) {
							ret[BY] = i;
							ret[BX] = idx;
						}
 					}
				}
			}
			
			break;
			
		case 2: //up
			
			for(int i=1; i<=m; i++) {
				for(int j=1; j<=n; j++) {
					if(map[j][i].equalsIgnoreCase("R") || map[j][i].equalsIgnoreCase("B")) {
						Ball ball = new Ball();
						ball.color = map[j][i];
						ball.x = i;
						ball.y = j;
						
						q.add(ball);
						
						map[j][i] = ".";
						
					}
				}
				
				while(!q.isEmpty()) {
					Ball b = q.poll();
					
					int idx = b.y;
					boolean isGoal = false;
					
					for(int k=b.y;k>=1;k--) {
						if(map[k][i].equalsIgnoreCase(".")|| map[k][i].equalsIgnoreCase("V")) {
							idx= k;
							map[k][i] = "V";
						}else if(map[k][i].equalsIgnoreCase("O") || map[k][i].equalsIgnoreCase("G")) {
							if(b.color.equalsIgnoreCase("R")) {
								map[k][i] = "G";
							}else if(b.color.equalsIgnoreCase("B")) {
								map[k][i] = "F";
							}
							
							isGoal = true;
							break;
						}else {
							break;
						}
					}
					
					if(!isGoal) {
						map[idx][i] = b.color; 
						
						if(b.color.equalsIgnoreCase("R")) {
							ret[Y] = idx;
							ret[X] = i;
							
						}else if(b.color.equalsIgnoreCase("B")) {
							ret[BY] = idx;
							ret[BX] = i;
						}
					}
				}
			}
			
			
			break;
			
		case 3: // down
			for(int i=1; i<=m; i++) {
				for(int j=n+1; j>=1; j--) {
					if(map[j][i].equalsIgnoreCase("R") || map[j][i].equalsIgnoreCase("B")) {
						Ball ball = new Ball();
						ball.color = map[j][i];
						ball.x = i;
						ball.y = j;
						
						q.add(ball);
						
						map[j][i] = ".";
						
					}
				}
				
				while(!q.isEmpty()) {
					Ball b = q.poll();
					
					int idx = b.y;
					boolean isGoal = false;
					
					for(int k=b.y;k<=m;k++) {
						if(map[k][i].equalsIgnoreCase(".")|| map[k][i].equalsIgnoreCase("V")) {
							idx= k;
							map[k][i] = "V";
						}else if(map[k][i].equalsIgnoreCase("O") || map[k][i].equalsIgnoreCase("G")) {
							if(b.color.equalsIgnoreCase("R")) {
								map[k][i] = "G";
							}else if(b.color.equalsIgnoreCase("B")) {
								map[k][i] = "F";
							}
							
							isGoal = true;
							break;
						}else {
							break;
						}
					}
					
					if(!isGoal) {
						map[idx][i] = b.color;
						
						if(b.color.equalsIgnoreCase("R")) {
							ret[Y] = idx;
							ret[X] = i;
						}else if(b.color.equalsIgnoreCase("B")) {
							ret[BY] = idx;
							ret[BX] = i;
						}
					}
				}
			}
			
			break;
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
	
	static void dfs(int depth, int x, int y, int bx, int by) {
		
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
				
				if(map[ny][nx].equalsIgnoreCase(".") || map[ny][nx].equalsIgnoreCase("O") || map[ny][nx].equalsIgnoreCase("B") || map[bny][bnx].equalsIgnoreCase(".") || map[bny][bnx].equalsIgnoreCase("R")) {
				
					String[][] tmap = new String[n+2][m+2];
					
					int si = 0;
					for(String[] s : map) {
						System.arraycopy(s, 0, tmap[si++], 0, map.length);
					}
					
					int[] k = move(i);
					
					dfs(depth+1, k[X], k[Y], k[BX], k[BY]);
					
					si=0;
					for(String[] s : tmap) {
						System.arraycopy(s, 0, map[si++], 0, map.length);
					}
				}
				
		}
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
		
		dfs(0, r[X], r[Y], b[X], b[Y]);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
		//dfs(0);
	}
}
