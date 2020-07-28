# -*- coding: utf-8 -*-

# You are given a string and your task is to swap cases. In other words, convert
# all lowercase letters to uppercase letters and vice versa.
#
# Example:
#
#   Www.HackerRank.com -> wWW.hACKERrANK.COM
#   Pythonist 2 -> pYTHONIST 2
#
# Input Format
#
# A single line containing a string 'S'.
#
# Constraints
#
# 0 < len(S) <= 1000
#
# Output Format
#
# Print the modified string 'S'.
#
# Sample Input
#
# HackerRank.com presents "Pythonist 2".
#
# Sample Output
#
# hACKERrANK.COM PRESENTS "pYTHONIST 2".

def swap_case(s):
    res = ''

    for i in range(0, len(s)):
        if s[i].islower():
            res += s[i].upper()
        else:
            res += s[i].lower()

    return res

if __name__ == '__main__':
    s = input()
    result = swap_case(s)
    print(result)
