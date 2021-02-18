package boj_git;

import java.io.*;
import java.util.*;

public class AdhocSort {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[] v= new int[n+1];
		for(int i=1;i<=n;i++) v[i]=i;
		for(int i=1;i<=m;i++) {
			st=new StringTokenizer(br.readLine());
			
			v[Integer.parseInt(st.nextToken())]++;
			v[Integer.parseInt(st.nextToken())]--;
		}
		int[] visited=new int[n+1];
		for(int i=1;i<=n;i++) visited[v[i]]++;
		boolean flag=false;
		for(int i=1;i<=n;i++) {
			if(visited[i]==0|| visited[i]>1) flag=true;
		}
		if(flag) bw.write("-1");
		else for(int i=1;i<=n;i++) bw.write(String.valueOf(v[i])+" ");
		br.close();
		bw.close();
	}

}
