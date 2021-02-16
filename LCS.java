package boj_git;

import java.io.*;


public class LCS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		BufferedWriter bw=new BufferedWriter (new OutputStreamWriter( System.out));
		String S=br.readLine();
		String T=br.readLine();
	
		char[] s=S.toCharArray();
		char[] t=T.toCharArray();
		int[][] dp=new int[s.length][t.length];
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<t.length;j++) {
				if(s[i]==t[j]) {
					if(i==0 || j==0) dp[i][j]=1;
					else dp[i][j]=dp[i-1][j-1]+1;
				}
			}
		}
		int ans=0;
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<t.length;j++) {
				if(ans<dp[i][j]) ans=dp[i][j];
			}
			
		}
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

}
