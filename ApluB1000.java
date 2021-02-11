package boj_git;

import java.io.*;
import java.util.*;

public class ApluB1000{
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(a+b));
        br.close();
        bw.close();
    }
}