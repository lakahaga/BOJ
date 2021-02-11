package samsung08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IntegerTriangle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader (new FileReader ("input.txt"));
		BufferedWriter bw= new BufferedWriter (new FileWriter("output.txt"));
		
		int n=Integer.parseInt(br.readLine());
		int[][] tri=new int[n][n];
		String[] str;
		for (int i=0;i<n;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<str.length;j++) {
				tri[i][j]=Integer.parseInt(str[j]);
			}
		}
		br.close();
		int[][] DP=new int[n][n];
		DP[0][0]=tri[0][0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					DP[i][j]=DP[i-1][j]+tri[i][j];
				}
				else {
					DP[i][j]=Math.max(DP[i-1][j-1],DP[i-1][j])+tri[i][j];
				}
				
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(DP[i][j]+" ");
			}
			System.out.println();
		}
		int ans=DP[n-1][0];
		for(int i=0;i<n;i++) {
			if(ans<DP[n-1][i]) ans=DP[n-1][i];
		}
		bw.write(String.valueOf(ans));
		bw.close();
	}

}
