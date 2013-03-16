package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
/**
 * Displays top five repeated words in a html file
 * @author smrita
 *
 */
public class OutputFile
{
	/**
	 * Stores no of words to be displayed
	 */
	final int NO_OF_WORDS=5;
	/**
	 * Holds name of the file where top five words are to be written 
	 */
	String fileName;
	/**
	 * Variable of type File
	 */
	File file;
	/**
	 * 
	 * @param resultMap
	 *         A datastructure which holds words and their frequency .
	 *         Words are keys while their frequencies are stored as values 
	 */
	
	public void write(Map<String,Integer> resultMap)
	{
		fileName="topfivewords.html";
		file=new File(fileName);
		String fileContent=makeContent(resultMap);
		
	    injectContent(fileContent);
	    
	    
	}
	/**
	 * inserts top five repeated words to a file
	 * @param content
	 */
	
	 public void injectContent(String content)
	    {
	             try {
	                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	                        
	                   
	                            
	                                bw.write(content);
	                                bw.newLine();
	                       
	                        
	                         bw.close();
	                } catch (Exception e) {
	                }

	    }
	 public String makeContent(Map<String,Integer> resultMap)
	 {
		   String fileContent="Top Five Words";
	       fileContent+="\n\n\nWORDS\t\t\tVALUES\n";
	       Object[] keys=resultMap.keySet().toArray();
           Object[] values=resultMap.values().toArray();
  
           for(int index=0;index<NO_OF_WORDS;index++)
           {
        	   fileContent+=keys[index];
        	   fileContent+="\t\t\t";
        	   fileContent+=values[index];
        	   fileContent+="\n";
           	}
           return fileContent;
		 
	 }
	 
	 public void openHtml() throws URISyntaxException, IOException
	    {

	       // Runtime.getRuntime().exec("hh.exe form.html");/for windows
	          Runtime.getRuntime().exec("firefox topfivewords.html");//for linux
	    }

}
