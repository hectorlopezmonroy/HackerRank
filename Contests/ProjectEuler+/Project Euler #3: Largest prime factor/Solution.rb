# The prime factors of 13195 are 5, 7, 13 and 29.
# What is the largest prime factor of a given number 'N'?
#
# Input Format
#
# First line contains 'T', the number of test cases. This is followed by 'T'
# lines each containing an integer 'N'.
#
# Constraints
#
#  1 <= T <= 10
# 10 <= N <= 10^12
#
# Output Format
#
# For each test case, display the largest prime factor of 'N'.
#
# Sample Input
#
# 2
# 10
# 17
#
# Sample Output
#
# 5
# 17
#
# Explanation
#
# Prime factors of 10 are {2, 5}, largest is 5.
# Prime factor of 17 is 17 itself, hence largest is 17.

#!/bin/ruby

require 'prime'

def largest_prime_factor(n)
  return n if n.prime?

  i = 3
  upper_bound = Integer.sqrt(n)

  while (n % 2).zero? do
    n = n / 2
  end

  return 2 if n == 1

  while n > 2 && i <= upper_bound do
    if (n % i).zero?
      n = n / i
      upper_bound = Integer.sqrt(n)
      i = 3
    else
      i += 2
    end
  end

  return n > 2 ? n : i
end

t = gets.strip.to_i
for a0 in (0..t-1)
  n = gets.strip.to_i
  puts largest_prime_factor(n)
end
