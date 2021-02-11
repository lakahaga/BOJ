package boj_git;


import java.io.*;
import java.util.*;

public class PartialSumFive {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader (System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str;
		str=br.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		int[][] num=new int[n][n];
		for(int i=0;i<n;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<n;j++) {num[i][j]=Integer.parseInt(str[j]);}
		}
		int [][] loc=new int[4][m];
		for(int i=0;i<m;i++) {
			str=br.readLine().split(" ");
			loc[0][i]=Integer.parseInt(str[0])-1;
			loc[1][i]=Integer.parseInt(str[1])-1;
			loc[2][i]=Integer.parseInt(str[2])-1;
			loc[3][i]=Integer.parseInt(str[3])-1;
		}
		int[][] sumDP=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0) {
					if(j==0) sumDP[i][j]=num[i][j];
					else sumDP[i][j]=num[i][j]+sumDP[i][j-1];
				}
				else {
					if(j==0) sumDP[i][j]=num[i][j]+sumDP[i-1][j];
					else{
						sumDP[i][j]=num[i][j]+sumDP[i-1][j]+sumDP[i][j-1]-sumDP[i-1][j-1];
					}
				}
			}
		}
		for(int i=0;i<m;i++) {
			int x1=loc[0][i];
			int y1=loc[1][i];
			int x2=loc[2][i];
			int y2=loc[3][i];
			int ans;
			if(x1==0&&y1==0) ans=sumDP[x2][y2];
			else if(x1==0) ans=sumDP[x2][y2]-sumDP[x2][y1-1];
			else if(y1==0) ans=sumDP[x2][y2]-sumDP[x1-1][y2];
			else ans=sumDP[x2][y2]-sumDP[x1-1][y2]-sumDP[x2][y1-1]+sumDP[x1-1][y1-1];
			bw.write(String.valueOf(ans)+"\n");
		}
		
		br.close();
		bw.close();
	}

}

