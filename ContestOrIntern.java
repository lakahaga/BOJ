package boj_git;

import java.io.*;
import java.util.*;

public class ContestOrIntern {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new FileReader("input.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int x,y; //x for female, y for male
		int team;int max=-1;
		for(int i=0;i<=k;i++) {
			x=n-i; y=m-(k-i);
			team=Math.min(x/2, y);
			if(max<team) max=team;
		}
		bw.write(String.valueOf(max));
		br.close();
		bw.close();
	}

}
