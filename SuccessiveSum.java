package boj_git;

import java.io.*;
import java.util.*;

public class SuccessiveSum {

	 private static int[] num=new int [100001];
	 private static int[] dp=new int[100001];
	 public static void main(String[] args) throws Exception {
	        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
	        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	        int n=Integer.parseInt(br.readLine());
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        for(int i=1;i<=n;i++) num[i]=Integer.parseInt(st.nextToken());
	        int ans=Integer.MIN_VALUE;
	        for(int i=1;i<=n;i++) {
	        	if(i==1) dp[i]=num[i];
	        	else dp[i]=Math.max(num[i], dp[i-1]+num[i]);
	        	if(ans<dp[i]) ans=dp[i];
	        }
	        bw.write(String.valueOf(ans));
	        br.close();
	        bw.close();
	    }

}
