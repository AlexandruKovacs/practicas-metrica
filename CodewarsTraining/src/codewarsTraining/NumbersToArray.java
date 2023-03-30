package codewarsTraining;

public class NumbersToArray {

  public static int[] digitize(long n) {
	  
	  String longStr = Integer.toString((int) (n));
	  int[] array = new int[longStr.length()];
	  
	  for (int i = 0; i < longStr.length(); i++) {
		  array[i] = longStr.charAt(i) - '0';
	  }
	  
	  for(int j = 0; j < array.length / 2; j++) {
		  
	      int temp = array[j];
	      array[j] = array[array.length - j - 1];
	      array[array.length - j - 1] = temp;
	  }
	  
	  return array;
  }
}
