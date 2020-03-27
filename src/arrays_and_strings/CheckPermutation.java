package arrays_and_strings;

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
   * Better : Maintain an int sum,
   *          for each char in str1 add it to the sum
   *          simultaneously for each char in str2 subtract it from the sum
   *
   * return true if sum==0 else false
   * */
  
  public static boolean checkPerm(String s1, String s2)
  {
    if (s1 == null || s2 == null)
      return false;
    if (s1.length() != s2.length())
      return false;
    
    int sum = 0;
    
    for (int i = 0; i < s1.length(); i++)
    {
      sum += (int) s1.charAt(i);
      sum -= (int) s2.charAt(i);
    }
    
    return sum == 0;
  }
}
