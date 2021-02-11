package boj_git;
//1717 집합의 표현 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ImplementationSet {
	private static int[] par=new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str=br.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		for(int i=0;i<=n;i++) {
			par[i]=i;
		}
		int m=Integer.parseInt(str[1]);
		for(int i=0;i<m;i++) {
			str=br.readLine().split(" ");
			int a=Integer.parseInt(str[1]);
			int b=Integer.parseInt(str[2]);
			if(str[0].equals("0")) {
				union(a,b);
			}
			else if(str[0].equals("1")) {
				int x=find(a);
				int y=find(b);
				if(x==y) {
					bw.write("YES\n");
				}
				else bw.write("NO\n");
			}
		}
		br.close();
        bw.close();
		
		
	}
	public static int find(int a) {//find parent -> by rank 
		if(par[a]==a) return a;
		int x= find(par[a]);
		par[a]=x;
		return par[a];
		//short code : return par[a]=find(par[a]);
		
	}
	public static void union(int a, int b) {
		//find their parent
		int pA=find(a);
		int pB=find(b);
		if(pA==pB) {//already in same set
			return;
		}
		par[pB]=pA;
	}
}

