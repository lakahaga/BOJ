package boj_git;

import java.io.*;
import java.util.*;

public class AscendingNumber {
	private final static int MOD=10007;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
	
		if(n==1) {
			//bw.write("10");
			System.out.println(10);
		}
		else {
			int[][] dp=new int[n][10];
			
			//initialization
			for(int i=0;i<=9;i++) dp[0][i]=1;
		
			for(int i=1;i<n;i++) {
				for(int j=0;j<10;j++) {
					for(int k=j;k<10;k++) {
						dp[i][j]+=dp[i-1][k];
						dp[i][j]%=MOD;
					}
				}
			}
            int ans=0;
            for(int i=0;i<10;i++) {ans+=dp[n-1][i];ans%=MOD;}
			bw.write(String.valueOf(ans));
		}
		br.close();
		bw.close();
	}

}
