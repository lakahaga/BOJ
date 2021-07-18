package boj_git;

import java.util.*;

public class TargetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,1,1,1};
		solution(arr, 3);
	}
	public static int solution(int[] numbers, int target) {
        int cnt=0;
        int plus, minus,k;
 
        LinkedList<Integer>[] list=new LinkedList[numbers.length];
        for(int i=0;i<numbers.length;i++){
            list[i]=new LinkedList<Integer>();
        }
        for(int i=0;i<numbers.length;i++){
            if(i==0){
                plus=numbers[i]; minus=-numbers[i];
                list[0].add(plus); list[0].add(minus);
            }
            else{
                Iterator<Integer> it=list[i-1].iterator();
                while(it.hasNext()){
                    k=it.next();
                    plus=k+numbers[i]; minus=k-numbers[i];
                    list[i].add(plus); list[i].add(minus);
                }
            }
        }
        Iterator<Integer> it=list[numbers.length-1].iterator();
        while(it.hasNext()){
            k=it.next();
            if(k==target) cnt++;
        }
        return cnt;
    }

}
