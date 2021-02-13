package boj_git;

import java.io.*;


public class PinaryNumber {

	public static void main(String[] args)throws Exception  {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		
		if(n==1||n==2) bw.write("1");
			
		else {
			//n-1 짜리 이진수가 몇개인지 먼저 구한다.(11제외) 
			//0-th row -> binary number starting with 0
			//1-th row -> binary number starting with 1 
			//pinary row 
			
			/*int[][] dp=new int[2][n+1];
			dp[0][1]=1;dp[1][1]=1;
			for(int i=2;i<n;i++) {
				dp[0][i]=dp[0][i-1]+dp[1][i-1];
				dp[1][i]=dp[0][i-1];
			}*/
			//-> fibonacci!!!!!!
			long[] dp=new long[n+1];
			dp[1]=1;dp[2]=1;
			for(int i=3;i<=n;i++) dp[i]=dp[i-1]+dp[i-2];
			bw.write(String.valueOf(dp[n]));
			
			
			//bw.write(String.valueOf(dp[0][n-1]));
		}
		//br.close();
		//bw.close(); 
	}

}
