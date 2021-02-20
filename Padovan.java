package boj_git;

import java.io.*;

public class Padovan {
	 private static long[] dp=new long[101];
	    public static long MyPadovan(int n){
	        if(n==1||n==2||n==3) return 1;
	        dp[1]=1;dp[2]=1;dp[3]=1;
	        for(int i=4;i<=n;i++) dp[i]=dp[i-2]+dp[i-3];
	        return dp[n];
	    }
    
    public static void main(String[] args) throws Exception {
       BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter (new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int tmp=Integer.parseInt(br.readLine());
            bw.write(String.valueOf(MyPadovan(tmp))+"\n");
        }
        br.close();
        bw.close();
      
    }
    
}
