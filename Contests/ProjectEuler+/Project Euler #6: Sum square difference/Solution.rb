# The sum of the squares of the first ten natural numbers is,
# 1^2 + 2^2 + ... + 10^2 = 385. The square of the sum of the first ten natural
# numbers is, (1 + 2 + ... + 10)^2 = 3025. Hence the absolute difference between
# the sum of the squares of the first ten natural numbers and the square of the
# sum is 3025 - 385 = 2640.
#
# Find the absolute difference between the sum of the squares of the first 'N'
# natural numbers and the square of the sum.
#
# Input Format
#
# First line contains 'T' that denotes the number of test cases.
# This is followed by 'T' lines, each containing an integer, 'N'.
#
# Constraints
#
# 1 <= T <= 10^4
# 1 <= N <= 10^4
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
# 22
# 2640
#
# Explanation
#
# For N = 3, (1 + 2 + 3)^2 - (1^2 + 2^2 + 3^2) = 22
#
# For N = 10, (1 + 2 + ... + 10)^2 - (1^2 + 2^2 + ... +10^2) = 2640

#!/bin/ruby

def get_sum_square_difference(n)
  a = 0
  b = 0

  (1..n).each do |j|
    a += j
    b += (j * j)
  end
  a *= a
  a - b
end

t = gets.strip.to_i
for a0 in (0..t-1)
  n = gets.strip.to_i
  puts get_sum_square_difference(n)
end
