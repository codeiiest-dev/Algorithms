# Radix Sort

## Example Problem

Given an array ``arr = [a1,a2,a3,a4,a5...,an] `` , we need to sort the array the array with the help of Radix Sort algorithm.

<hr>

## Discussion

Since you are reading this , I assume that you have already gone through most of the comparison sorts that is `Merge Sort , Quick Sort , etc` . Problem with comparison based algorithm is that the lower bound complexity for them is `nlogn`. They cannot do better than that.

`Counting Sort , Bin Bucket Sort ` can be used to tackle this problem , but problem with counting sort is that if the maximum number in the array is of the order n<sup>2</sup> , then the running time complexity would be of the order O(n<sup>2</sup>). Also the extra space required increases with the maximum number.

The idea of `Radix Sort` is to do digit by digit sort starting from least significant digit to most significant digit. Radix sort uses counting sort as a subroutine to sort.

<hr>

## Working of the Algorithm

Do following for each digit i where i varies from least significant digit to the most significant digit. 
- Sort input array using counting sort (or any stable sort)       according to the i’th digit.
- Update The array.

---------------

### Illustration

Let us look at the following illustration :

```
23 20 15 5 61 301 17 33

Let's look at the one's position for each of the numbers.

23  20  15  5  61  301  17  33
 _   _   _  _   _    _   _   _

Sort them according to the marked digits. If there are same digits put them from left to right according to the array.

20  61  301  23  33  15  05  17
_   _    _   _   _   _   _   _

Sort them again according to Ten's place.

301  005  015  017  020  023  033  061
_    _    _    _    _    _    _    _

Sort them again according to Hundred's place.

005  015  017  020  023  033  061  301

We get the final sorted array.

5 15 17 20 23 33 61 301

```

<hr>

## Code

### Code For Sorting according to digits
```cpp
void digit_sort(int a[],int n,int exp)
{
    // declaring vector array of size 10. Since there are 10 digits.
    vector <int> arr[10];

    // pushing each number in their respective buckets.
    for(int i=0;i<n;i++){
        arr[ (a[i]/exp) % 10 ].push_back(a[i]);
    }

    int j = 0;

    // Updating the main array.
    for(int i=0;i<10;i++)
    {
        for(auto x:arr[i]){
            a[j] = x;
            j++;
        }
    }

    // deleting the extra space.
    for(int i=0;i<10;i++)
        arr[i].clear();
}
```

### Code for Radix Sort.
```cpp
void RadixSort(int a[],int n)
{
    // function for finding the max digit
    int m = max_digit(a,n);

    for(int i=1;i<=m;i++)
    {
        // digit_sort for each place
        digit_sort(a,n,int(pow(10,i-1)+0.5));
    }
}
```

### Code for finding maximum number of digits.
```cpp
int max_digit(int a[], int n)
{
    int res = 0;
    for(int i=0;i<n;i++)
    {
        int temp = a[i] , count = 0;
        while(temp)
        {
            temp/=10;
            count++;
        }
        res = max(res,count);
    }
    return res;
}
```
-------------
## Time Complexity


### What is the running time of Radix Sort? 

Let there be d digits in input integers. Radix Sort takes `O(d*(n+b))` time where `b` is the base for representing numbers, for example, for the decimal system, b is 10. What is the value of d? If k is the maximum possible value, then d would be `O(logb(k))`. So overall time complexity is `O((n+b) * logb(k))`. Which looks more than the time complexity of comparison-based sorting algorithms for a large k. Let us first limit k. Let k <= nc where c is a constant. In that case, the complexity becomes O(nLogb(n)). But it still doesn’t beat comparison-based sorting algorithms. 

### What if we make the value of b larger?.

What should be the value of b to make the time complexity linear? If we set b as n, we get the time complexity as `O(n)`. In other words, we can sort an array of integers with a range from 1 to nc if the numbers are represented in base n (or every digit takes `log2(n)` bits).

<hr>

Other Resources : [GFG Blog](https://www.geeksforgeeks.org/radix-sort/)