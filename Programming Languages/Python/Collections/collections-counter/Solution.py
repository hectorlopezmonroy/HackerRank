# -*- coding: utf-8 -*-

# [collections.Counter()](https://docs.python.org/2/library/collections.html#collections.Counter)
#
# A counter is a container that stores elements as dictionary keys, and their
# counts are stored as dictionary values.
#
# Sample Code
#
# >>> from collections import Counter
# >>>
# >>> myList = [1, 1, 2, 3, 4, 5, 3, 2, 3, 4, 2, 1, 2, 3]
# >>> print Counter(myList)
# Counter({2: 4, 3: 4, 1: 3, 4: 2, 5: 1})
# >>>
# >>> print Counter(myList).items()
# [(1, 3), (2, 4), (3, 4), (4, 2), (5, 1)]
# >>>
# >>> print Counter(myList).keys()
# [1, 2, 3, 4, 5]
# >>>
# >>> print Counter(myList).values()
# [3, 4, 4, 2, 1]
#
# Task
#
# Raghu is a shoe shop owner. His shop has 'X' number of shoes.
# He has a list containing the size of each shoe he has in his shop.
# There are 'N' number of customers who are willing to pay 'x_i' amount of money
# only if they get the shoe of their desired size.
#
# Your task is to compute how much money Raghu earned.
#
# Input Format
#
# The first line contains 'X', the number of shoes.
# The second line contains the space separated list of all the shoe sizes in the
# shop.
# The third line contains 'N', the number of customers.
# The next 'N' lines contain the space separated values of the 'shoe size'
# desired by the customer and 'x_i', the price of the shoe.
#
# Contraints
#
# 0 < X < 10^3
# 0 < N <= 10^3
# 20 < x_i < 100
# 2 < shoe size < 20
#
# Output Format
#
# Print the amount of money earned by Raghu.
#
# Sample Input
#
# 10
# 2 3 4 5 6 7 6 5 18
# 6
# 6 55
# 6 45
# 6 55
# 4 40
# 18 60
# 10 50
#
# Sample Output
#
# 200
#
# Explanation
#
# Customer 1: Purchased size 6 shoe for $55.
# Customer 2: Purchased size 6 shoe for $45.
# Customer 3: Size 6 shoe no longer available, so no purchase.
# Customer 4: Purchased size 4 shoe for $40.
# Customer 5: Purchased size 18 shoe for $60.
# Customer 6: Size 10 not available, so no purchase.
#
# Total money earned = $55 + $45 + $40 + $60 = $200

from collections import Counter

if __name__ == '__main__':
    X = int(input())
    INVENTORY = Counter(map(int, input().split()))
    N = int(input())
    REVENUE = 0

    for i in range(N):
        SIZE_I, PRICE_I = map(int, input().split())
        SIZE_COUNT = INVENTORY[SIZE_I]

        if SIZE_COUNT > 0:
            REVENUE += PRICE_I
            INVENTORY[SIZE_I] = SIZE_COUNT - 1

    print(REVENUE)
