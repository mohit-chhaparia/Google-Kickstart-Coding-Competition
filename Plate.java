import java.io.*;
import java.util.*;

public class Plate {
	
	static int N = (int) (1e5 + 5) , P = 51 * 30;
	static int n , k , p;
	static int [][] a = new int[N][31];
	static int [][] sum = new int[N][31];
	static int [][] cache = new int[N][P];
	
	int beautify(int stack_num , int plates_taken) {
		
		if(plates_taken == p)
			return 0;
		
		if((stack_num > n) || (plates_taken > p))
			return (int) -1e9;
		
		if(cache[stack_num][plates_taken] != -1)
			return cache[stack_num][plates_taken];
		
		int ans = (int) -1e9;
		
		for(int i = 0 ; i <= k ; i++)
			ans = Math.max(ans , sum[stack_num][i] + beautify(stack_num + 1 , plates_taken + i));
		
		return cache[stack_num][plates_taken] = ans;
	}


    public static void main(String args[]) {
    	
    	try(Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
    		
    		Plate obj = new Plate();
    		int T = s.nextInt();
    		int case_num = 0;
    		
    		while(T > 0) {
    			case_num++;
    			n = s.nextInt();
    			k = s.nextInt();
    			p = s.nextInt();
    			
    			for(int i = 1 ; i <= n ; i++)
    				for(int j = 1 ; j <= k ; j++) {
    					a[i][j] = s.nextInt();
    					sum[i][j] = sum[i][j-1] + a[i][j];
    				}
    			
    			for(int i = 0 ; i < N ; i++)
    				Arrays.fill(cache[i] , -1);
    			
    			int ans = obj.beautify(1 , 0);
    			System.out.println("Case #" + case_num +": " + ans);
    			T--;
    		}
    		s.close();
    	}
    	
    }
}
