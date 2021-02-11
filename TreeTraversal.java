package boj_git;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class Node{
	private char data;
	private Node left, right;
	public Node(char data) { this.data=data; this.left=this.right=null;}
	public void setLeft(Node l) {this.left=l;}
	public void setRight(Node r) {this.right=r;}
	public Node getLeft() {return this.left;}
	public Node getRight() {return this.right;}
	public char getData() {return this.data;}
}
class Tree {
	private Node root;
	public Node getRoot() {return this.root;}
	public void add(char data, char l, char r) {
		if(root==null) {
			root=new Node(data);
			if(Character.compare(l, '.')!=0) root.setLeft(new Node(l));
			if(Character.compare(r, '.')!=0) root.setRight(new Node(r));
		}
		else {
			search(root,data,l,r);
		}
	}
	public void search(Node root, char data, char l, char r) {
		if(root==null) return;
		else if (root.getData()==data) {
			if(l!='.') root.setLeft(new Node(l));
			if(r!='.') root.setRight(new Node(r));
		}
		else {
			search(root.getLeft(),data,l,r);
			search(root.getRight(),data,l,r);
		}
	}
	public void preorder(Node root,BufferedWriter bw)throws IOException {
		if(root==null) return ;
		bw.write(String.valueOf(root.getData()));
		if(root.getLeft()!=null) preorder(root.getLeft(),bw);
		if(root.getRight()!=null) preorder(root.getRight(),bw);
	}
	public void inorder(Node root,BufferedWriter bw)throws IOException {
		if(root==null) return ;
		
		if(root.getLeft()!=null) inorder(root.getLeft(),bw);
		bw.write(String.valueOf(root.getData()));
		if(root.getRight()!=null) inorder(root.getRight(),bw);
	}
	public void postorder(Node root,BufferedWriter bw)throws IOException {
		if(root==null) return ;
		if(root.getLeft()!=null) postorder(root.getLeft(),bw);
		if(root.getRight()!=null) postorder(root.getRight(),bw);
		bw.write(String.valueOf(root.getData()));
	}
}
public class TreeTraversal {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		int N= Integer.parseInt(br.readLine());
		Tree tree=new Tree();
		for(int i=1;i<=N;i++) {
			char[] ch=br.readLine().replace(" ","").toCharArray();
			tree.add(ch[0],ch[1],ch[2]);
		}
		tree.preorder(tree.getRoot(), bw);
        bw.write("\n");
		tree.inorder(tree.getRoot(), bw);
        bw.write("\n");
		tree.postorder(tree.getRoot(),bw);
		bw.write("\n");
		br.close();
		bw.close();
	}
	
	

}

