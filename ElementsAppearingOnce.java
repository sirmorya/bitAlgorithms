package bitAlgorithms;

/**
 * Find the element from an array which occurs for a single time whrn all other elements occur thrice.
 * @author ankitsirmorya
 *
 */
public class ElementsAppearingOnce {

	
	int getSingle(int a[]){
		
		int ones = 0, twos = 0;
		
		int commonBitMask = 0;
		
		for(int i = 0; i < a.length; i++){
			
			//Adding the common bits of the ones and the new elements. Then adding the common bits to twos. 
			twos = twos | (ones & a[i]);
			
			//XOR the new element with ones to retain elements which occur odd times.
			ones = (ones ^ a[i]);
			
			//Common bits contain the bits which occur for the third time.
			commonBitMask = ~(ones  & twos);
			
			//Remove the common bits from the ones and twos
			ones &= commonBitMask;
			
			twos &= commonBitMask;
		}
		return ones;
		
	}
	
	public static void main(String[] args) {
		int a[] = {3, 3, 2, 3};
		System.out.println(new ElementsAppearingOnce().getSingle(a));
		
	}
	
}
