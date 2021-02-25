package boj_git;

import java.io.*;
import java.util.*;

public class ComplexNumbering {
	private static char[][] adj=new char[26][26];
	private static boolean[][] visited=new boolean[26][26];
	private static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			adj[i]=br.readLine().toCharArray();
		}
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j] && adj[i][j]=='1') {cnt=0;list.add(dfs(i,j));}
			}
		}
		Collections.sort(list);
		bw.write(String.valueOf(list.size())+"\n");
		for(Integer i:list) {
			bw.write(String.valueOf(i)+"\n");
		}
		br.close();
		bw.close();
	}
	public static int cnt;
	public static int dfs(int i,int j) {
		visited[i][j]=true; cnt++;
		if(i>=1) if(!visited[i-1][j] && adj[i-1][j]=='1') dfs(i-1,j);
		if(i<n-1) if(!visited[i+1][j] && adj[i+1][j]=='1') dfs(i+1,j);
		if(j>=1) if(!visited[i][j-1] && adj[i][j-1]=='1') dfs(i,j-1);
		if(j<n-1) if(!visited[i][j+1] &&adj[i][j+1]=='1') dfs(i,j+1);
		return cnt;
	}
}
