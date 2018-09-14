import java.io.FileInputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static Vector<Long> ls[] = new Vector[100001];
	static Vector<Integer> vv = new Vector<Integer>();
	
	static long answer = 0;
	
	static Long dis(long x, long y) {
		
		return Math.abs(x-y);
	}
	
	static void arrow(int n) {
	//	long start = System.currentTimeMillis(); //시작하는 시점 계산

		
		for (int i : vv) {

			//System.out.println( "실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0); //실행 시간 계산 및 출력
			
			Vector<Long> s = ls[i];
			
			
			if(s==null || s.size() < 2) {
				continue;
			}
			
			for(int j=0; j < s.size(); j++) {
				
				//0 1 2 5 6
				if(j==0) {
					answer += dis(s.get(j), s.get(j+1));
				}else if(j == (s.size()-1)) {
					answer += dis(s.get(j-1), s.get(j));
				}else {
					answer += Math.min(dis(s.get(j), s.get(j-1)), dis(s.get(j), s.get(j+1)) );
				}
			}
			
			//System.out.println( "실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0); //실행 시간 계산 및 출력
		}

		System.out.println(answer);
		//System.out.println( "실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0); //실행 시간 계산 및 출력


		
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		for(int i=0; i<n; i++) {
			
			long s = sc.nextLong();
			int v = sc.nextInt();
			
			if(ls[v]==null) {
				ls[v] = new Vector<Long>();
				vv.add(v);
			}
			
			ls[v].add(s);
			
			
			
		}
		
		for (int i : vv) {
			Collections.sort(ls[i]);
		}
		
		arrow(n);
		
	}
}