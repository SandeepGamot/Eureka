package arrays_and_strings.extras;

import java.util.Random;

public class StringUtils
{
  public String generateRandomString(int len)
  {
    Random r = new Random();
    StringBuilder sb = new StringBuilder();
  
    for(int i=0; i<len; i++)
    {
      int c = 65 + r.nextInt(122-65)+1; //get random int from[65-122] ASCII of A to z
      
      sb.append((char)c); // convert ascii int to char
    }
    return sb.toString();
  }
  
  public static String genAnagram(String s, int rounds)
  {
    StringBuilder sb = new StringBuilder(s);
    Random r = new Random();
    
    for(int i=0; i<rounds; i++)
    {
      int start = r.nextInt(s.length());
      int end = r.nextInt(s.length());
      char temp = sb.charAt(start);
      sb.setCharAt(start,sb.charAt(end));
      sb.setCharAt(end,temp);
    }
    
    return sb.toString();
  }
}
