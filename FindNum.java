package boj_git;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter( new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] Nnum=new int[N];
		for(int i=0;i<N;i++) {
			Nnum[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] Mnum=new int[M];
		for(int i=0;i<M;i++) {
			Mnum[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Nnum);
		for(int i=0;i<M;i++) {
			if(Arrays.binarySearch(Nnum, Mnum[i])>=0) {
				bw.write("1\n");
			}
			else bw.write("0\n");
		}
	
		br.close();
		bw.close();
	}

}

