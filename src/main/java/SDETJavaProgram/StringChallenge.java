package SDETJavaProgram;

import java.util.*;

public class StringChallenge {

    public static void main(String[] args) {

       // System.out.println(reverseString("understand"));
       // System.out.println(reverseEachWord("Java is good programming languages"));
      //  System.out.println(checkNumOfWord("Welcome to Java World"));
      //  System.out.println(isAnagrams("listen","silent"));
       // removeSpace("Java Autom ation");
      // swapTwoString("this is first", "this is two");
    //   separateLettersAndDigits("Subbu123raj");
       // moveZeroToBack("32400121200");
        System.out.println(findLongestNonRepeatChar("pwwkew"));



    }

    public static String StringChallenge(String str){

        // check each chr is int >0 <9?
        // if int -> then check in set whether it contains
        // --> if yes_. return false
        // add into Set if not contains
        //if ch == ' ' check Set size > or < 3 return false
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int ci = c - '0';
            System.out.print(ci+ " ");
            if(ci >=0 && ci<= 9){
                if(!hs.add(ci) ){
                    return "false";
                }
            }
        }
        System.out.println(hs.size());
        if(hs.size() != 3){
            return "false";
        }
        return "true";
    }
    //Permutation of String ****************
    public static void permutationOfString(String str){


        String rem = "";
        for(int i=0; i<str.length(); i++){
            rem = str.substring(0,i) + str.substring(i+1);
            //recusive call

        }
    }


    //1. Reverse a String
    public static String reverseString(String str){
        /* str = "this is me"
        String reverseString = "";
        for(int i=str.length()-1; i>=0; i--){
            reverseString += str.charAt(i);
        }
        return reverseString;

         */

        char ch;
        String nstr = "";
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            nstr = ch + nstr;  //em si siht  --->other way
        }
        return nstr;
    }

    /*
    reverse Each word of a given String
    Input: Java is good programming langauges
    Output: avaJ si doog gnimmargorp seguagnal

     */
    public static String reverseEachWord(String inputString){
        String[] str = inputString.split(" ");

        String reverseString = "";

        for(String word : str){
            String rw = "";
            for(int i=word.length()-1; i>=0; i--){
                 rw += word.charAt(i); //avaJ
            }
            reverseString = reverseString + rw +" ";//avaJ si doog
        }
        return reverseString;
    }
//find Duplicate character in String
/*
Duplicate Characters in : Learn Java Programming
a : 4
g : 2
m : 2
n : 2
r : 3
 */
    public static void checkCharFrequency(String input){

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c != ' '){
                if(hm.containsKey(c)){
                    hm.put(c,hm.get(c)+1);
                }else {
                    hm.put(c,1);
                }
            }
        }
        for(Character c : hm.keySet()){
            if(hm.get(c)>1) {
                System.out.println(c + ": " + hm.get(c));
            }
        }
    }
    //Count number of word in a string
    public static int checkNumOfWord(String str){
        //if we found space-> workCount++
        int wordCount = 1;
        if(str == "" || str == " "){
            return -1;
        }else{
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == ' ' && str.charAt(i+1) != ' '){ //***********
                    wordCount++;
                }
            }
        }

        return wordCount;
    }
    //check String is Palindrome
    public static boolean isPalindrome(String str){
        // maam
        int start = 0; int end = str.length()-1;
        while(start < end){ //***
            if(str.charAt(start) !=  str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // check 2 strings are Anagrams?
    public static boolean isAnagrams(String str1, String str2){

        if(str1.length() != str2.length()){
            return false;
        }else{
            int[] arr = new int[26];

            for(int i=0; i<str1.length(); i++){

                arr[str1.charAt(i)-'a']++; // for
                arr[str2.charAt(i)-'a']--;
            }
            for(int count : arr){
                if(count != 0){
                    return false;
                }
            }
        }

        return true;

    }
    //print unique characters
    public static void printUniqueChars(String str){ //input java Automation
        HashSet<Character> hs = new HashSet<>(); //output  aAtuviJmno
        LinkedHashSet<Character> lhs = new LinkedHashSet<>(); //Jav Automin (insertion order)
        for(int i=0; i<str.length(); i++){
            hs.add(str.charAt(i));
        }
        for(char c : hs){
          //  System.out.print(c);
        }

        boolean[] unique = new boolean[128];
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(!unique[ch]){
              unique[ch] = true;
                System.out.print(ch+" ");
            }
        }

    }
    //Java program to remove space from a given String
    public static void removeSpace(String str){

        StringBuilder removeString = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != ' '){
                removeString.append(str.charAt(i));
            }
        }
        System.out.println(removeString);

    }


//Java program to swap two string without using 3rd variable
    //str1+str2, use subString method
    public static void swapTwoString(String str1, String str2){

        str1 = str1 + str2;
        str2 = str1.substring(0,str1.length() - str2.length());
        str1 = str1.substring(str2.length());
        System.out.println(str1+" "+str2);
    }

    /*
    Java program to gives two Output:
“Subburaj”, “123” for the Input
String Str = “Subbu123raj”
     */

    public static void separateLettersAndDigits(String str){
       char[] charr = str.toCharArray();
       StringBuilder letters =new StringBuilder();
        StringBuilder digits =new StringBuilder();

       for(int i=0; i<charr.length; i++){
           if(Character.isLetter(charr[i])){
               letters.append(charr[i]);
           }else {
             digits.append(charr[i]);
           }
       }
        System.out.println(letters);
        System.out.println(digits);
    }

    /*
    Java program to gives Output:
“32412120000” for the Input
String Str = “32400121200”
     */
    public static void moveZeroToBack(String input){
        int len = input.length();
        int zeroCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
           int temp = input.charAt(i) - '0';
            if(temp != 0 ){
                sb.append(input.charAt(i));
            }else{
                zeroCount++;
            }
        }
        while(zeroCount > 0){
            sb.append("0");
            zeroCount--;
        }
        System.out.println(sb);
    }

    /*
    Java program to gives Output:
“00003241212” for the Input
String Str = “32400121200”
     */

    /*
    Java program to find the longest without
repeating characters
     */
    public static int findLongestNonRepeatChar(String input){
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int start = 0;
        int end = 0;

        while(end < input.length()){
            char currentChar = input.charAt(end);
            if(!set.contains(currentChar)){
                set.add(currentChar);
                System.out.println("after added"+set);
                maxLength = Math.max(maxLength,end - start+1);
                end++;
            }else{
                set.remove(input.charAt(start));
                System.out.println("after removed"+set);
                start++;
            }
        }
        return maxLength;
    }


}
