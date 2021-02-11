package samgsung05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinaryCoefficient {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line =br.readLine().split(" ");
		int N=Integer.parseInt(line[0]);
		int K=Integer.parseInt(line[1]);
		br.close();
		int ans=1;
		for(int i=K+1;i<=N;i++) {
			ans*=i;
		}
		for(int i=2;i<=(N-K);i++) {
			ans/=i;
		}
		bw.write(String.valueOf(ans));
		bw.close();
	}

}
