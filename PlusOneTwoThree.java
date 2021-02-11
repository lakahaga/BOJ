package boj_git;

import java.io.*;

public class PlusOneTwoThree{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter( new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        int n;
        for(int i=0;i<t;i++){
            n=Integer.parseInt(br.readLine());
            bw.write(String.valueOf(adding(n))+"\n");
        }
        br.close();
        bw.close();
    }
    public static int adding(int n){
        int ans;
        if(n==1) ans=1;
        else if(n==2) ans=2;
        else if(n==3) ans=4;
        else{
            int[] dp=new int[n+1];
            dp[1]=1;dp[2]=2;dp[3]=4;
            for(int i=4;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
            ans=dp[n];
        }
        return ans;
    }
}
