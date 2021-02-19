package boj_git;

import java.io.*;
import java.util.*;

public class MaxSumSubsequence {
	private static int[] num=new int [1001];
    private static int[] dp=new int[1001];
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) num[i]=Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++) dp[i]=num[i];//initialization
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if(num[i]>num[j] && dp[i]<dp[j]+num[i]){
                    dp[i]=dp[j]+num[i];
                }
            }
        }
        for(int i=1;i<=n;i++) if(ans<dp[i]) ans=dp[i];
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

}
