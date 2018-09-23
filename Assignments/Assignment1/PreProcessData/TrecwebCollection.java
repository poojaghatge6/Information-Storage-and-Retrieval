package PreProcessData;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import Classes.Path;

/**
 * This is for INFSCI 2140 in 2018
 *
 */
public class TrecwebCollection implements DocumentCollection {
	// Essential private methods or variables can be added.
	private BufferedReader br;
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public TrecwebCollection() throws IOException {
		// 1. Open the file in Path.DataWebDir.
			br= new BufferedReader(new InputStreamReader(new FileInputStream(Path.DataWebDir))); 
		// 2. Make preparation for function nextDocument().
		// NT: you cannot load the whole corpus into memory!!
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public Map<String, Object> nextDocument() throws IOException {
		// 1. When called, this API processes one document from corpus, and returns its doc number and content.
		// 2. When no document left, return null, and close the file.
		// 3. the HTML tags should be removed in document content.
		 Map<String, Object> document = new HashMap<String, Object>();
		 String content="";
		 String line="";
		 String docno="";
		 while ( (line= br.readLine()) != null && !line.contains("<DOCNO>")){
            	; // keep reading until you find docno
	     }
		 if(line==null)
			return null;
		 else 
			docno=line.substring(7,24);
		 while((line= br.readLine()) != null && !line.contains("</DOCHDR>")){
            	; // keep reading until you find start of content
	     }
		 //if you dont find start of the content then return null
		 if(line==null) 
			 return null;
		 else //if you find start of the content then read until you reach end of content
		 {
			while((line= br.readLine()) != null && !line.contains("</DOC>") ){
					line=line.replaceAll("<[^>]*>|<[^>]*|[^<]*>|&gt;|<!--(.*?)-->", "");
					content=content+line;
				} 
		 }
		//add the map to the document map
		 document.put(docno,content.toCharArray());
		 if (document.isEmpty()==true)
			return null;
		 return document;
	
	 }
		 
	
}
