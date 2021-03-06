# -*- coding: utf-8 -*-

# Consider a list (list = []). You can perform the following commands:
#
# 1. 'insert i e': Insert integer 'e' at position 'i'.
# 2. 'print': Print the list.
# 3. 'remove e': Delete the first occurrence of integer 'e'.
# 4. 'append e': Insert integer 'e' at the end of the list.
# 5. 'sort': Sort the list.
# 6. 'pop': Pop the last element from the list.
# 7. 'reverse': Reverse the list.
#
# Initialize your list and read in the value of 'n' followed by 'n' lines of
# commands where each command will be of the 7 types listed above. Iterate
# through each command in order and perform the corresponding operation on your
# list.
#
# Input Format
#
# The first line contains an integer, 'n', denoting the number of commands.
# Each line 'i' of the 'n' subsequent lines contains one of the commands
# described above.
#
# Constraints
#
# The elements added to the list must be 'integers'.
#
# Output Format
#
# For each command of type 'print', print the list on a new line.
#
# Sample Input
#
# 12
# insert 0 5
# insert 1 10
# insert 0 6
# print
# remove 6
# append 9
# append 1
# sort
# print
# pop
# reverse
# print
#
# Sample Output
#
# [6, 5, 10]
# [1, 5, 9, 10]
# [9, 5, 1]

if __name__ == '__main__':
    N = int(input())
    L = []
    printsOutput = []

    for i in range(N):
        command = input().strip().split(' ')
        if command[0] == "insert":
            L.insert(int(command[1]), int(command[2]))
        elif command[0] == "print":
            printsOutput.append(L.copy())
        elif command[0] == "remove":
            L.remove(int(command[1]))
        elif command[0] == "append":
            L.append(int(command[1]))
        elif command[0] == "sort":
            L.sort()
        elif command[0] == "pop":
            L.pop()
        elif command[0] == "reverse":
            L.reverse()

    # Prints output as requested.
    for i in range(len(printsOutput)):
        print(printsOutput[i])
