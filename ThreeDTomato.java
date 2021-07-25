package boj_git;

import java.io.*;
import java.util.*;

class vector{
	private int depth;
	private int height;
	private int width;
	public vector(int i, int j, int k) {
		this.depth=i; this.height=j; this.width=k;
	}
	public int getI() {return this.depth;}
	public int getJ() {return this.height;}
	public int getK() {return this.width;}
}
public class ThreeDTomato {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int n,m,h;
		StringTokenizer st=new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		int[][][] tomato=new int[h][n][m];
		int i,j,k;
		for(i=0;i<h;i++) {
			for(j=0;j<n;j++) {
				st=new StringTokenizer(br.readLine());
				for(k=0;k<m;k++) tomato[i][j][k]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=howLong(tomato);
		bw.write(String.valueOf(cnt));
		br.close(); bw.close();
	}
	public static int howLong(int[][][] tomato) {
		int max=0;
		int h=tomato.length; int n=tomato[0].length; int m=tomato[0][0].length;
		int[] dx= {-1,1, 0,0,0,0}; int[] dy= {0,0,-1,1,0,0}; int[] dz= {0,0,0,0,-1,1};
		Queue<vector> que=new LinkedList<vector>();
		int i,j,k;
		boolean flag=false;
		for( i=0;i<h;i++) {
			for(j=0;j<n;j++) {
				for(k=0;k<m;k++) {
					if(tomato[i][j][k]==1) que.add(new vector(i,j,k));
					else flag=true;
				}
			}
		}
		if(flag) {
			vector tmp;
			int newI, newJ, newK;
			while(!que.isEmpty()) {
				tmp=que.poll();
				i=tmp.getI(); j=tmp.getJ(); k=tmp.getK();
				for(int d=0;d<6;d++) {
					newI=i+dz[d]; newJ=j+dy[d]; newK=k+dx[d];
					if(newI>=0 && newI<h && newJ>=0 && newJ<n && newK>=0 && newK<m) {
						if(tomato[newI][newJ][newK]==0) {
							tomato[newI][newJ][newK]=tomato[i][j][k]+1;
							que.add(new vector(newI, newJ, newK));
						}
					}
				}
			}
			for( i=0;i<h;i++) {
				for(j=0;j<n;j++) {
					for(k=0;k<m;k++) {
						if(tomato[i][j][k]==0) {max=-1;break;}
						if(tomato[i][j][k]>max) max=tomato[i][j][k];
					}
					if(max==-1) break;
				}
				if(max==-1) break;
			}
			if(max>-1) max--;
		}
		else max=0;
		return max;
	}
}
