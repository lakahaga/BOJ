package samgsung03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PartialSum {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line;
		int[][] frac =new int [2][2];
		int i=0;
        String str;
		while(true) {
			str=br.readLine();
			if(str==null) {
				break;
			}
            line=str.split(" ");
			frac[i][0]=Integer.parseInt(line[0]);
			frac[i][1]=Integer.parseInt(line[1]);
            i++;
		}
		br.close();
		//tong bun
		long[] ans=new long[2];
		ans[1]=lcm(frac[0][1],frac[1][1]);
		ans[0]=frac[0][0]*(ans[1]/frac[0][1])+frac[1][0]*(ans[1]/frac[1][1]);
		long G=gcd(ans[1],ans[0]);
		if(G!=0) {
			ans[1]/=G;
			ans[0]/=G;
		}
		bw.write(String.valueOf(ans[0])+" "+String.valueOf(ans[1]));
		
		bw.close();
		
	}
	public static long gcd(long a, long b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
	
    public static long lcm(long a, long b){
        return a*b/gcd(a,b);
    }
}



