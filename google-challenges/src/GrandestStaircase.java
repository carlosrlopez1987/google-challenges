
public class GrandestStaircase {
	public static int[][] mem;
	public static int max_levels = 0;
	public static int max_stairs = 0;
	
	public static void main( String[] args) {
		System.out.print( "answer: " );
		System.out.println( solution(50) );
	}
	
	public static int solution( int num_blocks ) {
		
		create_emptyMem( num_blocks );
		max_stairs = get_maxStairs( num_blocks - 1 ) - 1;
		
		return max_stairs;
	}
	
	
	
	public static int get_maxLevels( int n ) {
		int numBlocks = n;
		int levels = 0;		// to count the levels
		
		for ( int b4nLevel = 1; b4nLevel <= numBlocks; b4nLevel++ ){
			if ( numBlocks >= 0 ) {
				numBlocks = numBlocks - b4nLevel;
				levels++;
			}
		}
		 
		return levels;
	}
	
	public static void create_emptyMem( int blocks ) {
		
		mem = new int[ blocks+2 ][ blocks+2 ];
		
		for ( int row = 0; row < blocks; row++ ) 
			for ( int col = 0; col < blocks; col++ ) 
				mem[ row ][ col ] = -1;
		
	}
	

	public static int get_maxStairs( int blocks, int step ) {
		
		if ( blocks == 0 ) return 1;
		if ( blocks  < 0 ) return 0;
		
		if ( mem[step][blocks] != -1 ) return mem[step][blocks];
		
		mem[step][blocks] = get_maxStairs( blocks - 1, step + 1) + get_maxStairs( blocks-step-1, step+1 );
		
		return mem[step][blocks];
	}
	
	public static int get_maxStairs( int blocks ) {
		//stair 1 begins with 50 blocks and i level, and it doesn't count
		
		int step = 1;
		
		if ( blocks == 0 ) return 1;
		if ( blocks  < 0 ) return 0;
		
		if ( mem[step][blocks] > 0 )  return mem[step][blocks];
		
		//decrease blocks by 1 from row 1 which at start should be 50,
		//add that block to second level which will have 1 block after adding it
		mem[step][blocks] = get_maxStairs( blocks - 1, step + 1) + get_maxStairs( blocks-step-1, step+1 );
		
		return mem[step][blocks];
	}
	
	
}
