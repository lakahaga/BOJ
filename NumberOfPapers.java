package boj_git;

import java.io.*;
import java.util.*;

public class NumberOfPapers {
	private static int[][] arr=new int[2200][2200];
	private static int[] ans=new int[3];// ans[0]= number of -1 , ans[1]= number of 0s, ans[2]=number of 1s
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<3;i++) ans[i]=0;
		for (int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+ " " );
			}
			System.out.println();
		}
		divide(0,0,n);
		for(int i=0;i<3;i++) {
			bw.write(String.valueOf(ans[i])+"\n");
		}
		br.close(); bw.close();
	}
	public static void divide(int x, int y, int n) {
		int tmp=arr[x][y];
		int rangeX=x+n; int rangeY=y+n;
		System.out.println(x+" " +y);
		boolean flag=true;
		for(int i=x;i<rangeX;i++) {
			for (int j=y;j<rangeY;j++) {
				if(tmp!=arr[i][j]) { flag=false; break;}
			}
		}
		int cut;
		if(!flag && n>1) {
			cut=n/3;
			if(cut>0) {
				for(int i=x;i<rangeX;i+=cut) {
					for(int j=y;j<rangeY;j+=cut) {
						 divide(i,j,cut);
					}
				}
			}
		}
		else {
			//System.out.println(x+" "+y+" "+tmp);
			if(tmp==-1) ans[0]++;
			else if(tmp==0) ans[1]++;
			else if(tmp==1) ans[2]++;
		}
	}
}
