# Selection Sort

## Example Problem

Given an array ``arr = [a1,a2,a3,a4,a5...,an] `` , we need to sort the array the array with the help of Selection Sort algorithm.

---------------

## Discussion
``
Selection sort is a simple sorting algorithm where we divide an array into two parts- sorted and unsorted. Initially the sorted part is empty. We find the smallest element of the unsorted part. Then we swap it with the leftmost element of the unsorted part. The leftmost element then becomes a member of the sorted part. 
<p>
<img src="https://user-images.githubusercontent.com/66062504/99956054-614c9b00-2dab-11eb-81d1-c53c51fd776b.jpeg" alt="selection"/>
</p>

-----------

### Code For Selection Sort
```java
public static void sort(Comparable a[])
    {
        // initialise instance variables
        for(int i=0;i<a.length;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(less(a[j],a[min])){//if a[j] less than min
                    min=j;             //then update position of min
                }
            }
            exch(a,i,min);//swap the i-th element with the minimum element
        }
    }
    
```        
### Resources:
<a href="https://www.hackerearth.com/practice/algorithms/sorting/selection-sort/tutorial/">HackerEarth</a>
