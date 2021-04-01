# 2520 is the smallest number that can be divided by each of the numbers from 1
# to 10 without any remainder.
#
# What is the smallest positive number that is evenly divisible (divisible with
# no remainder) by all of the numbers from 1 to N?
#
# Input Format
#
# First line contains 'T' that denotes the number of test cases. This is
# followed by 'T' lines, each containing an integer, 'N'.
#
# Constraints
#
# 1 <= T <= 10
#
# 1 <= N <= 40
#
# Output Format
#
# Print the required answer for each test case.
#
# Sample Input
#
# 2
# 3
# 10
#
# Sample Output
#
# 6
# 2520
#
# Explanation
#
# You can check 6 is divisible by each of {1, 2, 3}, giving quotient of
# {6, 3, 2} respectively.
#
# You can check 2520 is divisible by each of {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
# giving quotient of {2520, 1260, 840, 630, 504, 420, 360, 315, 280, 252}
# respectively.

#!/bin/ruby

require 'prime'

def getSmallestMultiple(n)
  res = 1

  for i in (2..n) do
    if (res % i != 0) then
      if (i.prime?) then
        res = res * i
      else
        res = res * (i / (res % i))
      end
    end
  end
  return res
end

t = gets.strip.to_i
for a0 in (0..t-1)
  n = gets.strip.to_i
  puts getSmallestMultiple(n)
end
