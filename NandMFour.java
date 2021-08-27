package boj_git;

import java.io.*;
import java.util.*;


public class NandMFour {
	private static int n;
	private static int m;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[m];
		solUtil(0);
		
	}
	private static int[] arr;
	public static void solUtil(int cnt) {
		if (cnt==m) {
			for (int j=0;j<arr.length;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
			return;
		}
		else {
			int start;
			if(cnt==0) start=1;
			else start=arr[cnt-1];
			for (int i=start;  i<=n;i++){
				arr[cnt]=i;
				solUtil(cnt+1);
			}
		
		}
	}
}
