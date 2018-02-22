/*
CoderByte.com problem:

Have the function LetterChanges(str) take the str parameter being passed and modify it using the following algorithm. Replace every letter in the string with the letter following it in the alphabet (ie. c becomes d, z becomes a). Then capitalize every vowel in this new string (a, e, i, o, u) and finally return this modified string. 
*/


import java.util.*; 
import java.io.*;

class LetterChanges {  
  public static String LetterChanges(String str) { 
      List<Integer> vowels = Arrays.asList(65, 69, 73, 79, 85, 97, 101, 105, 111, 117);
      char temp;
      int tempVal;
      char[] arr = str.toCharArray();
      for(int i=0; i < arr.length; i++){
          temp = arr[i];
          tempVal = (int) temp + 1;
          if(!Character.isLetter(temp)){
              continue;
          } else if(tempVal > 122){
              tempVal = 65;
          } else if(vowels.contains(tempVal)){
              tempVal -= 32;
          }
          arr[i] = (char) tempVal;
      }
      return String.valueOf(arr);
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(LetterChanges(s.nextLine())); 
  }   
  
}
