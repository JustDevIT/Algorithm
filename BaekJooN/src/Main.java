import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][][] dp= new int[101][100][2];
 
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		dp[1][0][1] = dp[1][0][0] = 1;
	 
	        
	        for (int k = 0; k < 100; k++) {
	        	 
	            for (int n = 2; n <= 100; n++) {
	                if (k == 0) {
	                    dp[n][k][1] = dp[n - 1][k][0];
	                } else {
	                    dp[n][k][1] = dp[n - 1][k][0] + dp[n - 1][k - 1][1];
	                }
	                
	                dp[n][k][0] = dp[n - 1][k][0] + dp[n - 1][k][1];
	            }
	     
	        }

	        int n = 3;
	        int k = 1;
	        System.out.println(dp[n][k][0] + dp[n][k][1]);
	        
	        n = 2;
	        k = 1;
	        System.out.println(dp[n][k][0] + dp[n][k][1]);


	}
	

}

