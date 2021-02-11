package samgsung05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BuildBridge {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw =new BufferedWriter(new FileWriter("output.txt"));
		
		int TestCase=Integer.parseInt(br.readLine());
		int[][] sites=new int [2][TestCase];//[0][i]==N , [1][i]=M
		String[] line;
		for(int i=0;i<TestCase;i++) {
			line=br.readLine().split(" ");
			sites[0][i]=Integer.parseInt(line[0]);
			sites[1][i]=Integer.parseInt(line[1]);
		}
		br.close();
		for(int i=0;i<TestCase;i++) {
			bw.write(String.valueOf(bc(sites[1][i],sites[0][i]))+"\n");
		}
		bw.close();
		
	}
	private static long[][] combi=new long[31][31];
	public static long bc(int n, int k) {
		for(int i=1;i<=n;i++) {
			combi[i][0]=1;
			combi[i][i]=1;
			for(int j=1;j<i;j++) {
				if(combi[i][j]!=0) continue;
				combi[i][j]=combi[i-1][j-1]+combi[i-1][j];
			}
		}
			
		return combi[n][k];
	}

}
