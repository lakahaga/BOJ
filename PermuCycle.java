package boj_git;

import java.io.*;
import java.util.*;

class Graph1{
	private int V;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public Graph1(int v) {
		this.V=v;
		adj=new LinkedList[v+1];
		for(int i=1;i<=v;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int u, int v) {
		//digraph
		adj[u].add(v);
	}
	public boolean CycleUtil(int i, boolean[] visited, boolean[] recStk) {
		if(recStk[i]) return true;
		if(visited[i]) return false;
		recStk[i]=true; visited[i]=true;
		List<Integer> children=adj[i];
		for(Integer c:children) {
			if(CycleUtil(c,visited,recStk)) return true;
		}
		recStk[i]=false;
		return false;
	}
	public int cntCycle() {
		int res=0;
		boolean[] visited=new boolean[this.V+1];
		boolean[] recStk=new boolean[this.V+1];
		for(int i=1;i<=this.V;i++) {
			if(!visited[i]) {
				if(CycleUtil(i,visited,recStk)) res++;
			}
		}
		return res;
	}
}
public class PermuCycle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new FileReader("input.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st;
		Graph1 g;
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			g=new Graph1(n);
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				g.addEdge(j, Integer.parseInt(st.nextToken()));
			}
			int res=g.cntCycle();
			bw.write(String.valueOf(res)+"\n");
			System.out.println();
		}
		br.close();
		bw.close();
	}	

}
