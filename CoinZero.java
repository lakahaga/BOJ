package boj_git;

import java.io.*;
import java.util.*;

public class CoinZero {
	public static int[] coin=new int[11];
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new FileReader("input.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());//number of types of coin
		int k=Integer.parseInt(st.nextToken());//sum
		for(int i=1;i<=n;i++) coin[i]=Integer.parseInt(br.readLine());
		int temp=k;int ans=0; int cnt=0;
		for(int i=n;i>0;i--) {
			if(coin[i]>temp) continue;
			else {
				ans+=temp/coin[i];
				temp%=coin[i];
				if(temp==0) break;
			}
		}
		System.out.println(ans);
		br.close();
		bw.close();
	}

}
