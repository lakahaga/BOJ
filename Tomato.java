package boj_git;

import java.io.*;
import java.util.*;

class pair{
	private int first;
	private int second;
	public pair(int f, int s) {
		this.first=f; this.second=s;
	}
	public int getF() {return this.first;}
	public int getS() {return this.second;}
	public String toString() {return "("+this.first+", "+this.second+")";}
}
public class Tomato {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int m,n;//m=width, n=height
		StringTokenizer st=new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		int[][] tomato=new int[n][m];
		int i,j;
		for(i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(j=0;j<m;j++) {
				tomato[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	
		
		int max=HowLong(tomato);
		bw.write(String.valueOf(max));
		br.close();bw.close();
	}
	public static int HowLong(int[][] tomato) {
		int max=0;
		int n=tomato.length; int m=tomato[0].length;
		Queue<pair> que=new LinkedList<>();
		int[] dx= {-1, 1, 0,0};
		int[] dy= {0,0,-1,1};//left, right,up, down
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tomato[i][j]==1) que.add(new pair(i,j));
			}
		}
		pair tmp;
		int i,j;
		int newI, newJ;
		while(!que.isEmpty()) {
			tmp=que.poll();
			i=tmp.getF();j=tmp.getS();
			for(int d=0;d<4;d++) {
				newI=i+dx[d]; newJ=j+dy[d];
				if(newI>=0 && newI<n && newJ>=0 && newJ<m) {
					if(tomato[newI][newJ]==0) {
						tomato[newI][newJ]=tomato[i][j]+1;
						que.add(new pair(newI,newJ));
					}
				}
			}
			
		}
		for(i=0;i<n;i++) {
			for(j=0;j<m;j++) {
				if(tomato[i][j]==0) {
					max=-1;System.out.println(i+", "+j);
					break;
				}
				if(tomato[i][j]>max) {max=tomato[i][j];}
			}
			if(max==-1) break;
		}
		print(tomato);
		System.out.println(max);
		if(max!=-1) max-=1;
		return max;
	}
	public static void print(int[][] arr) {
		int n=arr.length; int m=arr[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

}