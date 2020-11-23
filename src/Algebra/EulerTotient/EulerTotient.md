# Euler's Totient Function

## Introduction

Euler's Totient Function, denoted by \\(\phi(n)\\), counts the number of integers in the range \\([1, n]\\) that are co-prime to \\(n\\). Two numbers are said to be co-prime if their greatest common divisor is equal to 1. Some important properties of the function are:

1. For any prime \\(n\\), it is trivial to see that 
\
\\(\phi(n) = n-1\\)

2. For two co-prime integers a and b, from the Chinese Remainder Theorem, it follows that 
\
\\(\phi(a b) = \phi(a) \cdot \phi(b)\\)

3. For any prime p,
\
\\(\phi(p^k) = p^k - p^{k-1}\\)
\
This holds true because all numbers except the multiples of p will be co-prime to p<sup>k</sup>, and since there are exactly p<sup>k-1</sup> multiples of p, we subtract it from the result.

Using the above results, we can calculate the value of the function for any integer n in O(√n) time by using factorization.

## Implementation

**C++**

```cpp
int phi(int n)
{
    int result = n;
    for(int i=2; i*i<=n; i++)
    {
        if (n % i == 0)
        {
            result -= result/i;
            while(n % i == 0)
                n /= i;
        }
    }
    if (n != 1)
        result -= result/n;
    return result;
}
```

**Python**

```py
def phi(n):
    result = n
    i = 2
    while i*i <= n:
        if n % i == 0:
            result -= result//i
            while n % i == 0:
                n //= i
        i += 1
    if n != 1:
        result -= result//n
    return result
```

If we require the totient of all the numbers upto n, then finding them using factorization will be inefficient. In that case, we can use an approach similar to the Sieve of Eratosthenes, by calculating all the prime numbers and updating the results of the multiples of each prime. The algorithm will have similar complexity as sieve.

**C++**

```cpp
vector<int> get_phi(int n)
{

    vector<int> result(n+1);
    for(int i=0; i<=n; i++)
        result[i] = i;
    for (int i = 2; i <= n; i++)
    {
        if (result[i] == i)
        {
            for (int j = i; j <= n; j += i)
                result[j] -= result[j] / i;
        }
    }
    return result;
}
```

**Python**

```py
def get_phi(n):
    result = [*range(n+1)]
    for i in range(2, n+1):
        if result[i] == i:
            for j in range(i, n+1, i):
                result[j] -= result[j] // i
    return result
```

## Practice Problems
- [LCM Sum](https://www.spoj.com/problems/LCMSUM/)
- [Playing with GCD](https://www.spoj.com/problems/NAJPWG/)

## References
- [CP-Algorithms](https://cp-algorithms.com/)