
import java.io.*;
import java.util.*;

public class PartialSUm{
    private static int[] num=new int[100001];
    private static int[] dp=new int[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) num[i]=Integer.parseInt(st.nextToken());
        int sum=0;int len=Integer.MAX_VALUE;
        dp[1]=num[1];dp[0]=0;
        for(int i=2;i<=n;i++) dp[i]=dp[i-1]+num[i];
        if(dp[n]<s) len=0;
        else{
            int start=1;int end=2;
            while(start<=n && end<=n && start<=end){
                sum=dp[end]-dp[start-1];
                if(sum<s) end++;
                else{
                    if(len>end-start+1){len=end-start+1;}
                    if(start==end) end++;
                    else start++;
                }
            }
        }
        bw.write(String.valueOf(len));
        br.close();
        bw.close();
    }
}
