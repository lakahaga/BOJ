package boj_git;

import java.util.*;
import java.io.*;

class pair{
	private int first;
	private int second;
	public pair(int x, int y) {
		this.first=x; this.second=y;
	}
	public int getX() {return this.first;}
	public int getY() {return this.second;}
}
public class Maze {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		char[][] maze=new char[n][m];
		for(int i=0;i<n;i++) {
			maze[i]=br.readLine().toCharArray();
		}
		//shortest path -> bfs
		bw.write(String.valueOf(bfs(maze)));
		
		br.close();
		bw.close();
	}
	public static int bfs(char[][] maze) {
		int cnt=0;
		int[] dx= {0, 1, 0, -1};
		int[] dy= {1,0,-1,0};
		int n=maze.length;
		int m=maze[0].length;
		boolean[][] visited=new boolean[n][m];
		Queue<pair> que=new LinkedList<pair>();
		que.add(new pair(0,0)); 
		pair tmp; int i,j;
		int[][] count=new int[n][m];
		count[0][0]=1;
		while(!que.isEmpty()) {
			tmp=que.poll();
			i=tmp.getX(); j=tmp.getY();
			visited[i][j]=true;
			System.out.println(i+" "+j);
			if(i==n-1 && j==m-1) {break;}
			for(int d=0;d<4;d++) {
				int newI=i+dx[d]; int newJ=j+dy[d];
				if(newI>=0 && newI<n && newJ>=0 && newJ<m) {
					if(!visited[newI][newJ] && maze[newI][newJ]=='1' && count[newI][newJ]==0) {
						que.add(new pair(newI, newJ));
						count[newI][newJ]=count[i][j]+1;
					}
				}
			}
		}
		return count[n-1][m-1];
	}
}
