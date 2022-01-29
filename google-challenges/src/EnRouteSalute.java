
public class EnRouteSalute {

	
	public static int goingLeft 	= 0;
	public static int goingRight 	= 0;
	public static int totalSalutes 	= 0;
	public static String hallway 	= null;
	
	public static int solution( String str ) {
        //Your code here
        
        hallway = str;
        String partHall = null;
        
        for( int i = 0; i < hallway.length(); i++ ) {
        	//System.out.print( "char " + i + ": " + hallway.charAt( i ) );
        	if ( hallway.length() < 2 )
        		break;
            switch (hallway.charAt(i) ) {
                case '<':
                	//System.out.println(" ");
                	partHall = hallway.substring(0, i);
                	salutesGoingLeft( partHall );
                    break;
                case '>':
                	//System.out.println(" ");
                	partHall = hallway.substring(i);
                	salutesGoingRight( partHall);
                    break;
                default:
                	//System.out.println(" ");
                	break;
            }
        }
        totalSalutes = totalSalutes * 2;
        
        return totalSalutes;
    }
	
	public static void main( String[] args ) {
		
		String hall = "--<>><--<<>-<>"; // 18
		System.out.println( hall );
		EnRouteSalute.solution( hall );
		System.out.println( "Total: " + totalSalutes );
		
		totalSalutes = 0;
		hall = "--->-><-><-->-"; // 18
		System.out.println( hall );
		EnRouteSalute.solution( hall );
		System.out.println( "Total: " + totalSalutes );
		
		totalSalutes = 0;
		hall = ">----<"; // 18
		System.out.println( hall );
		EnRouteSalute.solution( hall );
		System.out.println( "Total: " + totalSalutes );
		
		totalSalutes = 0;
		hall = "<<>><"; // 18
		System.out.println( hall );
		EnRouteSalute.solution( hall );
		System.out.println( "Total: " + totalSalutes );
	}
	
	public static void salutesGoingRight( String hall ) {
		for ( int i = 0; i < hall.length(); i++ ) {
			if ( hall.charAt(i) == '<' ) {
				totalSalutes++;
				//System.out.println( hall + " going right char " + i + ": " + hall.charAt( i ) );
			}
		}
	}
	
	public static void salutesGoingLeft( String hall ) {
		for ( int i = hall.length(); i <= 0; i-- ) {
			if ( i > 0 && hall.charAt(i) == '>' ) {
				totalSalutes++;
				//System.out.println( hall + " going right char " + i + ": " + hall.charAt( i ) );
			}
		}
	}

	
	
}
