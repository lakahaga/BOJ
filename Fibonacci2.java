package samgsung02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Fibonacci2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw= new BufferedWriter(new FileWriter("output.txt"));
		
		int  N=Integer.parseInt(br.readLine());
		br.close();
		//BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		if(N==0||N==1){
            bw.write("0");
        }
        else{
            long D[]=new long[N+1];
            D[0]=0;
            D[1]=1;
            for(int i=2;i<=N;i++){
                D[i]=D[i-1]+D[i-2];
            }
            for(int i=0;i<N;i++)
    		{
    			System.out.println(i+" "+(D[i]));
    		}
            System.out.println();
		    bw.write(String.valueOf(D[N]));
        }
        
		
		

		bw.close();
	}
	
}
