package boj_git;

import java.io.*;
import java.util.*;

public class LongestBitonicSubSequence {
	private static int[] num=new int[1001];
    private static int[] dpI=new int[1001];
    private static int[] dpD=new int[1001];
    private static int[] dpB=new int[1001];
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter (new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) num[i]=Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++) {dpI[i]=1;dpD[i]=1;} //initialization
        //dpI 는 i-th num으로 끝나는 longest increasing array
        //dpD : longest decreasing array starts with i-th num
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++) {
                if(num[i]>num[j] && dpI[i]<dpI[j]+1){
                    dpI[i]=dpI[j]+1;
                }
            }
        }
        for(int i=n;i>0;i--){
            for(int j=n;j>i;j--){ //j=n !!!!!!!!!!!!
                if(num[i]>num[j] && dpD[i]<dpD[j]+1){
                    dpD[i]=dpD[j]+1;
                }
            }
        }
        for(int i=1;i<=n;i++) dpB[i]=dpI[i]+dpD[i]-1; //i==n or i==1 -> dpD or dpI =1 so, no need to seperate the case 
        int ans=0;
        for(int i=1;i<=n;i++) if(ans<dpB[i]) ans=dpB[i];
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

}
