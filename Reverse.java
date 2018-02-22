import java.util.*; 
import java.io.*;

class Reverse {  
  public static String FirstReverse(String str) { 
    int i = 0;
    int j = str.length() - 1;
    char[] arr = str.toCharArray();
    char temp;
    while(i < j){
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
    return new String(arr);
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(FirstReverse(s.nextLine())); 
  }   
  
}
