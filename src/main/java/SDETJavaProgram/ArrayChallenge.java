package SDETJavaProgram;

import io.cucumber.java.sl.In;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayChallenge {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{4,5,5,4,3,8};
        int[] sortArray = new int[]{2,1,5,3,4,8};
       int[] sortedArray = sortNumArray(sortArray);
    //    System.out.println(removeDuplicateNum(arr2));
        System.out.println(searchElement(new int[]{1,2,4,5,6},5));


       // System.out.println(findMissingNumInArray()); //*************


      //  System.out.println(findCommonElement(arr1,arr2));

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("orange");
        arrayList.add("Cherry");
        arrayList.add("Date");
        arrayList.add("Elderberry");
      //  findFirstAndLastElementofArrayList(arrayList);

    }

    public static Set<Integer> findCommonElement(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr1){
            set.add(num);
        }

        HashSet<Integer> commonSet = new HashSet<>();

        for(int num : arr2){
            if(set.contains(num)){
                commonSet.add(num);
            }
        }
        return commonSet;

    }

    public static void findFirstAndLastElementofArrayList(ArrayList<String> ls){

        if(!ls.isEmpty()){
            String firstElement = ls.get(0);
            String lastElement = ls.get(ls.size()-1);
            System.out.println(firstElement);
            System.out.println(lastElement);

        }else {
            System.out.println("arraylist is empty");
        }
    }

    public static int[] sortNumArray(int[] arr){

        // 1 2 3 4 5    temp = 2 , i=1, j=2
        //         i j
        for(int i=0; i<arr.length; i++){
          for(int j=i+1; j<arr.length; j++){
              if(arr[i] < arr[j]){
                  int temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
              }
          }
        }
        return arr;
    }

    public static Set<Integer> removeDuplicateNum(int[] arr){

        HashSet<Integer> hs = new HashSet<>();
        for(int num: arr){
            hs.add(num);
        }
        return hs;

    }
    public static ArrayList<Integer> removeDuplicateFromAnArrayList(ArrayList<Integer> ls){

        Set<Integer> set = new HashSet<>(ls);
        return new ArrayList<>(set);
    }
    //Find missing num ****************************
    //formula ->totalSum = n * (n+1)/2, missing num = totalSum - originalSum
    public static int findMissingNumInArray(){
        int[] arr = new int[]{1,2,4,5,6};

        int n = arr.length + 1; // add missing num
        int totalSum = n * (n+1)/2;
        int arraySum = 0;
        for(int num : arr){
            arraySum += num;
        }
      return  totalSum - arraySum;

    }

    public static int[] findLargestSmallestArray(int[] arr){

        // 3 4 1 5   i<4   max 4

        int max = arr[0];
        int min = arr[0];

        for(int i=1; i<arr.length; i++){
          max = Math.max(max,arr[i]);
          min = Math.min(min,arr[i]);
        }
        int[] result = new int[]{max,min};
        return result;

    }
    public static int searchElement(int[] arr, int target){
        //1,2,4,5,6  target 2
        //bruteFor check arr[each] == target?

        //binarysearch
        //should be sorted
        int midValue = 0; int midIndex = 0; //2
        int start = 0; int end = arr.length-1;
        while(start <= end){
            midIndex = (start + end) / 2;
            midValue = arr[midIndex]; //1
            if(target == midValue){
                return midIndex;
            }else if(target > midValue){
                start = midIndex + 1;
            }else{
                end = midIndex -1;
            }
        }
        return -1;

    }







}
