import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		//System.setIn(new FileInputStream("C://Users//영훈//git//Algorithm//BaekJooN//TestCase//Sample.txt"));
		Scanner sc = new Scanner(System.in);
				
		/*
		 * 		1 2 3 4 5 6 7

				d   1    2    3    4
				t   3    5    1    
				p   10  20   10
				
				
				k[n] = k(d-t)
				
				
				V[k] = 1일
				
				
				1일 -> 4, 5 ,6 ,7
				2일 -> x
				3일 -> 4, 5, 6, 7
				
				d  1      2      3
				t  3      5      1
				p  10     20
				
				n = 현 위치
				
				k[n] = max(k[n-1] + timetable[n-d][2]), timetable[n][2] + timetable[n-t][2]!=null)
				
				work[0][0] = d
				work[0][1] = t
				work[0][2] = p
				
				1
				3
				
				10
		 */
		
	}
}