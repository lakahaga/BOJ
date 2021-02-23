package boj_git;

import java.io.*;
import java.util.*;

class Graph{
	private int v;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		v=V;
		adj=new LinkedList[V+1];
		for(int i=0;i<=V;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	public void add(int u,int v) {//undirected graph means you have to add in both ways!!!!!!!!
		adj[u].add(v);
		adj[v].add(u);
	}
	public int isConnected() {
		int ans=0;
		boolean[] visited=new boolean[v+1];
		for(int i=1;i<=v;i++) {
			if(!visited[i]) {ans++;Connect(i,visited);}
		}
		return ans;
	}
	public void Connect(int start, boolean[] visited) {
		//dfs
		visited[start]=true;
		int i;
		Iterator<Integer> it=adj[start].iterator();
		while(it.hasNext()) {
			i=it.next();
			if(!visited[i]) Connect(i,visited);
		}
	}
}
public class ConnectedComponenet {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new FileReader("input.txt"));
		BufferedWriter bw=new BufferedWriter (new FileWriter("output.txt"));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		Graph g=new Graph(n);
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			g.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		bw.write(String.valueOf(g.isConnected()));
		br.close();
		bw.close();
	}

}
