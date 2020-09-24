import java.io.*;
import java.util.*;

public class Workout {
		
	static int n = (int) (1e5 + 5);
	static int N , K;
	static int [] mnt = new int[n];
	
	boolean check(int dflt) {
		
		int AddSessReqd = 0;
		
		for(int i = 1 ; i <= N - 1 ; i++)
			AddSessReqd += ((mnt[i + 1] - mnt[i] - 1) / dflt);
			
		if(AddSessReqd <= K)
			return true;
			
		return false;
	}
	
	int binary_search(int low , int high) {
			
		while(low < high) {
			int mid = (low + high) / 2;
				
			if(check(mid))
				high = mid;
				
			else
				low = mid + 1;
			
		}
			
		return low;
			
	}
		
	public static void main(String args[]) {
	    	
	   	try(Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
	    		
	   		Workout obj = new Workout();
	   		int T = s.nextInt();
	   		int tc = 0;
	   		
	   		while(T > 0) {
	   			tc++;
	   			N = s.nextInt();
	   			K = s.nextInt();
	    			
	   			for(int i = 1 ; i <= N ; i++)
	   				mnt[i] = s.nextInt();
	    			
	   			int ans = obj.binary_search(1 , (int) 1e9);
	   			System.out.println("Case #" + tc + ": " + ans);
	   			T--;
	   		}
	   		s.close();
	   	}
	}
}
