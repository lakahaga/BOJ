package boj_git;

import java.io.*;
import java.util.*;

class pair{
	private int x;
	private int y;
	public pair(int x, int y) {
		this.x=x; this.y=y;
	}
	public int getX() {return this.x;}
	public int getY() {return this.y;}
}
public class Knight {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		int n,x,y,cnt;
		StringTokenizer st;
		pair src,dest;
		for(int t=0;t<T;t++) {
			n=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			src=new pair(x,y);
			st=new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			dest=new pair(x,y);
			cnt=cntSteps(src,dest,n);
			bw.write(String.valueOf(cnt)+"\n");
		}
		br.close(); bw.close();
	}
	public static int cntSteps(pair src, pair dest,int n) {
		int cnt=0;
		int[] dx= {2,1,-2,-1,2,1,-2,-1}; int[] dy= {1,2,1,2,-1,-2,-1,-2};
		int srcX=src.getX(); int srcY=src.getY(); 
		int destX=dest.getX(); int destY=dest.getY();
		Queue<pair> que=new LinkedList<pair>();
		//step을 기록하려면 배열이 필요함
		int[][] chess=new int[n][n];
		boolean[][] visited=new boolean[n][n];
		que.add(src); visited[srcY][srcX]=true;
		int x,y; pair tmp; int newX,newY;
		while(!que.isEmpty()) {
			tmp=que.poll();
			x=tmp.getX(); y=tmp.getY();
			if(x==destX && y==destY) break;
			else {
				for(int d=0;d<8;d++) {
					newX=x+dx[d]; newY=y+dy[d];
					if(newX>=0 && newX<n && newY>=0 && newY<n &&!visited[newY][newX]) {
						visited[newY][newX]=true;
						chess[newY][newX]=chess[y][x]+1;
						que.add(new pair(newX, newY));
					}
				}
			}
		}
		cnt=chess[destY][destX];
		return cnt;
	}

}
