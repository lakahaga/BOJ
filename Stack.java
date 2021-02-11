package boj_git;



import java.io.*;
import java.util.*;

class myStk{
	private int size;
	private int[] stk;
	private int top=-1;
	public myStk(int n) {
		this.size=n;
		stk=new int[n];
	}
	public void push(int a) {
		stk[++top]=a;
	}
	public int pop() {
		if(empty()==1) {
			return -1;
		}
		return stk[top--];
	}
	public int empty() {
		if(top>-1) return 0;
		else return 1;
	}
	public int size() {return top+1;}
	public int top() {
		if(empty()==1) return -1;
		return stk[top];
	}
}
public class Stack{
	
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter (new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		myStk stk=new myStk(n);
		String[] str;
		for(int i=0;i<n;i++) {
			str=br.readLine().split(" ");
			if(str.length!=1) {//push
				stk.push(Integer.parseInt(str[1]));
			}
			else {
				if(str[0].equals("top")) bw.write(String.valueOf(stk.top())+"\n");
				else if(str[0].equals("pop")) bw.write(String.valueOf(stk.pop())+"\n");
				else if(str[0].equals("size")) bw.write(String.valueOf(stk.size())+"\n");
				else if(str[0].equals("empty")) bw.write(String.valueOf(stk.empty())+"\n");
			}
		}
		
		
		br.close();
		bw.close(); 
	}

}

