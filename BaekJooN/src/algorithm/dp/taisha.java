package algorithm.dp;

import java.io.FileInputStream;
import java.util.Scanner;

public class taisha {
	static int m;
	static int map[][];
	static int k[][];
	static int ret;
	static int max;
	
	static void dfs(int day, int sum){
	    
		System.out.println(day + " " + sum + " ");
		if(day == m+1){
	    	ret = Math.max(ret, sum);
	        return;
	    }
	    //상담을 안하는 경우
	    dfs(day+1, sum);
	    
	    //상담을 할 수 있을 경우는 상담을 한다.
	    if(day+map[day][1] <= m+1) {
	        dfs(day+map[day][1], sum+map[day][2]);
	    }
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		System.setIn(new FileInputStream("C://Users//영훈//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		m = sc.nextInt();
		
		map = new int[m+1][3];
		k = new int[m+1][2];
		
		for(int i=1; i<=m;i++) {
			map[i][0] = i; 
			map[i][1] = sc.nextInt();
			
			int t = sc.nextInt();
			
			if((i-1) + map[i][1] > m) {
				map[i][2] = 0;
			}else {
				map[i][2] = t;
			}
		}
		
		dfs(1, 0);
		
		System.out.println(ret);
	
	}
}