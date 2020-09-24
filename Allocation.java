import java.io.*;
import java.util.*;

public class Allocation{
    
    int solve(Scanner a) {
    	int N = a.nextInt();
    	int B = a.nextInt();
    	int [] PriceArray = new int[N];
    	for (int i = 0 ; i < N ; i++){
    		PriceArray[i] = a.nextInt();
    	}
    	Arrays.sort(PriceArray);
    	int ans = 0;
    	int i = 0;
    	while(i < N){
    		if((B >= PriceArray[i]) && (PriceArray[i] > 0)){
    			B -= PriceArray[i];
    			ans++;
    		}
    		i++;
    	}
    	return ans;
    }
    
    public static void main(String args[]) {
    	try(Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
    		Allocation obj = new Allocation();
    		int T = s.nextInt();
    		int j = 1;
    		int ans;
    		while(T>0){
    			ans = obj.solve(s);
    			System.out.println("Case #" + j +": " + ans);
    			T--;
    			j++;
    		}
    		s.close();
    	}
    }
}
