# Insertion Sort

## Example Problem

Given an array ``arr = [a1,a2,a3,a4,a5...,an] `` , we need to sort the array the array with the help of Insertion Sort algorithm.

<hr>

## Discussion

Look at the following list of numbers:
```
36 10 5 23 56 12
```
We scan the array from left to right. For every element in the array, we must ensure that the elements to the left are less than the current element( for sorting in ascending order) and the elements to the right have not yet been seen. 

We take 2 pointers- ``i,j``. We exchange ``arr[i]`` with each larger element to its left. At first, the pointer i is at position 0. So ``arr[0]=36`` is at its correct position since there is there no element to its left.

We then increment the pointer ''i''. The pointer i now points to ``arr[1]=10``. Now the element to the left of 10 is 36. We see that the element 10 is not in its correct position, since there is an element to the left(=36) which is greater than 10. So we exchange their positions. The present array is ``10 36``.

We increment the pointer to point at ``arr[2]=5``. The element 5 is not at its correct position. So we exchange 5 with 36. The current array is ``10 5 36``. The element 5 is still not in its correct position as 10 is greater than 5. So we exchange 10 with 5. The current array becomes ``5 10 36``.

We continue this way.
```
Note: | marks the position of j.
When i=0:
36 | 10 5 23 56 12

When i=1:
36 10 | 5 23 56 12
//36 greater than 10. So we exchange.
10 | 36 5 23 56 12
//Go no further as there is no element to left.

When i=2:
10 36 5 | 23 56 12
//36 grrater than 5. So we exchange.
10 5 | 36 23 56 12
//10 greater than 5 . So we exchange.
5 | 10 36 23 56 12
//5 is at its correct position.

When i=3:
5 10 36 23 | 56 12
//We exchange 36 and 23 as 36>23.
5 10 23 | 36 56 12
//10<23. So we need not go any further.

When i=4:
5 10 23 36 56 | 12
//56 is larger than every element to the left. So no exchange needed.

When i=5:
5 10 23 36 56 12 |
//12 is smaller than 56. So we exchange.
5 10 23 36 12 | 56
//12 is smaller than 36. So we exchange.
5 10 23 12 | 36 56
//12 is smaller than 23. So exchange is needed.
5 10 12 | 23 36 56
//12 is greater than 10. Hence we stop.
```
At this position we stop since we have traversed through the entire array.


<hr>

## Code for the Algorithm

<hr>

### Code For Insertion Sort

```java
public void sort(Comparable []a){
   for(int i=0;i<a.length;i++){
      for (int j = i; j > 0; j--){
         if (less(a[j], a[j-1]))//if element at j is less than the element at j-1
            exch(a, j, j-1);    //we exchange the two elements. 
         else break;
      }
   }

}
```        


