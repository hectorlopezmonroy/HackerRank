/*
 * Objective
 *
 * In this challenge, we use a Regular Expression to evaluate a string. Check
 * out the attached tutorial for more details.
 *
 * Task
 *
 * Complete the function in the editor below by returning a RegExp object, 're'.
 * that matches any string 's' that begins and ends with the same vowel. Recall
 * that the English vowels are 'a', 'e', 'i', 'o' and 'u'.
 *
 * Constraints
 *
 * The length of string 's' is '>= 3'.
 *
 * String 's' consists of lowercase letters only (i.e., [a-z]).
 *
 * Output Format
 *
 * The function must return a RegExp object that matches any string 's'
 * beginning with and ending in the same vowel.
 *
 * Sample Input 0
 *
 * bcd
 *
 * Sample Output 0
 *
 * false
 *
 * Explanation 0
 *
 * This string starts with (and ends in) a consonant, so it cannot start and end
 * with the same vowel.
 *
 * Sample Input 1
 *
 * abcd
 *
 * Sample Output 1
 *
 * false
 *
 * Explanation 1
 *
 * This string ends in a consonant, so it cannot start and end with the same
 * vowel.
 *
 * Sample Input 2
 *
 * abcda
 *
 * Sample Output 2
 *
 * true
 *
 * Explanation 2
 *
 * This string starts and ends with the same vowel ('a').
 *
 * Sample Input 3
 *
 * abcdo
 *
 * Sample Output 3
 *
 * false
 *
 * Explanation 3
 *
 * This string starts with the vowel 'a' but ends in the vowel 'o'.
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

/* ^ matches the beginning of the string.
 * ([aeiou]) matches any of the vowels, and stores it for latter reference.
 * .+ matches any character, at least one or more times.
 * \1 matches the previously stored vowel.
 * $ matches the end of the string.
 */
function regexVar() {
    let re = new RegExp(/^([aeiou]).+\1$/);
    return re;
}

function main() {
    const re = regexVar();
    const s = readLine();

    console.log(re.test(s));
}