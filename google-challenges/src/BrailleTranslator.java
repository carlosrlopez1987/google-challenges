import java.util.Map;
import java.util.HashMap;

public class BrailleTranslator {
	    // alphabet collection map
	    private static Map<Character, String> Alph = new HashMap<Character, String>();
	    
	    public static String solution( String phrase ) {
	        
	    	BrailleTranslator.loadAlphabet();
	    	String braille = BrailleTranslator.translate( phrase );
	    	
	        return braille;
	    }
	    
	    public static void main( String[] args )
	    {
	    	System.out.println( solution("hello"));
	    }
	    
	    
	    public static Map<Character, String> getAlphabet() {
	        return BrailleTranslator.Alph;
	    }
	    
	    
	    // take a string in alpahbetic letters 1-26
	    // and returns a translated string of solutions
	    public static String translate( String phrase ) {
			
			String translation = "";
			Map<Character, String> alphabet = BrailleTranslator.getAlphabet(); 
			
			int i = 0;
			Character upperCase;
			
			for ( phrase.charAt(i);i < phrase.length();i++) {
				
				if ( Character.isUpperCase( phrase.charAt(i) ) )
				{
					upperCase = Character.toLowerCase( phrase.charAt(i) );
					translation = translation + "000001";
					translation = translation + alphabet.get( upperCase );
				}
				else {
					translation = translation + alphabet.get( phrase.charAt(i) );
				}
				
			}
			
			return translation;
		}
	    
	    public static void loadAlphabet() {
	    	Alph.put( 'a', "100000" ); //1
	    	BrailleTranslator.Alph.put( 'b', "110000" ); 
	    	BrailleTranslator.Alph.put( 'c', "100100" );
	    	BrailleTranslator.Alph.put( 'd', "100110" );
	    	BrailleTranslator.Alph.put( 'e', "100010" );
	    	BrailleTranslator.Alph.put( 'f', "110100" );
	    	BrailleTranslator.Alph.put( 'g', "110110" );
	    	BrailleTranslator.Alph.put( 'h', "110010" );
	    	BrailleTranslator.Alph.put( 'i', "010100" );
	    	BrailleTranslator.Alph.put( 'j', "010110" );
	    	BrailleTranslator.Alph.put( 'k', "101000" );
	    	BrailleTranslator.Alph.put( 'l', "111000" );
	    	BrailleTranslator.Alph.put( 'm', "101100" );
	    	BrailleTranslator.Alph.put( 'n', "101110" );
	    	BrailleTranslator.Alph.put( 'o', "101010" );
	    	BrailleTranslator.Alph.put( 'p', "111100" );
	    	BrailleTranslator.Alph.put( 'q', "111110" );
	    	BrailleTranslator.Alph.put( 'r', "111010" );
	    	BrailleTranslator.Alph.put( 's', "011100" );
	    	BrailleTranslator.Alph.put( 't', "011110" );
	    	BrailleTranslator.Alph.put( 'u', "101001" );
	    	BrailleTranslator.Alph.put( 'v', "111001" );
	    	BrailleTranslator.Alph.put( 'w', "010111" );
	    	BrailleTranslator.Alph.put( 'x', "101101" );
	    	BrailleTranslator.Alph.put( 'y', "101111" );
	    	BrailleTranslator.Alph.put( 'z', "101011" );
	    	BrailleTranslator.Alph.put( ' ', "000000" );
	    }
	}

    