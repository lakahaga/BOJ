package boj_git;

import java.io.*;
import java.util.*;

public class StartAndLink {
	private static int[][] arr;
	private static int n;
	private static int[] isStart;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		int j=0;
		for (int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			j=0;
			while(st.hasMoreTokens()) {
				arr[i][j]=Integer.parseInt(st.nextToken()); j++;
			}
		}
		isStart=new int[n/2];
		isStart[0]=1;
		func(0);
		int min=Integer.MAX_VALUE;
		for(Integer i:diffList) {
			if(i<min) min=i;
		}
		bw.write(String.valueOf(min));
		br.close();bw.close();
	}
	public static void func(int cnt) {
		if(cnt==(n/2-1)) {
			diff();
		}
		else {
			int i=isStart[cnt]+1;
			for(;i<=n;i++) {
				isStart[cnt+1]=i;
				func(cnt+1);
			}
		}
	}

	private static ArrayList<Integer> diffList=new ArrayList<>();
	public static void diff() {
		boolean[] start=new boolean[n];
		int idx;
		for (int i=0;i<isStart.length;i++) {
			idx=isStart[i];
			start[idx-1]=true;
		}
		boolean whichTeam;//ture if start, false if link
		int s=0; int l=0;
		for (int i=0;i<n;i++) {
			whichTeam=start[i];
			for(int j=0;j<n;j++) {
				if(whichTeam==start[j] && i!=j) {
					if(whichTeam) s+=arr[i][j];
					else l+=arr[i][j];
				}
			}
		}
		diffList.add(Math.abs(s-l));
		
	}
}
