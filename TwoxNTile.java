package boj_git;


import java.io.*;
import java.util.*;

public class TwoxNTile {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        if(n==1) bw.write("1");
        else if(n==2) bw.write("2");
        else{
            int[] dp=new int[n+1];
            dp[1]=1;dp[2]=2;
            for(int i=3;i<=n;i++){
                dp[i]=(dp[i-1]+dp[i-2])%10007;
            }
            bw.write(String.valueOf(dp[n]));
        }
        br.close();
        bw.close();
    }
}