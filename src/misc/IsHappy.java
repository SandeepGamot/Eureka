package misc;

public class IsHappy
{
  /*
   * Problem: A happy number is a number defined by the following process:
   *  Starting with any positive integer, replace the number by the sum of the squares of its digits,
   * and repeat the process until the number equals 1 (where it will stay),
   *  or it loops endlessly in a cycle which does not include 1.
   * Those numbers for which this process ends in 1 are happy numbers.
   *
   *
   *  Best Approach : Using the fast and slow pointer technique. (Use this technique whenever:
   *     there are anything related to uncertain length loops, finding loops, or anything that can go into logical or mathematical loops)
   *
   * Here two ints are made to loop through the algorithm as there are great chances of getting into a endless loop,
   * the exit condition is reached when both th ints are equal. This will only happen when either the both equal one or a both are stuck in an endless loop
   * So when both are equal return slow==1
   *
   *
   *
   *
   *
   *
   *
   * */
  public static boolean isHappy(int n) {
    int slow = n;
    int fast = n;
  
    do {
      slow = HappySq(slow);
      fast = HappySq(HappySq(fast));
    } while (slow!=fast);
    return slow == 1;
  }
  
  private static int HappySq(int n) {
    int num = 0;
    while(n != 0) {
      num = num + (n%10) * (n%10);
      n= n/10;
    }
    return num;
  }
}
