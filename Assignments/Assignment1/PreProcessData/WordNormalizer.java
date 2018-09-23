package PreProcessData;

import Classes.*;

/**
 * This is for INFSCI 2140 in 2018
 * 
 */
public class WordNormalizer {
	// Essential private methods or variables can be added.
	
	// YOU MUST IMPLEMENT THIS METHOD.
	public char[] lowercase(char[] chars) {
		// Transform the word uppercase characters into lowercase.
		String str=new String(chars);
		str = str.toLowerCase();
		return str.toCharArray();
	}

	// YOU MUST IMPLEMENT THIS METHOD.
	public String stem(char[] chars) {
		// Return the stemmed word with Stemmer in Classes package.
		String str=new String(chars);
		Stemmer s = new Stemmer();
		char[] word=str.toCharArray();
		s.add(word, word.length);
		s.stem();
		str=s.toString();
		return str;
	}

}
