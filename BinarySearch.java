package com.dsa;

public class Main {

    public static void main(String[] args) {

        int[] arrAsc={ 0,1,2,3,4,5,6};
        int[] arrDesc={ 6,5,4,3,2,1,0};
        int target=0;
        System.out.println( orderAgnosticBS(arrDesc,target));
    }

// Simple Binary Search
    static int BS(int[] arr, int target){

        int start=0;
        int end = arr.length-1;

        int mid;

        while(start <=end){
// To find middle of the array 
           mid = start + (end-start)/2;
          
           if(target==arr[mid])
               return mid;
           else if(target <arr[mid])
                end=mid-1;
            else if(target >arr[mid])
                start=mid+1;


        }

        return -1;
    }

  // Below binary search code works for both Asceding and Descending order array
    static int orderAgnosticBS(int[] arr, int target) {

           int start =0;
           int end=arr.length-1;
           int mid;

           while(start<= end){

               mid=start + (end-start)/2;

               if(target ==arr[mid])
                   return mid;
               else {
                   if (arr[start] < arr[end]) {
                    if(target < arr[mid])
                        end =mid-1;
                    else
                        start=mid+1;


                   } else {

                       if(target > arr[mid])
                           end =mid-1;
                       else
                           start=mid+1;
                   }
               }
           }
           return -1;
    }
}
