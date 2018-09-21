import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int k;
	static int[] happy, need; 
	static int[][] cache;
	
	static int solve(int capactiy, int tonosi, int item) {
		
		System.out.println(" 1 : " + item + " : " + capactiy + " : " + tonosi);
		
		if(item==k+1) {
			return 0;
		}
		
		int ret = cache[tonosi][item];
		
		if(ret != -1) {
			return ret;
		}
		
		// 과목 선택 안함
		ret = solve(capactiy, tonosi, item+1);
		
		cache[tonosi][item] = ret;
		System.out.println(" 2 : " + item + " : " + capactiy + " : " + tonosi);
		
		// 과목 선택한 경우
		if(capactiy <= m)
		{
 			ret = Math.max(ret, solve(capactiy + need[item], tonosi+happy[item], item+1));
		}
	
		return ret;
		
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		System.setIn(new FileInputStream("C://Users//영훈//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		k = sc.nextInt();
		
		cache = new int[1000][1000];
		
		happy = new int[1000];
		need = new int[1000];
				
		
		for(int[] t : cache) {
			Arrays.fill(t, -1);
		}
		
		for(int i=1; i<=k; i++) {
			need[i] = sc.nextInt();
			happy[i] = sc.nextInt();
		}
		
		
		System.out.println(solve(0, 0, 1));
	}
		
}