package boj_git;

import java.io.*;
import java.util.*;

public class Keypad_Kakao {
	private static int[]  numbers=new int[1000];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter (new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=-1;
		while(st.hasMoreTokens()) {
			numbers[++n]=Integer.parseInt(st.nextToken());
		}
		br.close();
		String hand=br.readLine();
		String answer = "";
        int prevL=10; int prevR=12;
        //1,2,3,/ 4,5,6/ 7,8,9/10,11,12
        for(int i=0;i<n;i++){
            if(numbers[i]%3==1) {answer+="L";}
            else if(numbers[i]%3==0 && numbers[i]!=0) {answer+="R";}
            else {
                if(numbers[i]==0) answer+=distance(11,prevL,prevR,hand);
                else answer+=distance(numbers[i],prevL, prevR,hand);
            }
            if(answer.charAt(answer.length()-1)=='L') prevL=numbers[i];
            else prevR=numbers[i];
        }
        bw.write(answer+"\n");
        bw.close();
	}
	public static String distance(int dest, int srcL, int srcR, String hand){
        //dest==2,5,8,11
        if(srcL==0) srcL=11; if(srcR==0) srcR=11;
        int destR=dest/3; 
        int srcLC=srcL%3; int srcRC=srcR%3;
        int srcLR=srcL/3; int srcRR=srcR/3;
        if(srcL%3==0) {srcLC=3;srcLR--;}
        if(srcR%3==0) {srcRC=3;srcRR--;}
        int dL=Math.abs(destR-srcLR) + Math.abs(srcLC-2);
        int dR=Math.abs(destR-srcRR) +Math.abs(srcRC-2);
        if(dL>dR) return "R";
        else if(dL<dR) return "L";
        else {
            if(hand.equals("right")) return "R";
            else return "L";
        }
    }

}
