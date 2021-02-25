package boj_git;

import java.io.*;
import java.util.*;

class Graph{
	private int V;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V=v;
		adj=new LinkedList[v+1];
		for(int i=1;i<=v;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	public void add(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	public void sortG() {
		for(int i=1;i<=V;i++) Collections.sort(adj[i]);
	}
	public String dfs(int start) {
		boolean[] visited=new boolean[this.V+1];
		str="";
		dfsUtil(start,visited);
		return str;
	}
	private String str;
	public void dfsUtil(int start, boolean[] visited) {
		visited[start]=true;
		str+=String.valueOf(start)+" ";
		int i;
		Iterator<Integer> it=adj[start].iterator();
		while(it.hasNext()) {
			i=it.next();
			if(!visited[i]) dfsUtil(i,visited);
		}
	}
	public String bfs(int start) {
		str="";
		Queue<Integer> q=new LinkedList<Integer>();
		boolean[] visited=new boolean[this.V+1];
		visited[start]=true;str+=String.valueOf(start)+" ";
		q.add(start);
		int temp;
		while(!q.isEmpty()) {
			temp=q.poll();
			for(Integer i:adj[temp]) {
				if(!visited[i]) {
					str+=String.valueOf(i)+" ";q.add(i);
					visited[i]=true;
				}
			}
		}
		return str;
	}
}

public class DFSandBFS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter (System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(st.nextToken());
		Graph g=new Graph(n);
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			g.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		g.sortG();
		bw.write(g.dfs(start)+"\n");
		bw.write(g.bfs(start)+"\n");
		br.close();
		bw.close();
	}

}
