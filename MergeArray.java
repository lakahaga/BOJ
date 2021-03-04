package boj_git;

import java.io.*;
import java.util.*;

public class MergeArray {
	private static int[] num=new int[10000001];
	private static int[] res=new int[10000001];
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter (new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) num[i]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=n;i<m+n;i++) num[i]=Integer.parseInt(st.nextToken());
		int size=n+m;
		//two-pointer
		int a=0;int b=size-1;
		for(int i=0;i<size &&a<size&&b>0;i++) {
			if(num[a]<num[b]) {
				res[i]=num[a];
				System.out.println(res[i]+" "+num[a]);
				if(a<size-1) a++;
				System.out.println(num[a]);
			}
			else if(num[a]>num[b]) {
				res[i]=num[b];
				System.out.println(res[i]+" "+num[b]);
				if(b>0) b--;
				System.out.println(num[b]);
			}
			else {
				if(a!=b) {
					res[i]=num[a];i++;
					res[i]=num[b];
					if(a<size-1) a++;
					if(b<0) b--;
				}
			}
		}
		System.out.println(size);
		for(int i=0;i<size;i++) {
			bw.write(String.valueOf(num[i]+" "));
		}
		bw.write("\n");
		for(int i=0;i<size;i++) {
			bw.write(String.valueOf(res[i]+" "));
		}
		br.close();
		bw.close();
	}

}
