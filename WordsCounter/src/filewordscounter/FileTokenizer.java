package filewordscounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * breaks the content of a file to array of String and returns 
 * an arraylist containing the strings.
 * @author smrita
 *
 */
public class FileTokenizer
{
	/**
	 *File to be tokenized
	 */
	File file;

	public FileTokenizer(File file) 
	{
		this.file = file;
	}

	/**
	 * Retrieves content of a file line by line,converts them
	 * into an array of strings,adds each array element to an 
	 * arraylist of string .
	 * @return ArrayList of strings
	 * @throws FileNotFoundException
	 *          Exception is thrown if File is not found
	 */
	public ArrayList<String> tokenizeFile() throws FileNotFoundException 
	{
		ArrayList<String> fileWordList = new ArrayList<String>();
		String[] wordss = null;

		Scanner input = new Scanner(this.file);
		while (input.hasNextLine()) 
		{
			String line = input.nextLine();
			System.out.println("line\t" + line);
			wordss = line.split("\\W+");
			for (int i = 0; i < wordss.length; i++) 
			{
				fileWordList.add(wordss[i]);

			}
		}
		return fileWordList;

	}

}
