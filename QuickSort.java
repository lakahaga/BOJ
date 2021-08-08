package boj_git;

import java.io.*;
import java.util.*;


public class QuickSort {
	private static int[] arr=new int[10000];
	private static int n;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		visited=new boolean[n+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		int i=0;
		for (;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			
		}
		printArr(n+3);
		arr[n]=Integer.MAX_VALUE;
		Quicksort(0,n);
		
		printArr(n);
		
	}
	private static boolean[]  visited;
	public static void Quicksort(int l, int h) {
		if(l<h) {
			int j=partition(l,h);
			Quicksort(l,j);
			Quicksort(j+1, h);
			
		}
	}
	public static void swap(int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	public static int partition(int l, int h) {
		
		int j=h;int i=l;
		//j finds smaller one than pivot, i finds greater one than pivot
		int pivot=arr[l];
		while(i<j) {
			while(pivot>=arr[i] && i<n) i++;
			while (pivot<=arr[j] && j>0) j--;
			if(i<j) swap(i,j);
		}
		int ans;
		if(l<j) {swap(l,j);ans=j;}
		else ans=l;
		 //now number in j is pivot number
		return ans;
	}
	public static void printArr(int n) {
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
