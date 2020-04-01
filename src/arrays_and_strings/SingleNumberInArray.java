package arrays_and_strings;

public class SingleNumberInArray
{
  
  /*
  * Problem : Given a non-empty array of integers, every element appears twice except for one. Find that single one.
  *           Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
  *
  *
  *
  * An ok solution is to use Set:
  *           For every element :
  *                         if present? remove
  *                         else add
  *           After exiting for loop:
  *                   the set must have only one item if yes return that num else return -1
  *
  *   The time on this in O(N) obv, but the possible space O(N) is undesirable.
  *
  *
  *
  * The best approach uses bit magic:
  *                   have an int variable ans
  *                   For every element:
  *                             "Logically XOR" it with the ans
  *
  *                   return ans
  *
  *
  * Why does this work? This uses the fact that "Logically XOR ing" the same 2 numbers will always result in 0
  * i.e if 2 number appear as a pair in an array they will cancel out each other
  *     and the result will be the number that was not in a pair.
  *
  *
  *
  *
  *
  *
  * */
  public static void main(String[] args)
  {
    System.out.println(singleNumber(new int[]{4,1,2,1}));
  }
  
  public static int singleNumber(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    
    int n = nums.length;
    int ans = 0;
    for(int i=0; i<10; i++) {
      ans ^= nums[i];
    }
    
    return ans;
  }
  
}
