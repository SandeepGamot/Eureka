package arrays_and_strings;

import java.util.HashSet;
import java.util.List;

public class IsUnique
{
  /*
   * Problem : Check if all the chars in a String or values in an Array are distinct i.e unique.
   *
   * BCR: O(N)
   *
   * Naive Approach: O(N^2) for each char check if other is present
   *
   * A better approach: O(N logN) sort the String or array, check 2 consecutive elements.
   *
   * Even better: Time: O(N) and Space: O(N) Use HashSet keep adding to the set, if some value already exists return false
   *
   * Best Approach: O(N) and O(1) Use an int field like boolean array(see "damn_good_tricks" folder for more details).
   * The idea here is to maintain an int field lets call it checker.
   * Iterate over the chars of string.
   * for each char:
   *  int value =  subtract the char from 'a' (ASCII value)
   *  now the trick here is that every alphabet is unique and subtracting it from ASCII 'a' will always give unique value for
   *  every alphabet, this can also be applied to any set.
   *  we right shift 1 by the value and 'logically AND' it with the checker int field. So for same char the value will be same and
   *  if the char is already registered then 'logical AND' will give a value more than 0. if that's the case then return false as the same
   *  char is already encountered.
   *  else register the char into the checker field by 'logical OR'ing the checker with right-shifted 1 by the value.
   *
   * return true if the loop is exhausted.
   *
   *
   *
   * */
  
  public static boolean isUniqueBest(String str) {
    if (str.length() > 26) { // Only 26 characters
      return false;
    }
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) return false;
      checker |= (1 << val);
    }
    return true;
  }
  
  public boolean isUnique(String str)
  {
    HashSet<Character> set = new HashSet<>();
    
    for(int i=0; i<str.length(); i++)
    {
      if(!set.add(str.charAt(i)))
        return false;
    }
    return true;
  }
  
}
