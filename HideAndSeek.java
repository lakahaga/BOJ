package boj_git;

import java.io.*;
import java.util.*;

public class HideAndSeek {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int cur=Integer.parseInt(st.nextToken());
		int dest=Integer.parseInt(st.nextToken());
		int cnt=howLong(cur,dest);
		bw.write(String.valueOf(cnt));
		br.close();bw.close();
	}
	private static int[] check=new int[100001];
	//no need to be initialized. there is only one test case per execution
	public static int howLong(int cur, int dest) {
		int tmp,next;
		Queue<Integer>que=new LinkedList<>();
		que.add(cur);check[cur]=0; 
		while(!que.isEmpty()) {
			tmp=que.poll();
			if(tmp==dest) break;
			for(int i=0;i<3;i++) {
				if(i==0) next=tmp-1;
				else if(i==1) next=tmp+1;
				else next=tmp*2;
				if(next>=0 && next<check.length && check[next]==0) {
					check[next]=check[tmp]+1;
					que.add(next);
				}
			}
		}
		return check[dest];
	}
	
}
