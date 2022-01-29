import java.util.ArrayList;
import java.util.Arrays;

public class AlreadyDidThat {
	
	public static String 	currId 	 = "";
	public static int  	 	currBase = 0;
	
	public static void main( String[] args ) {
		String 	 seq = AlreadyDidThat.ascendingOrder( "1211" );
		int 	base = 10;
		
		int answer = AlreadyDidThat.solution( seq, base );
		
		System.out.println( "Solution is: " + String.valueOf(answer) );
	}
	
	public static int solution( String id, int base ) {
		
		int solution = 0;
		
		ArrayList<String> idCollection = new ArrayList<String>();
		
		AlreadyDidThat.currId	= id;
		
		do {
			idCollection.add( AlreadyDidThat.ascendingOrder(AlreadyDidThat.currId) ); 
			AlreadyDidThat.currId = AlreadyDidThat.ascendingOrder( AlreadyDidThat.getNewId( AlreadyDidThat.currId, base ) );		// lets just do ascending order
			//idCollection.add( Solution.ascendingOrder(Solution.currId) ); 
			
			if ( idCollection.contains( AlreadyDidThat.ascendingOrder(AlreadyDidThat.currId) ) == true ) {
				//System.out.println( "Yeeeeeees");
				break;
			}
				
			
		} while ( true );
		
		idCollection.add( AlreadyDidThat.ascendingOrder( AlreadyDidThat.currId ) );
		
		boolean beginCounting = false;
		
		for ( int i = 0; i < idCollection.size(); i++ ) {
			//if ( idCollection.get(i).equals(Solution.currId) ) beginCounting = true;
			if ( beginCounting == true ) {
				solution += 1;
			}
			if ( idCollection.get(i).equals(AlreadyDidThat.currId) ) beginCounting = true;
			//System.out.println( i + 1 + ": " + idCollection.get(i) );
		}
		
		return solution;
	}
	
	
	// ended up not need it because I use arraylist
	public static boolean found( String needle, String[] hayStack ) {
		boolean found = false;
		
		for (String id : hayStack) {
            if ( id == needle ) {
                found = true;
                break;
            }
        }
		
		return found;
	}
	
	
	public static String getNewId( String oldId, int base ) {
		
		int 	results;
		int		base10 = 10;		//
		int 	seqLength 	= oldId.length(); // k
		
		String 	minionId 	= null;			// n
		String 	descending 	= null;			// x
		String 	ascending	= null;			// y
		
		ascending 	= AlreadyDidThat.ascendingOrder( oldId );
		ascending 	= AlreadyDidThat.changeBase( ascending, base, base10 );
		
		descending = AlreadyDidThat.descendingOrder( oldId );
		descending = AlreadyDidThat.changeBase( descending, base, base10 );
		
		int y = Integer.valueOf( ascending  );
		int x = Integer.valueOf( descending );
		
		results = x - y;
		
		minionId = String.valueOf( results );
		minionId = AlreadyDidThat.changeBase( minionId, base10, base );
		
		// minionId = "202";		//debugging
		for (int i = 0; i < seqLength - minionId.length(); ) {
			minionId = "0" + minionId;
		}
		
		return minionId;
		
	}
	
	public static String changeBase( String seq, int currBase, int tgtBase ) {
		String baseChanged = null;
		
		baseChanged = Integer.toString( Integer.parseInt( seq, currBase ), tgtBase);
		
		
		return baseChanged;
	}
	
	public static String ascendingOrder( String str ) {
		String ascending 	= null;
		char[] charArr 		= str.toCharArray();
		
		Arrays.sort( charArr );
		
		ascending 			= String.valueOf( charArr );
		
		return ascending;
	}
	
	public static String descendingOrder( String str ) {
		
		int i;
		String seq 			= AlreadyDidThat.ascendingOrder(str);				
		String descending 	= null;
		char[] arr 			= seq.toCharArray();
		int n 				= arr.length;
		char temp;
		
		for ( i = 0; i < n/2; i++ ) {
			temp 		= arr[i];				// saving 1st char temporarily
			arr[i] 		= arr[ n -i - 1 ];		// put last char in the 1st char loc
			arr[n-i-1]	= temp;
		}
		
		descending = String.copyValueOf(arr);
		
		return descending;
	}
	
	

}
