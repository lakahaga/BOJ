package samsung06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;




class Graph1 {
	private int V;//number of vertices
	private LinkedList<Integer> adj[];
	@SuppressWarnings("unchecked")
	public Graph1(int v) {
		this.V=v;
		adj=new LinkedList[v+1];
		for(int i=0;i<v+1;i++) {
			adj[i]=new LinkedList<Integer>();
		}
		
	}
	@Override
	public String toString() {
		String res="";
		for(int i=0;i<adj.length;i++) {
			res+=i+"=>"+adj[i]+"\n";
		}
		return res;
	}
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	public void DFSUtil(int start,boolean visited[], BufferedWriter bw) throws IOException {
		bw.write(String.valueOf(start)+" ");
		Object[] arr=adj[start].toArray();
		Arrays.sort(arr);
		visited[start]=true;
	
		int i;
		for(Object j:arr) {
			
			i=(Integer) j;
			if(!visited[i]) {
				visited[i]=true;
				DFSUtil(i,visited,bw);
			}
		}

	}
	public void DFS(int start, BufferedWriter bw) throws IOException{
		boolean visited[]=new boolean[this.V+1];
		//bw.write(String.valueOf(start)+" ");
		DFSUtil(start,visited,bw);
		bw.write("\n");
	}
	public void BFS(int start, BufferedWriter bw) throws IOException {
		boolean visited[]=new boolean[this.V+1];
		
		BFSUtil(start,visited,bw);
	}
	public void BFSUtil(int start,boolean visited[], BufferedWriter bw ) throws IOException {
		Iterator<Integer> it=adj[start].iterator();
		Queue<Integer> q=new LinkedList<Integer>();
		int i;
		q.add(start);
		while(true) {
			if(q.isEmpty())
				break;
			i=q.poll();
			
			if(!visited[i]) {
				visited[i]=true;
				//visit
				bw.write(String.valueOf(i)+" ");
			}
			Object[] arr=adj[i].toArray();
			Arrays.sort(arr);
			for(Object j:arr) {
				if(!visited[(int) j]) {
					q.add((Integer) j);
					visited[(int) j]=true;
					bw.write(String.valueOf(j)+" ");
				}
			}
		}
	}
}

public class DFS {

	public static void main(String[] args)throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw= new BufferedWriter(new FileWriter("ouput.txt"));
		String[] str=br.readLine().split(" ");
		int N=Integer.parseInt(str[0]);//number of vertices
		int M=Integer.parseInt(str[1]);//number of edges 
		int V=Integer.parseInt(str[2]);//starting point
		Graph1 g= new Graph1(N);
		for(int i=0;i<M;i++) {
			str=br.readLine().split(" ");
			int u=Integer.parseInt(str[0]);
			int v=Integer.parseInt(str[1]);
			g.addEdge(u, v);
		}
		g.DFS(V, bw);
		g.BFS(V,bw);
		br.close();
		bw.close();
	}

}
