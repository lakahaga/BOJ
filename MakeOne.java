package boj_git;


import java.io.*;


public class  MakeOne{
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter (new OutputStreamWriter(System.out));
        int x=Integer.parseInt(br.readLine());
        if(x==1) bw.write("0");
        else if(x==2||x==3) bw.write("1");
        else{
            int[] dp=new int[x+1];
            dp[1]=0;
            dp[2]=1;
            dp[3]=1;
            for(int i=4;i<=x;i++){
            //dp채우기
            //min value!!!!!!!!!!
            if(i%6==0) dp[i]=Math.min(Math.min(dp[i/2],dp[i/3]),dp[i-1])+1;
            else if(i%2==0) dp[i]=Math.min(dp[i/2],dp[i-1])+1;
            else if(i%3==0) dp[i]=Math.min(dp[i/3],dp[i-1])+1;
            else dp[i]=dp[i-1]+1;
            }
            bw.write(String.valueOf(dp[x]));
        }
        br.close();
        bw.close();
    }
}