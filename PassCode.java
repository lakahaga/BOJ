package boj_git;
import java.io.*;

public class PassCode{
    private static int[] pw=new int[5001];
	private static int[] dp=new int[5001];
	private static int MOD= 1000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String str=br.readLine();
        int n=str.length();
        for(int i=0;i<n;i++){
            pw[i+1]=str.charAt(i)-'0';
        }
        if(n==0) bw.write("0");
        else if(n==1 &&pw[n]!=0) bw.write("1");
        else if(n==1 && pw[n]==0) bw.write("0");
        else if(pw[1]==0) bw.write("0");
        else{
            dp[1]=1;
            if(pw[1]==1) {if(pw[2]==0) dp[2]=1; else dp[2]=2;}
            else if(pw[1]==2) {
                if(pw[2]==0) dp[2]=1;
                else if(pw[2]<=6) dp[2]=2;
                else dp[2]=1;
            }
            else {
                if(pw[2]==0) dp[n]=0;
                else dp[2]=1;
            }
            for(int i=3;i<=n;i++){
                if(pw[i]==0){
                    if(pw[i-1]==1 || pw[i-1]==2){
                        dp[i-1]=dp[i-2];
                        dp[i]=dp[i-1];
                        dp[i]%=MOD;
                    }
                    else {dp[n]=0;break;}
                }
                else {
                    dp[i]+=dp[i-1];dp[i]%=MOD;
                    if(pw[i-1]==1) {dp[i]+=dp[i-2];dp[i]%=MOD;}
                    else if(pw[i-1]==2) if(pw[i]<=6) {dp[i]+=dp[i-2]; dp[i]%=MOD;}
                }
            }
            bw.write(String.valueOf(dp[n]%MOD));
        }
        br.close();
        bw.close();
    }
}