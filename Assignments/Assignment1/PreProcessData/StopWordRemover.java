package PreProcessData;
import Classes.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.io.FileInputStream;

public class StopWordRemover {
	// Essential private methods or variables can be added.
	private HashSet<String> set = null;
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public StopWordRemover( ) throws IOException {
		// Load and store the stop words from the fileinputstream with appropriate data structure.
		// NT: address of stopword.txt is Path.StopwordDir
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(Path.StopwordDir)));   
		set=new HashSet<String>();
		String line="";
		while ((line= br.readLine()) != null){            	
            	set.add(line);
        }
	}

	// YOU SHOULD IMPLEMENT THIS METHOD.
	public boolean isStopword( char[] word ) {
		// Return true if the input word is a stopword, or false if not.
		String strword= new String(word);
		if(set.contains(strword))		
			return true;
		return false;
	}
}
