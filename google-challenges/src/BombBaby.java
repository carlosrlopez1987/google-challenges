import java.math.BigInteger;

public class BombBaby {
	
	
	
	public static void main( String[] str ) {
		//String msg = solution( "99", "4" );
		System.out.println( "answer: " + calcSteps("16", "2" ) );
		//System.out.println( "answer: " + msg );
	}
	
    public static String calcSteps( String x, String y ) {
    	
    	BigInteger mach = new BigInteger(x);
    	BigInteger facu = new BigInteger(y);
    	
    	BigInteger steps = new BigInteger( "0" );
    	BigInteger max;
		BigInteger min;
    	BigInteger temp = null;
    	String answer = null;
    	
    	if ( x.equals( "1" ) && y.equals( "1" ) ) return "0";
    	if ( mach.compareTo( facu ) == 0 ) return "impossible";
    	
    	
    	int loop = 1;
    	
    	while ( mach.compareTo( BigInteger.ONE ) >= 0 && facu.compareTo( BigInteger.ONE) >= 0 ){
    		
    		System.out.println( "loop " + loop + ": Mach: " + mach + " Facu: " + facu );
			max = mach.max( facu );
			min = mach.min( facu );
			
			mach = max;
			facu = min;
			
			if ( mach.compareTo( facu) == 0 && mach.compareTo( BigInteger.ONE ) == 0 )
				break;
			if ( mach.divide( facu ).compareTo( BigInteger.valueOf(50) ) == 1 ) {
				System.out.println( "1. Mach: " + mach + " Facu: " + facu );
				temp = mach.divide( facu );
				steps = steps.add( temp );
				mach = mach.mod( facu );
			} else {
				System.out.println( "2. Mach: " + mach + " Facu: " + facu );
				if ( mach.compareTo( BigInteger.ONE ) == 1 ) {
					System.out.println( "2.1. mach: " + mach.toString() + " Facu: " + facu.toString() );
					mach = mach.subtract(facu);
					steps = steps.add( BigInteger.ONE );
				}
			}
			loop++;
			System.out.println(" ");
    	};
    	
    	System.out.println( "3. mach: " + mach.toString() + " Facu: " + facu.toString() );
    	if ( mach.compareTo(facu) == 0 && mach.compareTo(BigInteger.ONE) == 0 )
    		answer = steps.toString();
    	else
    		answer = "impossible";
		
    	return answer;
    }
}