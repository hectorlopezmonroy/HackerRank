# Each new term in the Fibonacci sequence is generated by adding the previous
# two terms. By starting with '1' and '2', the first 10 terms will be:
#
# 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
#
# By considering the terms in the Fibonacci sequence whose values do not exceed
# 'N', find the sum of the even-valued terms.
#
# Input Format
#
# First line contains 'T' that denotes the number of test cases. This is
# followed by 'T' lines, each containing an integer, 'N'.
#
# Constraints
#
#  1 <= T <= 10^5
# 10 <= N <= 4 * 10^16
#
# Output Format
#
# Print the required answer for each test case.
#
# Sample Input
#
# 2
# 10
# 100
#
# Sample Output
#
# 10
# 44
#
# Explanation
#
# For N = 10, we have {2, 8}, sum is 10.
# For N = 100, we have {2, 8, 34}, sum is 44.

# !/bin/ruby

def even_fibonacci_numbers(n)
  res = n.zero? ? 0 : 2
  fibn2 = 1
  fibn1 = 2
  i     = 2

  return 0 if n == 1
  return 2 if n == 2

  while i < n && n > 2
    fibi = fibn2 + fibn1
    break unless fibi < n

    res += fibi if (fibi % 2).zero?
    fibn2 = fibn1
    fibn1 = fibi
    i += 1
  end
  res
end

t = gets.strip.to_i
for a0 in (0..t-1)
  n = gets.strip.to_i
  puts even_fibonacci_numbers(n)
end
