package boj_git;

import java.io.*;
import java.util.*;

public class RepeatedPermu {
	private static int[] visited=new int[3000001];
	public static void dfs(int i,int p) {
		visited[i]++;
		if(visited[i]==2) return;
		int num=i;
		int sum=0;
		while(num>0) {
			sum+=Math.pow(num%10,p);
			num/=10;
		}
		dfs(sum,p);
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new FileReader("input.txt"));
		BufferedWriter bw=new BufferedWriter (new FileWriter("output.txt")); 
		StringTokenizer st=new StringTokenizer (br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int p=Integer.parseInt(st.nextToken());
		dfs(a,p);int res=0;
		for(int i=1;i<visited.length;i++) {
			if(visited[i]==1) res++;
		}
		System.out.println(res);
		br.close();
		bw.close();
	}

}
