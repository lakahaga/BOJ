package boj_git;

import java.io.*;
import java.util.*;

public class NumberOfIsland {
	private static char[][] map=new char[50][50];
	private static boolean[][] visited=new boolean[50][50];
	private static int cnt,w,h;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader (new FileReader("input.txt"));
		BufferedWriter bw=new BufferedWriter (new FileWriter("output.txt"));
		StringTokenizer st;
		while(true) {
			st=new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;
			for(int j=0;j<h;j++) {
				st=new StringTokenizer(br.readLine());
				for(int i=0;i<w;i++) {
					map[j][i]=st.nextToken().charAt(0);
				}
			}
			for(int r=0;r<h;r++) {
				for(int c=0;c<w;c++) { visited[r][c]=false;}
			}
			cnt=0;
			for(int r=0;r<h;r++) {
				for(int c=0;c<w;c++) {
					if(!visited[r][c] && map[r][c]=='1') {cnt++;dfs(r,c);}
				}//count connected component
			}
			bw.write(String.valueOf(cnt)+"\n");
		}
		br.close();
		bw.close();
	}
    private static int[] moveX={-1,-1,-1,0,0,1,1,1};
    private static int[] moveY={-1,0,1,-1,1,-1,0,1};
	public static void dfs(int i, int j) {
		visited[i][j]=true;
        int dx,dy;
		for(int m=0;m<8;m++){
            dx=i+moveX[m]; dy=j+moveY[m];
            if(dx>=0 && dy>=0&& dx<h && dy<w) if(!visited[dx][dy] && map[dx][dy]=='1') dfs(dx, dy);
        }
	}
}
