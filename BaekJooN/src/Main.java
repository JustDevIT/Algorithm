import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	static int[] w;
	static int[] v;
	static int[][] d;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//ȸ��PC
		//System.setIn(new FileInputStream("D://Project/Algorithm/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		//����ũž
		//System.setIn(new FileInputStream("C://Algorithm/workspace/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		//��Ʈ��
		System.setIn(new FileInputStream("C://Algorithm/Test/Algorithm/BaekJooN/TestCase/Sample.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		//int C = sc.nextInt();
		
        //N+10 �� ���� ������ �������� + 5���� �� �迭 ������ �� �� �����Ƿ� �˳��� ����ش�. 
        w = new int[N+10];
        v = new int[N+10];
        d = new int[K+1][K+1];
        
        int max = 0;
        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        
        int free_space;
        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(w[i] <= j){
                    free_space = j-w[i];
                    d[i][j] = Math.max(d[i-1][j], v[i]+d[i-1][free_space]);
                }else{
                    d[i][j] = d[i-1][j];
                }
            }
        }
        System.out.println(d[N][K]);
    }
}

