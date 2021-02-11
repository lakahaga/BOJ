package samsung08;

import java.io.*;
import java.util.*;

public class BiggestSquare {

	public static void main(String[] args)throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str=br.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		char[][] arr= new char[n][m];
		for(int i=0;i<n;i++) {
			arr[i]=br.readLine().toCharArray();
		}
		int[][] dp=new int[n][m];
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='0') continue;
				else if(arr[i][j]=='1'){
					if(i==0||j==0) {
						dp[i][j]=1;
					}
					else {
						dp[i][j]=1+Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
					}
				}
				if(max<dp[i][j]) max=dp[i][j];
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) System.out.print(dp[i][j]+" ");
			System.out.println();
		}
		bw.write(String.valueOf(max*max));
		br.close();
		bw.close();
	}

}
