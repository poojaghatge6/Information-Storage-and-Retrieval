package PreProcessData;
import java.util.ArrayList;
/**
 * This is for INFSCI 2140 in 2018
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {
	// Essential private methods or variables can be added.
	private ArrayList<char[]> tokens = null;
	private int k=0;
	// YOU MUST IMPLEMENT THIS METHOD.
	public WordTokenizer( char[] texts ) {
		// Tokenize the input texts.
		String text=new String(texts);
		text=text.replace("[',!.;]+", ""); //removes either of these special characters
		String[] words=text.split(" ");
		tokens =new ArrayList<char[]>();
		for(int j = 0 ; j < words.length; j++)
			if(words[j]!=null)
				tokens.add(words[j].toCharArray());
	}
	
	// YOU MUST IMPLEMENT THIS METHOD.
	public char[] nextWord() {
		// Return the next word in the document.
		// Return null, if it is the end of the document.
		
		if(k== tokens.size())
			return null;
		else			
			return tokens.get(k++);
	}
	
}
