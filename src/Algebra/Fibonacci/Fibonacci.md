# Fibonacci Sequence

## Introduction

The Fibonacci sequence is defined using the following recurrence relation:
\
\
\\(F_n = F_{n-1} + F_{n-2}\\)
\
\
where, \\(F_0 = 0, F_1 = 1\\). This simple recurrence can be used to calculate \\(n\\)'th fibonacci number in \\(O(n)\\) time.

## Binet's Formula

Binet's formula is an explicit formula used to find the nth term of the Fibonacci sequence.
\
\
\\(F_n = \frac{\left(\frac{1 + \sqrt{5}}{2}\right)^n - \left(\frac{1 - \sqrt{5}}{2}\right)^n}{\sqrt{5}}\\)

Note that the absolute value of the second term is less than 1, so as \\(n\\) increases, it's value tends to 0. Thus, we can say that the value of the first term alone is nearly equal to F<sub>n</sub>. The formula also requires very high accuracy and is therefore not practical for larger values of \\(n\\).

## Matrix Form

Consider the following relation:
\
\\(\begin{pmatrix}F_{n-1} & F_{n} \cr\end{pmatrix} = \begin{pmatrix}F_{n-2} & F_{n-1} \cr\end{pmatrix} \cdot \begin{pmatrix}0 & 1 \cr 1 & 1 \cr\end{pmatrix}\\)
\
\
Then,
\
\
\\(\begin{pmatrix}F_n & F_{n+1} \cr\end{pmatrix} = \begin{pmatrix}F_0 & F_1 \cr\end{pmatrix} \cdot P^n\\)
\
\
where, \\(P \equiv \begin{pmatrix}0 & 1 \cr 1 & 1 \cr\end{pmatrix}\\)
\
\
\\(P^{n}\\) can be calculated in \\(O(\log{n})\\) time using matrix exponentiation. This particular method of calculating \\(n\\)'th Fibonacci term is useful when \\(n\\) is very large, and the result is needed modulo some integer \\(m\\).

**Python**
```py
multiply = lambda A, B, mod: [[sum(i * j for i, j in zip(row, col)) % mod for col in zip(*B)] for row in A]

def f(n, m):
    p = [[0, 1], [1, 1]]
    result = [[1, 0], [0, 1]]
    cur = 1
    i = 0
    while cur <= n:
        if n & (1<<i):
            result = multiply(result, p, m)
        i += 1
        cur *= 2
        p = multiply(p, p, m)
    return multiply([[0,1]], result, m)[0][0]
``` 

## Practice Problems
- [Fibonacci Sum](https://www.spoj.com/problems/FIBOSUM/)
- [Sasha and Array](https://codeforces.com/contest/718/problem/C)

## References
- [CP-Algorithms](https://cp-algorithms.com/)