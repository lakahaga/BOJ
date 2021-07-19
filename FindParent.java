package boj_git;

import java.io.*;
import java.util.*;

class Graph{
	private int v;
	private LinkedList<Integer>[] adj;
	private int[] parent;
	private boolean[] visited;
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v=v;
		adj=new LinkedList[v+1];
		for(int i=0;i<v+1;i++) {
			adj[i]=new LinkedList<Integer>();
		}
		visited=new boolean[v+1];
		parent=new int[v+1];
	}
	public void add(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	public void print(BufferedWriter bw) throws Exception{
		for(int i=2;i<=v;i++) {
			bw.write(String.valueOf(parent[i])+"\n");
		}
	}
	public void bfs(int start) {
		Queue<Integer> que=new LinkedList<Integer>();
		que.add(start);
		visited[start]=true;
		int tmp,i;
		while(!que.isEmpty()) {
			tmp=que.poll();
			Iterator<Integer> it=adj[tmp].iterator();
			while(it.hasNext()) {
				i=it.next();
				if(!visited[i]) {
					parent[i]=tmp;
					visited[i]=true;
					que.add(i);
				}
			}
		}
	}
	public String getParent() {
		StringBuilder sb=new StringBuilder();
		for(int i=2;i<=v;i++) {
			sb.append(String.valueOf(parent[i])+"\n");
		}
		
		return sb.toString();
	}
}
public class FindParent {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter (new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		int u,v;
		Graph g=new Graph(n);
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			u=Integer.parseInt(st.nextToken());
			v=Integer.parseInt(st.nextToken());
			g.add(u, v);
		}
		g.bfs(1);
		
		bw.write(g.getParent());
		br.close();bw.close();
	}

}
