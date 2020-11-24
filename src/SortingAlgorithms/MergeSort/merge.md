# Merge Sort

## Example Problem

Given an array ``arr = [a1,a2,a3,a4,a5...,an] `` , we need to sort the array the array with the help of Merge Sort algorithm. 

---------------

## Discussion

Merge sort is an application of the Divide and Conquer Principle.The basic approach is to:
- Divide the array into two halves
- Sort each half recursively
- Merge the two halves
<p>
<img src="https://user-images.githubusercontent.com/66062504/99971682-89e08f00-2dc3-11eb-9860-973c837e0e6f.png"/>
</p>

-----------

### Code For Merge Sort

Merge Sort:
```java
public static void mergesort(Comparable[] workplace,int lowerbound,int upperbound){
        if(lowerbound==upperbound){
            return;
        }
        else{
        int mid=(lowerbound+upperbound)/2;
        mergesort(workplace,lowerbound,mid);
        mergesort(workplace,mid+1,upperbound);
        merge(workplace,lowerbound,mid+1,upperbound);
        }
    }
    
```  
Merging two sorted arrays:
```java
public static void merge(Comparable[] workplace,int lowPtr,int highPtr,int upperbound)
    {
        int low=lowPtr;
        int mid=highPtr-1;
        int j=0;
        int n=upperbound-low+1;
        while(low<=mid && highPtr<=upperbound){
           if(theArray[low].compareTo(theArray[highPtr])<0){
               workplace[j++]=theArray[low++];
            }else{
                workplace[j++]=theArray[highPtr++];
            }
        }
        
        while(low<=mid){
            workplace[j++]=theArray[low++];
        }
        
        while(highPtr<=upperbound){
            workplace[j++]=theArray[highPtr++];
        }
        
        for(j=0;j<n;j++){
            theArray[lowPtr+j]=workplace[j];
        }
    }
```

### Time Complexity:
Time complexity of Merge Sort is O(n*Log n) in all the 3 cases (worst, average and best) as merge sort always divides the array in two halves and takes linear time to merge two halves. It requires equal amount of additional space as the unsorted array.

### Resources:
<a href="https://www.geeksforgeeks.org/merge-sort">GeeksforGeeks</a>

