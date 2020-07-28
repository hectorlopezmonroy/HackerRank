# -*- coding: utf-8 -*-

# You are given an integer, 'N'. Your task is to print an alphabet rangoli of
# size 'N'. (Rangoli is a form of Indian folk art based on creation of patterns)
#
# Different sizes of alphabet rangoli are shown below:
#
#   size 3
#
#   ----c----
#   --c-b-c--
#   c-b-a-b-c
#   --c-b-c--
#   ----c----
#
#   size 5
#
#   --------e--------
#   ------e-d-e------
#   ----e-d-c-d-e----
#   --e-d-c-b-c-d-e--
#   e-d-c-b-a-b-c-d-e
#   --e-d-c-b-c-d-e--
#   ----e-d-c-d-e----
#   ------e-d-e------
#   --------e--------
#
#   size 10
#
#   ------------------j------------------
#   ----------------j-i-j----------------
#   --------------j-i-h-i-j--------------
#   ------------j-i-h-g-h-i-j------------
#   ----------j-i-h-g-f-g-h-i-j----------
#   --------j-i-h-g-f-e-f-g-h-i-j--------
#   ------j-i-h-g-f-e-d-e-f-g-h-i-j------
#   ----j-i-h-g-f-e-d-c-d-e-f-g-h-i-j----
#   --j-i-h-g-f-e-d-c-b-c-d-e-f-g-h-i-j--
#   j-i-h-g-f-e-d-c-b-a-b-c-d-e-f-g-h-i-j
#   --j-i-h-g-f-e-d-c-b-c-d-e-f-g-h-i-j--
#   ----j-i-h-g-f-e-d-c-d-e-f-g-h-i-j----
#   ------j-i-h-g-f-e-d-e-f-g-h-i-j------
#   --------j-i-h-g-f-e-f-g-h-i-j--------
#   ----------j-i-h-g-f-g-h-i-j----------
#   ------------j-i-h-g-h-i-j------------
#   --------------j-i-h-i-j--------------
#   ----------------j-i-j----------------
#   ------------------j------------------
#
# The center of the rangoli has the first alphabet letter, 'a', and the boundary
# has the N-th alphabet letter (in alphabetical order).
#
# Input Format
#
# Only one line of input containing 'N', the size of the rangoli.
#
# Constraints
#
# 0 < N < 27
#
# Output Format
#
# Print the alphabet rangoli in the format explained above.
#
# Sample Input
#
# 5
#
# Sample Output
#
# --------e--------
# ------e-d-e------
# ----e-d-c-d-e----
# --e-d-c-b-c-d-e--
# e-d-c-b-a-b-c-d-e
# --e-d-c-b-c-d-e--
# ----e-d-c-d-e----
# ------e-d-e------
# --------e--------

import string

def generateLeft(start, n):
    res = ''

    for i in range(n):
        res = res + string.ascii_lowercase[start - 1 - i] + '-'

    return res

def generateRight(start, n):
    res = ''

    for i in range(n):
        res = '-' + string.ascii_lowercase[start - 1 - i] + res

    return res

def print_rangoli(size):
    lines = []
    N = (size * 2) - 1
    M = ((((size - 1) * 2) + 1) * 2) - 1

    for i in range(N):
        center = string.ascii_lowercase[(size - 1) - i]

        if i < N // 2:
            pattern = generateLeft(size, i) + center + generateRight(size, i)
            lines.append(pattern.center(M, '-'))
        elif i == N // 2:
            pattern = generateLeft(size, size - 1) + 'a' + generateRight(size, size - 1)
            lines.append(pattern)
        elif N // 2 < i:
            pattern = lines[N - i - 1]
            lines.append(pattern.center(M, '='))

    for i in range(len(lines)):
        print(lines[i])

if __name__ == '__main__':
    n = int(input())
    print_rangoli(n)
