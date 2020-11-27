# Count Sort

## Example Problem

Given an array `arr = [a1,a2,a3,a4,a5...,an] ` , we need to sort the array with the help of Count Sort algorithm.

<hr>

## Discussion

Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects having distinct key values. Then doing some arithmetic to calculate the position of each object in the output sequence.

Take a count array of size ` max_element + 1` and initialise the array with 0 . Now iterate through the initial array and for each element x increase the value of count array at index x by 1.

But this method won't work for negative integers .

So we take a count array of size `max_element - min_element + 1` and initialize with 0. Now iterate through the initial array and for each element x increase the value of count array at index `x - min_element` by 1.

Now Iterate through the count array and if value at the `index + min_element` is greater than 0 keep on adding the index value to the array , and decrement the value of the index by 1.

<hr>

## Working of the Algorithm

```
Consider array = [1 , 3 , -5 , 3 , 4 , -2 , 0]

Here max_element = -5 and min_element = 4

So, Create an array of size (4 - (-5) + 1) = 10 and initialise with 0.

count_array = [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
idx_values->    0   1   2   3   4   5   6   7   8   9

After the iteration , count array becomes ->

count_array = [ 1 , 0 , 0 , 1 , 0 , 1 , 1 , 0 , 2 , 1 ]
idx_values->    0   1   2   3   4   5   6   7   8   9

The Sorted Array becomes : [-5 , -2 , 0 , 1 , 3 , 3 , 4]
```

<hr>

## Code

### Code For Count Sort

```cpp
void CountSort(int a[],int n)
{
    int max_element = -INT_MAX , min_element = INT_MAX ;

    // for finding the max_element in the array
    for(int i=0;i<n;i++)
        max_element = max(max_element , a[i]);
    
    // for finding the min_element in the array
    for(int i=0;i<n;i++)
        min_element = min(min_element , a[i]);

    // initisalizing a count vector of size max_element - min_element + 1
    vector <int> count(max_element - min_element +1 , 0);

    // setting count vector according to the algorithm
    for(int i=0;i<n;i++)
        count[a[i] - min_element]++;
    
    // updating the actual array
    int j = 0,i=0;
    while(i<max_element - min_element +1)
    {
        if(count[i] == 0)
            i++;
        else
        {
            a[j] = min_element + i;
            count[i]--;
            j++;
        }
        
    }
}
```

<hr>

## Time Complexity

**Time Complexity**: O(n+k) where n is the number of elements in input array and k is the range of input. 

**Space Complexity**: Algoithm takes extra space of O(k).

***Important :** Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K. 

<hr>

Other Resources : [GFG Blog](https://www.geeksforgeeks.org/counting-sort/)