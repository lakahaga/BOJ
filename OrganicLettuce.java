package boj_git;

import java.util.*;
import java.io.*;

public class OrganicLettuce {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		int n,m,k,x,y; StringTokenizer st;
		int[][] lettuce;
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			m=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			lettuce=new int[n][m];
			for(int i=0;i<k;i++) {
				st=new StringTokenizer(br.readLine());
				x=Integer.parseInt(st.nextToken());
				y=Integer.parseInt(st.nextToken());
				lettuce[y][x]=1;
			}
			int cnt=cntConnected(lettuce);
			bw.write(String.valueOf(cnt)+"\n");
		}
		br.close(); bw.close();
	}
	public static int cntConnected(int[][] lettuce) {
		int cnt=0; int n=lettuce.length; int m=lettuce[0].length;
		boolean visited[][]=new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(lettuce[i][j]==1 && !visited[i][j]) {
					cnt++;
					dfs(i,j,visited,lettuce);
					
				}
			}
		}
		
		return cnt;
	}
	public static void dfs(int i, int j, boolean[][] visited,int[][] lettuce) {
		visited[i][j]=true;
		int[] dx= {-1,1,0,0}; int[] dy= {0,0,-1,1};
		int newX, newY;
		int n=visited.length; int m=visited[0].length;
		for(int d=0; d<4;d++) {
			newX=j+dx[d]; newY=i+dy[d];
			if(newX>=0 && newX<m && newY>=0 && newY<n) {
				if(!visited[newY][newX] && lettuce[newY][newX]==1) {
					visited[newY][newX]=true;
					dfs(newY, newX, visited,lettuce);
				}
			}
		}
	}
}
