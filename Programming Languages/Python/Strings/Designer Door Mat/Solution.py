# -*- coding: utf-8 -*-

# Mr. Vincent works in a door mat manufacturing company. One day, he designed a
# new door mat with the following specifications:
#
#   * Mat size must be 'N x M'. ('N' is an odd natural number, and 'M' is '3'
#     times 'N')
#
#   * The design should have 'WELCOME' written in the center.
#
#   * The design pattern should only use '|', '.' and '-' characters.
#
# Sample Designs
#
#   Size: 7 x 21
#   ---------.|.---------
#   ------.|..|..|.------
#   ---.|..|..|..|..|.---
#   -------WELCOME-------
#   ---.|..|..|..|..|.---
#   ------.|..|..|.------
#   ---------.|.---------
#
#   Size: 11 x 33
#   ---------------.|.---------------
#   ------------.|..|..|.------------
#   ---------.|..|..|..|..|.---------
#   ------.|..|..|..|..|..|..|.------
#   ---.|..|..|..|..|..|..|..|..|.---
#   -------------WELCOME-------------
#   ---.|..|..|..|..|..|..|..|..|.---
#   ------.|..|..|..|..|..|..|.------
#   ---------.|..|..|..|..|.---------
#   ------------.|..|..|.------------
#   ---------------.|.---------------
#
# Input Format
#
# A single line containing the space separated values of 'N' and 'M'.
#
# Constraints
#
# 5 < N < 101
#
# 15 < M < 303
#
# Output Format
#
# Output the design pattern.
#
# Sample Input
#
# 9 27
#
# Sample Output
#
# ------------.|.------------
# ---------.|..|..|.---------
# ------.|..|..|..|..|.------
# ---.|..|..|..|..|..|..|.---
# ----------WELCOME----------
# ---.|..|..|..|..|..|..|.---
# ------.|..|..|..|..|.------
# ---------.|..|..|.---------
# ------------.|.------------

def generatePattern(N, M):
    lines = []

    for i in range(N):
        if i < N // 2:
            pattern = ('.|.' * ((i * 2) + 1))
            lines.append(pattern.center(M, '-'))
        elif i == N // 2:
            lines.append('WELCOME'.center(M, '-'))
        elif N // 2 < i:
            pattern = lines[N - i - 1]
            lines.append(pattern.center(M, '-'))

    for i in range(len(lines)):
        print(lines[i])

if __name__ == '__main__':
    N, M = map(int, input().split())
    generatePattern(N, M)
