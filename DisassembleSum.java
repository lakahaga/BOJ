package boj_git;

import java.io.*;
import java.util.*;

public class DisassembleSum {
	private static long[][] dp=new long[201][201];
	private static int mod =1000000000;
	public static void main(String[] args)throws Exception  {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		for(int i=0;i<=n;i++) dp[i][1]=1;//initialize
		for(int j=2;j<=k;j++) {
			for(int i=0;i<=n;i++) {
				for(int m=0;m<=i;m++) {
					dp[i][j]+=dp[i-m][j-1];
					dp[i][j]%=mod;
				}
			}
		}
		bw.write(String.valueOf(dp[n][k]));
		br.close();
		bw.close();
	}
}
