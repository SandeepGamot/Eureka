package arrays_and_strings;

public class RotateMatrix
{
  public static void main(String[] args)
  {
    int n = 5;
    int[][] matrix = new int[n][n];
    int count = 0;
    for (int i = 0; i < matrix.length; i++)
    {
      for (int j = 0; j < matrix[0].length; j++)
      {
        matrix[i][j] = ++count;
      }
    }
    System.out.println("Before :");
    printMat(matrix);
    RotateMatrix.rotateBy90(matrix);
    System.out.println("After:");
    printMat(matrix);
    System.out.println("180:");
    RotateMatrix.rotateBy180(matrix);
    printMat(matrix);
  }
  
  public static void printMat(int[][] mat)
  {
    int n = mat.length;
    int m = mat[0].length;
    
    for (int i = 0; i < n; i++)
    {
      System.out.print("[ ");
      for (int j = 0; j < m; j++)
      {
        System.out.print(mat[i][j] + " ");
      }
      System.out.print("]");
      System.out.println();
    }
  }
  
  private int[][] transpose(int[][] matrix)
  {
    int n = matrix.length;
    int m = matrix[0].length;
    
    for (int i = 0; i < n; i++)
    {
      for (int j = i; j < m; j++)
      {
        if (i != j)
        {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }
    }
    return matrix;
  }
  
  private int[][] flip(int[][] matrix)
  {
    int n = matrix.length;
    
    for (int i = 0; i < n; i++)
    {
      int l = 0;
      int r = matrix[0].length - 1;
      
      while (l < r)
      {
        int temp = matrix[i][l];
        matrix[i][l] = matrix[i][r];
        matrix[i][r] = temp;
        l++;
        r--;
      }
    }
    return matrix;
  }
  
  public static int[][] rotateBy90(int[][] matrix)
  {
    RotateMatrix o = new RotateMatrix();
    return o.flip(o.transpose(matrix));
  }
  
  public static int[][] rotateBy180(int[][] matrix)
  {
    RotateMatrix o = new RotateMatrix();
    return o.flip(rotateBy90(matrix));
  }
}
