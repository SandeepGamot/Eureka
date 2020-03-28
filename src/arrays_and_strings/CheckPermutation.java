package arrays_and_strings;
import java.util.HashMap;
public class CheckPermutation
{
  /*
   *
   *  Problem: Given two strings check if one of them is permutation of other.
   *
   *  Approach 1 : Sort both the strings and check if both are equal.
   *              Time: O(N logN)
   *              Space: O(1)
   *
   * Better : Maintain an Char Integer Map,
   *          for each char in str1 add it to the map and maintain it's count.
   *          simultaneously for each char in str2 subtract it from the count in the map.
   * */
  
  public static boolean checkPerm(String s, String t)
  {
    if (s == null || t == null)
      return false;
    if (s.length() != t.length())
      return false;
    
    HashMap<Character, Integer> map = new HashMap<>();
    
    for (char c : s.toCharArray())
    {
      if (map.containsKey(c))
      {
        int count = map.get(c);
        
        map.replace(c, ++count);
      } else
        map.put(c, 1);
    }
    
    for (char c : t.toCharArray())
    {
      if (!map.containsKey(c))
        return false;
      
      int count = map.get(c);
      if (count <= 0)
        return false;
      map.replace(c, --count);
    }
    
    return true;
  }
}
