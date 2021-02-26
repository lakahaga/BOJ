package boj_git;

import java.io.*;
import java.util.*;
public class Thirty {
	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String str=br.readLine();
		List<Integer> num=new ArrayList<>();
		for(int i=0;i<str.length();i++) num.add(str.charAt(i)-'0');
		Collections.sort(num,Collections.reverseOrder());
		if(num.get(num.size()-1)!=0) bw.write("-1");
		else{
			int sum=0;
			for(Integer i:num) sum+=i;
			String sb="";
			if(sum%3==0) {
				for(Integer i:num) sb+=String.valueOf(i);
				bw.write(sb);
			}
            else bw.write("-1");
		}
        br.close();
        bw.close();
	}

}
