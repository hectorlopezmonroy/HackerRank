# Mark and Jane are very happy after having their first child. Their son loves
# toys, so Mark wants to buy some. There are a number of different toys lying in
# front of him, tagged with their prices. Mark has only a certain amount to
# spend, and he wants to maximize the number of toys he buys with his money.
# Given a list of toy prices and an amount to spend, determine the maximum
# number of gifts he can buy.
# Note: Each toy can be purchased only once.
#
# Example
#
# prices = [1, 2, 3, 4]
# budget = 7
#
# The budget is 7 units of currency. He can buy items that cost [1, 2, 3] for 6,
# or [3, 4] for 7 units. The maximum is 3 items.
#
# Function Description
#
# Complete the function maximum_toys in the editor below.
#
# maximum_toys has the following parameter(s):
#
# * int prices[n]: the toys prices
#
# * int budget: Mark's budget
#
# Returns
#
# * int: the maximum number of toys
#
# Input Format
#
# The first line contains two integers, 'n' and 'budget', the number of priced
# toys and the amount Mark has to spend. The next line contains 'n'
# space-separated integers 'prices[i]'.
#
# Constraints
#
# 1 <= n <= 10^5
#
# 1 <= budget <= 10^9
#
# 1 <= prices[i] <= 10^9
#
# A toy can't be bought multiple times.
#
# Sample Input
#
# 7 50
# 1 12 5 111 200 1000 10
#
# Sample Output
#
# 4
#
# Explanation
#
# He can buy only 4 toys at most. These toys have the following prices:
# 1, 12, 5, 10.

# !/bin/ruby

require 'json'
require 'stringio'

# Complete the maximum_toys function below.
def maximum_toys(prices, budget)
  res = 0
  prices.sort!
  prices.each do |price|
    break if price > budget

    budget -= price
    res += 1
  end
  res
end

nk = gets.rstrip.split

budget = nk[1].to_i

prices = gets.rstrip.split(' ').map(&:to_i)

result = maximum_toys prices, budget

puts result
