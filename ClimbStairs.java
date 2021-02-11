package boj_git;


import java.util.*;
import java.io.*;

public class ClimbStairs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter (new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int[] stair=new int[n+1];
		for(int i=1;i<=n;i++) stair[i]=Integer.parseInt(br.readLine());
		int[][] dp= new int[2][n+1];
		//0 -> jump 1, 1->jump2
		dp[0][1]=dp[1][1]=stair[1];
		for(int i=2;i<=n;i++) {
			dp[0][i]=dp[1][i-1]+stair[i];
			dp[1][i]=Math.max(dp[0][i-2], dp[1][i-2])+stair[i];
		}
		int ans=Math.max(dp[0][n],dp[1][n]);
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

}


