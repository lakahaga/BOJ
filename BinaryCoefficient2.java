package samgsung05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BinaryCoefficient2 {
	final static int MOD=10007;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line =br.readLine().split(" ");
		int N=Integer.parseInt(line[0]);
		int K=Integer.parseInt(line[1]);
		br.close();
		int[][] combi=new int[N+1][N+1];
		combi[0][0]=1;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=i&&j>=0;j++) {
				if(j==0||i==j) combi[i][j]=1;
				else{
					combi[i][j]=(combi[i-1][j-1]+combi[i-1][j])%MOD;
				}
			}
		}
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				System.out.print(combi[i][j]+ " ");
			}
			System.out.println();
		}
		bw.write(String.valueOf(combi[N][K]));
		bw.close();
		
		
	}	

}
