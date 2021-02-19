package boj_git;

import java.io.*;


public class SquareSum {
	
	private static int[] dp=new int[100001];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n=43;
		if(isSquare(n)) System.out.println("1");
        else{
        	for(int i=1;i<=n;i++) dp[i]=i;//initialize
            for(int i=1;i<=n;i++) {
            	if(isSquare(i)) dp[i]=1;
            	else {
            		for(int j=1;j*j<=n;j++) {
            			if(i>j*j) dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            		}
            	}
            }
            for(int i=1;i<=n;i++) System.out.println(i+" " +dp[i]);
        }
	}
	public static boolean isSquare(int n) {
		int x=(int)Math.sqrt(n);
		if(Math.pow(x, 2)==n) return true;
		else return false;
	}
}	
