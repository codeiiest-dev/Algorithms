# Quick Sort

## Example Problem

Given an array ``arr = [a1,a2,a3,a4,a5...,an] `` , we need to sort the array the array with the help of Quick Sort algorithm.

<hr>

## Discussion

So the basic idea behind Quick Sort is to take an element generally called the **pivot** and place it at such a place such that it is in it's sorted position.

Look at the following list of numbers:
```
10 36 15 23 56 12
```
Can you guess the number at the sorted position ? Yes it can be identified by just at glance , that is 10.

Now Let's take another example:

```
40 36 15 50 75 62 57
```
Now we can see that 50 is at it's sorted poition by just a glance.
This is because all the elements before it is less than 50 and all elemnts after it is greater than 50.

So , the main idea is to select a **pivot** and place it to it's sorted position.

<hr>

## Working of the Algorithm

Let us take an example with the list of integers
```
50 70 60 90 40 80 10 20 30
```
Let us take the first element to be pivot that is 50.

Take two pointers ``i , j`` . Initially place ``i`` at the pivot i.e. index 0 and ``j`` at position n and keep a number (say infinite) at index n.

So, it looks like :
```
50 70 60 90 40 80 10 20 30 INT_MAX
i                          j
```

Now iterate i towards right and j towards left . Stop when ``arr[i]>pivot`` and ``arr[j]<=pivot`` . If ``i < j`` swap the values . Continue the process until `i>j` . Whwn this case arrives swap the **pivot** with ``arr[j]``. 

### Illustration

```
50 70 60 90 40 80 10 20 30 INT_MAX
   i                    j

// Here arr[i]>=50 and arr[j]<50 , so we swap them and move the pointers since i<j.

50 30 60 90 40 80 10 20 70 INT_MAX
      i              j

// Swapping again , and moving pointers.

50 30 20 90 40 80 10 60 70 INT_MAX
         i        j

// Swapping again , and moving pointers.

50 30 20 10 40 80 90 60 70 INT_MAX
            j  i

// Now we see j<i , so we stop the loop and swap arr[j] with pivot.

40 30 20 10 50 80 90 60 70 INT_MAX
            __
```
Now , we see that all elements before 50 are lesser than 50 and all elemnts after 50 are greater than 50. 

Now apply this partitioning on both sides of 50 and hence, we will get our sorted array.

<hr>

## Code

### Code For Partition
```cpp
int partition(int a[],int l ,int h)
{
    int pivot = a[l]; // choosing left-most elemnt to be pivot
    int i=l,j=h;    // setting pointers i and j

    //looping through the process until we get j<i
    do{
        // iterating i until we get a number greater than pivot
        while(a[++i]<=pivot);

        // iterating j until we get a number greater than pivot
        while(a[--j]>pivot);

        //swapping arr[i] and arr[j]
        if(i<j){
            swap(a[i],a[j]);
        }
        
    }while(i<j);

    // swapping pivot
    swap(a[j],a[l]);

    //return partition point
    return j;
}
```

### Code for Quick Sort.
```cpp
void QuickSort(int a[],int l,int h)
{
    int j;
    if(l<h)
    {
        j=partition(a,l,h); // taking the partition point
        QuickSort(a,l,j);   // Sorting the left side
        QuickSort(a,j+1,h); // Sorting right side
    }
}
```
<hr>

## Time Complexity


| Worst Case  | Best Case  | Average Case  |
|:-----------------:|:-----------------:|:-----------------:|
|  O ( n<sup>2</sup> ) |  O ( nlog<sub>2</sub>n ) | O ( nlog<sub>2</sub>n ) |

**Worst Case** : The worst case occurs when the partition process always picks greatest or smallest element as pivot. If we consider above partition strategy where first element is always picked as pivot, the worst case would occur when the array is already sorted in increasing or decreasing order.

**Best Case**: The best case occurs when the partition process always picks the middle element as pivot. 

<hr>

Other Resources : [GFG Blog](https://www.geeksforgeeks.org/quick-sort/)