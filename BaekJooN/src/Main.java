import java.util.Scanner;

public class Main {

	public void bfs() {
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.tx"));
		Scanner sc = new Scanner(System.in);
		
		int mod = 1000000;
		int d[][] = new int[1001][3];

		int n=sc.nextInt();
		
		d[0][0] =1;
		
	    for (int i=1; i<=n; i++) {
	        d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
	        d[i][1] = d[i-1][0];
	        d[i][2] = d[i-1][1];
	        
	        for (int j=0; j<3; j++) {
	            d[i][j] %= mod;
	       }
	        
	    }
	    
	    int ans = 0;
	    
	    for (int i=0; i<3; i++) {
	        ans += d[n][i];
	        ans %= mod;
	    }
	    
	    for (int i=1; i<=n; i++) {
	        for (int j=0; j<3; j++) {
	            for (int k=0; k<3; k++) {
	                long temp = (long)d[i-1][j] * d[n-i][k];
	                ans += temp % mod;
	                ans %= mod;
	            }
	        }
	    }
		    
		    System.out.println(ans);
		}

}
