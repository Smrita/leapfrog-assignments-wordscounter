package output;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import filewordscounter.*;

public class MainClass 
{

    public static void main(String[] args) throws FileNotFoundException
    {
        Map<String,Integer> wordsFrequency=new HashMap<String,Integer>();
        WordsCounter wordsCounter = new WordsCounter("textFile");
        wordsFrequency=wordsCounter.countFrequency();
        OutputFile file=new OutputFile();
        file.write(wordsFrequency); 

    }
    
    
    
   
    
    

}
