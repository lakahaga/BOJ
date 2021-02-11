package boj_git;


import java.io.*;
import java.util.*;
public class One {

	public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter (new OutputStreamWriter(System.out));
        
        String str;
        while(true){
            str=br.readLine();
            if(str==null) break;
            int n=Integer.parseInt(str);
            bw.write(String.valueOf(one(n))+"\n");
        }
        br.close();
        bw.close(); 
    }
    public static int one(int n){
        int cnt=1;
        int t=1;
        while(true){
            if(t%n==0) break;
            t%=n;
            t=t*10+1;
            cnt++;
        }
        return cnt;
    }
}