package mathBasic;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BreakEvenPoint {
	private static int mod=1000000000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	   
	       
	        int n=100;
	        int[][] dp=new int[n+1][10];
	        //ans=sum of n-th row  
	        for(int i=1;i<=n;i++){
	            for(int j=0;j<=9;j++){
	                if(i==1&&j==0) dp[i][0]=0;
	                else if(i==1) dp[i][j]=1;
	                else {
	                    if(j==0) dp[i][0]=dp[i-1][j+1]%mod;
	                    else if(j==9) dp[i][j]=dp[i-1][j-1]%mod;
	                    else dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%mod;
	                }
	            }
	        }
	        int ans=0;
	        for(int i=0;i<=9;i++) ans+=dp[n][i];
	        System.out.println(ans);
	      
	    
	    
        
	}

}
