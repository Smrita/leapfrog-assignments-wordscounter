package filewordscounter;




import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import userdefineddatastructure.*;

/**
 *
 * @author Smrita
 */
public class WordsCounter
{

    String fileName;


    public WordsCounter(String fileNamee)
    {
         fileName=fileNamee;
    }
    
    /**
     * Converts File to arraylist of string
     * {@link FileTokenizer}
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<String> convertFileToList() throws FileNotFoundException
    {
        File file = new File(fileName);
        ArrayList<String> fileWordsList = new ArrayList<String>();
        FileTokenizer tokenizer=new FileTokenizer(file);
        fileWordsList=tokenizer.tokenizeFile();
        return fileWordsList;
    }

    public TreeMap<String,Integer> countFrequency() throws FileNotFoundException 
    {
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        ArrayList<String> listOfWords = new ArrayList<String>();
        TreeMap<String,Integer> sortedMap = null;
      
        listOfWords = convertFileToList();
        int loopSize = listOfWords.size();
       
        for (int outerIndex = 0; outerIndex < loopSize ; outerIndex++) 
        {

            WordFrequency wordFreq = new WordFrequency();
            wordFreq.word = listOfWords.get(outerIndex).toUpperCase();
            wordFreq.frequency = 1;
            for (int index = 0; index < loopSize; index++) 
            {
                if (outerIndex != index)
                {
                	String checkString = listOfWords.get(index).toUpperCase();
                    String originalString = wordFreq.word.toUpperCase();
                    if (originalString.matches(checkString))
                    {
                        wordFreq.frequency++;

                    }
                }
            }

            wordsMap.put(wordFreq.word, wordFreq.frequency);
            wordFreq = new WordFrequency();

        }
              sortedMap=sortHashMap(wordsMap);
              System.out.println(sortedMap.values()+"\t"+sortedMap.keySet());
              return sortedMap;

    }
    
    public TreeMap<String, Integer> sortHashMap(Map<String,Integer> wordsMap)
    {
    
        ValueComparator valueComp=  new ValueComparator(wordsMap);
        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(valueComp);
        sorted_map.putAll(wordsMap);
        return sorted_map;
    }
}