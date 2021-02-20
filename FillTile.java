package boj_git;

import java.io.*;

public class FillTile{
    private static int[] dp=new int[31];
    public static void main(String[] args) throws Exception {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
       int n=Integer.parseInt(br.readLine());
       if(n%2==0) {
    	   dp[0]=1;dp[2]=3;
    	   for(int i=4;i<=n;i+=2) {
    		   dp[i]=dp[i-2]*3;
    		   for(int j=4;j<=i;j+=2) dp[i]+=dp[i-j]*2;
    	   }
    	   bw.write(String.valueOf(dp[n]));
       }
       else bw.write("0");
       br.close();
       bw.close();
    }
}