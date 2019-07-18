/*
 * Objective
 *
 * In this challenge, we practice looping over the characters of a string. Check
 * out the attached tutorial for more details.
 *
 * Task
 *
 * Complete the 'vowelsAndConsonants' function in the editor below. It has one
 * parameter, a string 's', consisting of lowercase English alphabetic letters
 * (i.e., 'a' through 'z'). The function must do the following:
 *
 *   1.- First, print each vowel in 's' on a new line. The English vowels are
 *       'a', 'e', 'i', 'o' and 'u', and each vowel must be printed in the same
 *       order as it appeared in 's'.
 *
 *   2.- Second, print each consonant (i.e., non-vowel) in 's' on a new line in
 *       the same order as it appeared in 's'.
 *
 * Input Format
 *
 * Locked stub code in the editor reads string 's' from stdin and passes it to
 * the function.
 *
 * Output Format
 *
 * First, print each vowel in 's' on a new line (in the same order as they
 * appeared in 's'). Second, print each consonant (i.e., non-vowel) in 's' on a
 * new line (in the same order as they appeared in 's').
 *
 * Sample Input
 *
 * javascriptloops
 *
 * Sample Output
 *
 * a
 * a
 * i
 * o
 * o
 * j
 * v
 * s
 * c
 * r
 * p
 * t
 * l
 * p
 * s
 *
 * Explanation
 *
 * Observe the following:
 *
 * * Each letter is printed on a new line.
 * * Then the vowels are printed in the same order as they appeared in 's'.
 * * Then the consonants are printed in the same order as they appeared in 's'.
 */

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });

    main();
});

function readLine() {
    return inputString[currentLine++];
}

function vowelsAndConsonants(s) {
    let vowels = [];
    let consonants = [];

    for (let i = 0; i < s.length; i++) {
        let letter = s[i];

        if (letter == 'a' || letter == 'e' ||
            letter == 'i' || letter == 'o' ||
            letter == 'u') {
            // Current letter is a vowel. We add it to our vowels array.
            vowels.push(letter);
        } else {
            // Current letter is a consonant. We add it to our consonants array.
            consonants.push(letter);
        }
    }

    // Print all vowels
    for (let v of vowels) {
        console.log(v);
    }

    // Print all consonants
    for (let c of consonants) {
        console.log(c);
    }
}

function main() {
    const s = readLine();

    vowelsAndConsonants(s);
}
