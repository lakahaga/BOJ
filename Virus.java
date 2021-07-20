package boj_git;

import java.util.*;
import java.io.*;

class Graph{
	private int v;
	private LinkedList<Integer>[] adj;
	public Graph(int v) {
		this.v=v;
		adj=new LinkedList[v+1];
		for(int i=0;i<=v;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int u, int v) {
		adj[u].add(v); adj[v].add(u);//undirected
	}
	
	public int cntConnected(int start) {
		int cnt=0;
		boolean[] visited=new boolean[v];
		Stack<Integer> stk=new Stack<Integer>();
		visited[start]=true;
		stk.push(start);
		int i,tmp;
		while(!stk.isEmpty()) {
			tmp=stk.pop();
			Iterator<Integer> it=adj[tmp].iterator();
			while(it.hasNext()) {
				i=it.next();
				if(visited[i]==false) {
					stk.push(i);cnt++;visited[i]=true;//visit
				}
			}
		}
		return cnt;
	}
	
}
public class Virus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int v=Integer.parseInt(br.readLine());
		int e=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int a,b;
		Graph g=new Graph(v);
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			g.addEdge(a, b);
		}
		int cnt=g.cntConnected(1);
		bw.write(String.valueOf(cnt));
		br.close(); bw.close();
	}

}
