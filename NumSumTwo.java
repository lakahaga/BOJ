package boj_git;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class  NumSumTwo{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter( new OutputStreamWriter(System.out));

		String[] arr=(br.readLine()).split(" ");
		int N= Integer.parseInt(arr[0]);
		int M= Integer.parseInt(arr[1]);
		String[] nums=(br.readLine()).split(" ");
		int[] num=new int[N];
		for(int i=0;i<N;i++) {
			num[i]=Integer.parseInt(nums[i]);
		}
		
		br.close();
		int i,j=0;
        int sum;
		int cnt=0;
		for(i=0;i<N;i++) {
			sum=0;
			for(j=i;j<N;j++) {
				//from i to j -> sum
				sum+=num[j];
				if(sum==M) {
					cnt++;
					break;
				}
			}
		}
		
		
		
		bw.write(String.valueOf(cnt));
		bw.close();

	}
	
	

}

