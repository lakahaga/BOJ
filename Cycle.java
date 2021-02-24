package boj_git;

import java.util.*;

/*class Graph{
	private int V;
	private List<List<Integer>> adj;
	public Graph(int V) {
		this.V=V;
		adj=new ArrayList<>(V);
		
		for(int i=0;i<V;i++) {
			adj.add(new LinkedList<>());
		}
	}
	public void addEdge(int source,int dest) {
		adj.get(source).add(dest);
	}
	public boolean isCyclicUtil(int i,boolean[] visited, boolean[] recStack)
	{
		//Mark the current node as visited and part of recursion stack
		if(recStack[i]) return true;
		if(visited[i]) return false;//why??
		visited[i]=true;
		recStack[i]=true;
		List<Integer> children= adj.get(i);
		for(Integer c : children) {
			if(isCyclicUtil(c,visited,recStack)) return true;
		}
		recStack[i]=false;
		return false;
	}
	public boolean isCyclic() {
		//return true if the graph contains a cycle, else false
		
		//Mark all the vertices as not visited and not part of recursion stack
		boolean[] visited=new boolean[V];
		boolean[] recStack=new boolean[V];
		
		//Call the recursive helper function to detect cycle in different DFS trees
		for(int i=0;i<V;i++) {
			if(isCyclicUtil(i,visited,recStack)) return true;
		}
		return false;
	}
}
public class Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g=new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
	}

}
*/