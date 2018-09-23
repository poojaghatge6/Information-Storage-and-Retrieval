package PreProcessData;

import java.io.IOException;
import java.util.Map;
import Classes.Path;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
/**
 * This is for INFSCI 2140 in 2018
 *
 */
public class TrectextCollection implements DocumentCollection {
	// Essential private methods or variables can be added.
	private BufferedReader br;
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public TrectextCollection() throws IOException {
		// 1. Open the file in Path.DataTextDir.
		// 2. Make preparation for function nextDocument().
		// NT: you cannot load the whole corpus into memory!!
		br= new BufferedReader(new InputStreamReader(new FileInputStream(Path.DataTextDir))); 
		
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public Map<String, Object> nextDocument() throws IOException {
		// 1. When called, this API processes one document from corpus, and returns its doc number and content.
		// 2. When no document left, return null, and close the file.
		Map<String, Object> document = new HashMap<String, Object>();
		 String content="";
		 String line="";
		 String docno="";
		 while ( (line= br.readLine()) != null && !line.contains("<DOCNO>")){
            	; // keep reading until you find docno
	     }
		 //if you dont find document number then return null
		 if(line==null)
			return null;
		 else 
			docno=line.substring(8,24);
		
		 while((line= br.readLine()) != null && !line.contains("<TEXT>")){
            	; // keep reading until you find start of doc
	     }
		 //if you dont find start of content then return null
		 if(line==null) 
			 return null;
		 else // if you find start of content then keep reading until you reach end of content
		 {
			while((line= br.readLine()) != null && !line.contains("</TEXT>") ){
					content=content+line;
				} 
		 }
		 document.put(docno,content.toCharArray());
		 if (document.isEmpty()==true)
			return null;
		 return document;
	}
	
}
