# String Hashing

We need this to compare the strings. Idea is to convert each string to integer and compare those instead of the actual strings which is O(1) operation. The conversion is done by a ***Hash-Function*** and the integer obtained corresponding to the string is called *hash* of the string.
A widely used function is   *polynomial rolling hash function* :

 ![](https://hapq.me/content/images/2019/11/Screen-Shot-2019-11-06-at-4.59.06-PM.png)

where *p* and *m* are some chosen, positive numbers. *p* is a prime approximately equal to the number of characters in the input alphabet and *m* is a large number.
Here, it is m=10^9 + 9.

## Implementation

    long long compute_hash(string  const& s)
     { 
       const  int p = 31; 
       const  int m = 1e9 + 9;
       long  long hash_value = 0; 
       long  long p_pow = 1;
       for (char c : s) 
       {
         hash_value = (hash_value + (c - 'a' + 1) * p_pow)%m; 
         p_pow = (p_pow * p) % m;
       } 
       return hash_value; 
     }
Two strings with equal hashes need not be equal. There are possibilities of collision which can be resolved by simply calculating hashes using two different values of *p* and *m* which reduces the probability of collision.

## Examples Of Uses

- Find all the duplicate strings from a given list of strings
- Find the number of different substrings in a string

## Practice Problems

- [A Needle in the Haystack - SPOJ](http://www.spoj.com/problems/NHAY/)
- [Password - Codeforces](http://codeforces.com/problemset/problem/126/B)

### References

- [CP-Algorithms](https://cp-algorithms.com/)
