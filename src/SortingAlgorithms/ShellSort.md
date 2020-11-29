# Shell Sort

## Example Problem

Given an array ``arr = [a1,a2,a3,a4,a5...,an] `` , we need to sort the array the array with the help of Shell Sort algorithm.

<hr>

## Discussion

Shell Sort is an improvement in the Insertion sort algorithm. It can be observed that the insertion sort works extremely well on almost sorted array. Shell sort makes use of this. We make the array h-sorted for a large value of h using the technique of insertion sort. We then keep reducing the value of h until it becomes 1. 
#### Note: An array is said to be h-sorted if all sublists of every h'th element is sorted.

<hr>

## Illustration:
<img src="https://github.com/Ahel2000/StarBuzz/blob/master/shell-sort.png"/>

<hr>

## Code for the Algorithm

### Determining the value of h for h-sorting
```java
while(h<n/3)h=3*h+1;
```

### Code For Shell Sort
```java
while(h>=1){
     for(int i=h;i<n;i++){
     //perform insertion sort for every h'th element
         for(int j=i;j>=h && less(a[j],a[j-h]);j-=h){ 
             exch(a,j,j-h);
         }
     }
     h=h/3;
 }
```        
<hr>

## Resources
<a href="https://www.geeksforgeeks.org/shellsort/">GeeksforGeeks</a>


