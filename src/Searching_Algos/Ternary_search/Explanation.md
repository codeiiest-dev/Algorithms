# Ternary Search

It is a divide-and-conquer algorithm, similar to binary search, only that we divide the array in three parts using mid1 and mid2, and the array should be sorted. 

## Problem Statement

Given an array `arr[]` of n elements in `sorted` order, write a function to search a given element `x` in `arr[]`.(Array indexing 0-based, i.e,  `[0,1,...,n-1]` where n is the size of the array). If `x` is not present in the array return `-1`.

## Solution

Let the given array be 

> 1 &nbsp;&nbsp; | &nbsp;&nbsp; 2 &nbsp;&nbsp; | &nbsp;&nbsp; 3 &nbsp;&nbsp; | &nbsp;&nbsp; 4 &nbsp;&nbsp; | &nbsp;&nbsp; 5 &nbsp;&nbsp; | &nbsp;&nbsp; 6 &nbsp;&nbsp; | &nbsp;&nbsp; 7 &nbsp;&nbsp; | &nbsp;&nbsp; 8 &nbsp;&nbsp; | &nbsp;&nbsp; 9 &nbsp;&nbsp; | &nbsp;&nbsp; 10

and the value to be searched be &nbsp; `x = 6`

First determine the left and right ends of the array

> left = 0, right = 9 [n(size of array) - 1]
> <p>Thus, mid1 = left + ( right - left ) / 3, and</p>
> <p>mid2 = mid1 + ( right - left ) / 3</p>
> 
><p>left&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mid1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mid2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;right</p> 
> \/ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\/
> <p>1 &nbsp;&nbsp; | &nbsp;&nbsp; 2 &nbsp;&nbsp; | &nbsp;&nbsp; 3 &nbsp;&nbsp; | &nbsp;&nbsp; 4 &nbsp;&nbsp; | &nbsp;&nbsp; 5 &nbsp;&nbsp; | &nbsp;&nbsp; 6 &nbsp;&nbsp; | &nbsp;&nbsp; 7 &nbsp;&nbsp; | &nbsp;&nbsp; 8 &nbsp;&nbsp; | &nbsp;&nbsp; 9 &nbsp;&nbsp; | &nbsp;&nbsp; 10</p>

As, `x > arr[mid1]` and `x < arr[mid2]`

> left = mid1 (4), <p>right = mid2 (7),</p><p> mid1 = 5,</p> <p> mid2 = 6 </p>

><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;left&nbsp;&nbsp;&nbsp;mid1&nbsp;&nbsp;&nbsp;mid2&nbsp;&nbsp;&nbsp;right&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p> 
>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> <p>1 &nbsp;&nbsp; | &nbsp;&nbsp; 2 &nbsp;&nbsp; | &nbsp;&nbsp; 3 &nbsp;&nbsp; | &nbsp;&nbsp; 4 &nbsp;&nbsp; | &nbsp;&nbsp; 5 &nbsp;&nbsp; | &nbsp;&nbsp; 6 &nbsp;&nbsp; | &nbsp;&nbsp; 7 &nbsp;&nbsp; | &nbsp;&nbsp; 8 &nbsp;&nbsp; | &nbsp;&nbsp; 9 &nbsp;&nbsp; | &nbsp;&nbsp; 10</p>

We see, `arr[mid2] = x`. Thus, required `pos = mid2`.

```cpp (Recursive)
int ternarySearch(int arr[], int n,int l,int r int x){
    if(right > left){
        int mid1 = left + (right - left) / 3;
        int mid2 = mid1 + (right - left) / 3;
        // check if x is found
        if(arr[mid1] == x){
            retrun mid1;
        }
        if(arr[mid2] == x){
            retrun mid2;
        }
        if(x < arr[mid1]){
            // x lies between l and mid1
            return ternarySearch(arr, n, l, mid1-1, x);
        }
        else if(x > arr[mid2]){
            // x lies between mid2 nad r
            retrun ternarySearch(arr, n, mid2+1, r, x);
        }
        else{
            // x lies between mid1 and mid2
            return ternarySearch(arr, n, mid1+1, mid2-1, x);
        }
    }
    // x not found
    return -1;
}
```

## Time Complexity

Ternary Search is faster than Binary Search, as it also works in logarithamic complexity but the base is 3, O(log<sub>3</sub>n). But it is not as widely used as binary search.

As we keep dividing the array to one-third it's current size at each iteration, thus the size of the array decreases logarithmically. 

**At 1st iteration**

length = n

**At 2nd iteration**

length = \\( \frac{x}{3} \\)

**At 3rd iteration**

length = \\(\frac{x}{3}*\frac{1}{3} = \frac{x}{9}\\)

.
.
.


**At k-th iteration**

length = \\( \frac{n}{3^{k-1}} \\)

So, maximum number of interations will be \\( \log_3{n} \\)

## Practice Problem

[Weakness and Poorness](https://codeforces.com/problemset/problem/578/C)

[Race Time!](https://www.codechef.com/problems/AMCS03)

[Devu and his Brother](https://codeforces.com/problemset/problem/439/D)

[This is JEE](https://www.codechef.com/problems/ICM2003)