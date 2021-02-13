package boj_git;


import java.io.*;
import java.util.*;

public class Sticker {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter (new OutputStreamWriter(System.out));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			int[][] table=new int[2][n];
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) table[0][j]=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) table[1][j]=Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(MaxScore(table,n))+"\n");
			
		}
		br.close();
		bw.close();
	}
	public static int MaxScore(int[][]table,int n) {
		int ans=0;
		if(n==1) ans=Math.max(table[0][0],table[1][0]);
		else {
			int[][] dp=new int[2][n];
			dp[0][0]=table[0][0];
			dp[1][0]=table[1][0];
			dp[0][1]=dp[1][0]+table[0][1];
			dp[1][1]=dp[0][0]+table[1][1];
			for(int i=2;i<n;i++) {
				dp[0][i]=Math.max(dp[1][i-1],dp[1][i-2])+table[0][i];
				dp[1][i]=Math.max(dp[0][i-1], dp[0][i-2])+table[1][i];
			}
			
			ans=Math.max(dp[0][n-1], dp[1][n-1]);
		}
		return ans;
	}

	
}
