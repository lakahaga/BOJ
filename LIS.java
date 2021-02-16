package boj_git;

import java.io.*;
import java.util.*;

public class LIS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 BufferedReader br=new BufferedReader (new FileReader("input.txt"));
		 int n=Integer.parseInt(br.readLine());
		 int[] nums=new int[n+1];
		 StringTokenizer st=new StringTokenizer(br.readLine());
		 for(int i=1;i<=n;i++) nums[i]=Integer.parseInt(st.nextToken());
		
	        if(n==1) System.out.println("1");
	        else{
	            int[] dp=new int[n+1];
	            int ans=0;
	            //dp[i]=length of LIS ends with i-th num
	            int temp;
	            for(int i=1;i<=n;i++) dp[i]=1;
	            for(int i=1;i<=n;i++) {
	            	for(int j=1;j<i;j++) {
	            		if(nums[i]>nums[j] && dp[i]<dp[j]+1) {
	            			dp[i]=dp[j]+1;
	            		}
	            	}
	            }
	            for(int i=1;i<=n;i++) if(ans<dp[i]) ans=dp[i];
	            for(int i=1;i<=n;i++) System.out.print(dp[i]+" ");
	            System.out.println();
	            System.out.println(String.valueOf(ans));
	        }
	        
	       
	}

}
