package filewordscounter;

import java.util.Comparator;
import java.util.Map;

/**
 * Implements {@link java.util.Comparator} to compare values of a map
 * and to sort the map by its values in descending order
 * 
 * @author smrita
 *
 */
class ValueComparator implements Comparator<String> {

	/**
	 * A variable of type Map that holds key of strings and values of Integer
	 */
    Map<String, Integer> base;
    public ValueComparator(Map<String, Integer> base) 
    {
        this.base = base;
    }
   /**
    * @param key of string, key of string
    * Compares the values represented by keys and sorts them in descending order
    *  
    */     
  public int compare(String a, String b)    // Note: this comparator imposes orderings that are inconsistent with equals.    
   {
        if (base.get(a) >= base.get(b)) 
        {
            System.out.println("base.geta\t"+base.get(a));
            return -1;//descending Order
        } else {
            return 1;//descending order
            
        } 
        
        
    }
}