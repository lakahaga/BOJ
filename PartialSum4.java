package boj_git;


import java.util.*;
import java.io.*; 

public class PartialSum4 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str;
		str=br.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		str=br.readLine().split(" ");
		int[] num=new int[n];
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(str[i]);
		}
		int[][] sumLoc=new int[2][m];
		for(int i=0;i<m;i++) {
			str=br.readLine().split(" ");
			sumLoc[0][i]=Integer.parseInt(str[0])-1;
			sumLoc[1][i]=Integer.parseInt(str[1])-1;
		}
		int[] sumD=new int[n];
		sumD[0]=num[0];
		for(int i=1;i<n;i++) {
			sumD[i]=num[i]+sumD[i-1];
		}
		for(int k=0;k<m;k++) {
			int ans;
            int i=sumLoc[0][k];
            int j=sumLoc[1][k];
            if(i==0){
                ans=sumD[j];
            }
            else{
                ans=sumD[j]-sumD[i-1];
            }
            bw.write(String.valueOf(ans)+"\n");
		}
		br.close();
        bw.close();
	}

}

