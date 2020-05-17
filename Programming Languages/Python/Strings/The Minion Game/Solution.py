# -*- coding: utf-8 -*-

# Kevin and Stuart want to play the 'The Minion Game'.
#
# Game Rules
#
# Both players are given the same string, 'S'.
#
# Both players have to make substrings using the letters of the string 'S'.
#
# Stuart has to make words starting with consonants.
#
# Kevin has to make words starting with vowels.
#
# The game ends when both players have made all possible substrings.
#
# Scoring
#
# A player gets +1 point for each occurrence of the substring in the string 'S'.
#
# For example:
#
# String S = BANANA
#
# Kevin's vowel beginning word = ANA
#
# Here, ANA occurs twice in BANANA. Hence, Kevin will get 2 points.
#
# For better understanding, see the image below:
#
#                                   BANANA
#                   STUART                            KEVIN
#              WORDS      SCORE                  WORDS     SCORE
#                B          1                      A         3
#                N          2                      AN        2
#                BA         1                      ANA       2
#                NA         2                      ANAN      1
#                BAN        1                      ANANA     1
#                NAN        1
#                BANA       1
#                NANA       1
#                BANAN      1
#                BANANA     1
#                 TOTAL    12                       TOTAL    9
#
# Your task is to determine the winner of the game and their score.
#
# Input Format
#
# A single line of input containing the string 'S'.
# Note: The string 'S' will contain only uppercase letters: '[A-Z]'.
#
# Constraints
#
# 0 < len(S) <= 10^6
#
# Output Format
#
# Print one line: the name of the winner and their score separated by a space.
#
# If the game is a draw, print 'Draw'.
#
# Sample Input
#
# BANANA
#
# Sample Output
#
# Stuart 12

def minion_game(string):
    score = {'Kevin': 0, 'Stuart': 0}

    for pos in range(0, len(string)):
        if (string[pos] == 'A' or string[pos] == 'E' or string[pos] == 'I' or
            string[pos] == 'O' or string[pos] == 'U'):
            score['Kevin'] += len(string) - pos
        else:
            score['Stuart'] += len(string) - pos

    if score['Kevin'] == score['Stuart']:
        print('Draw')
    elif score['Kevin'] > score['Stuart']:
        print('Kevin', score['Kevin'])
    else:
        print('Stuart', score['Stuart'])

if __name__ == '__main__':
    s = input()
    minion_game(s)
