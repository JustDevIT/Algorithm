import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static LinkedList<Integer> ls[] = new LinkedList[2001];
	static LinkedList<Integer> color = new LinkedList();
	static int[] vv = new int[2001];  
	
	static void arrow() {
		
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		for(int i =0; i<n; i++) {
			int s = sc.nextInt();
			int v = sc.nextInt();
			
			if(ls[v]==null) {
				ls[v] = new LinkedList();
			}
			
			ls[v].add(s);
			
			Collections.sort(ls[v]);
			
			if(vv[v] != 1)
			{
				color.add(v);
				
				vv[v] = 1;
			}
			
			
			
		}
		
		arrow();
		
	}
}

