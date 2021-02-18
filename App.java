package boj_git;

import java.io.*;
import java.util.*;

public class App {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		BufferedWriter bw=new BufferedWriter (new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[] app=new int[n];
		int[] cost=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {app[i]=Integer.parseInt(st.nextToken());}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {cost[i]=Integer.parseInt(st.nextToken());}
		//memory [i]= i개 프로그램을 비활성화하는 
		int[][]dp=new int[n][100001];
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int cst=cost[i];
			int mem=app[i];
			for(int j=0;j<=100000;j++) {
				if(i==0) 
				{
					if(j>=cst) dp[i][j]=mem;
				}
				else {
					if(j>=cst) dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cst]+mem);
					else dp[i][j]=dp[i-1][j];
				}
				
				if(dp[i][j]>=m) ans=Math.min(ans,j);
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

}
