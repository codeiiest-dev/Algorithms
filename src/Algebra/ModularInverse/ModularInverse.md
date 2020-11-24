# Modular Multiplicative Inverse

## Introduction

A modular multiplicative inverse of an integer \\(a\\) is some integer \\(x\\) such that, for some modulo \\(m\\),
\
\\(a \cdot x \equiv 1 \mod m\\)
\
Here, \\(x\\) can also be denoted using \\(a^{-1}\\). Note that the modular inverse does not necessarily exist. It only exists if \\(\gcd(a, m) = 1\\).

## Calculating the modular inverse

From the Euler's theorem, if \\(a\\) and \\(m\\) are relatively prime,
\
\
\\(a^{\phi (m)} \equiv 1 \mod m\\)
\
\
Multiplying both sides by \\(a^{-1}\\), we get:
\
\
\\(a ^ {\phi (m) - 1} \equiv a ^{-1} \mod m\\) ...(1)
\
\
Now if the modulus is prime, from Fermat's little theorem, we get:
\
\
\\(a^{m - 1} \equiv 1 \mod m\\)
\
\
Multiplying both sides by a<sup>-1</sup>, we get:
\
\
\\(a ^ {m - 2} \equiv a ^ {-1} \mod m\\) ...(2)
\
\
Using results (1) and (2), and using binary exponentiation, the modular inverse can be calculated in \\(O(\log{m})\\) time for prime modulus, and in \\(O(\sqrt{m} + \log{m})\\) time otherwise, since calculating totient takes \\(O(\sqrt{m})\\) time.

Now say we need to calculate the inverse modulo some prime \\(m\\) for all integers in the range \\([1, n]\\).

We have:
\
\
\\(m \bmod i = m -  \left\lfloor \frac{m}{i} \right\rfloor \cdot i\\)
\
\
Taking modulo \\(m\\) both sides, we get:
\
\
\\(m \bmod i \equiv - \left\lfloor \frac{m}{i} \right\rfloor \cdot i \mod m\\)
\
\
Multiplying both sides by i<sup>-1</sup> . (m mod i)<sup>-1</sup> and simplifying, we have:
\
\
\\(i^{-1} \equiv -\left\lfloor \frac{m}{i} \right\rfloor \cdot (m \bmod i)^{-1} \mod m\\) ...(3)
\
\
We can use this equation to calculate \\(i^{-1}\\) for all \\(i < m\\).

```cpp
inv[i] = 1;
for(int i=2; i<=n; i++)
 inv[i] = m - (m/i) * inv[m%i] % m;
```

Thus, we can calculate the inverse of all numbers upto \\(n\\) in \\(O(n)\\) time.

## Practice Problems
- [Array](https://codeforces.com/contest/57/problem/C)
- [Radio Towers](https://codeforces.com/contest/1452/problem/D)

## References
- [CP-Algorithms](https://cp-algorithms.com/)