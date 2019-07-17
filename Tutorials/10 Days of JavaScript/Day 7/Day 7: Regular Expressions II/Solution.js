/*
 * Task
 *
 * Complete the function in the editor below by returning a RegExp object, 're',
 * that matches any string 's' satisfying both of the following conditions:
 *
 *   * String 's' starts with the prefix 'Mr.', 'Mrs.', 'Ms.', 'Dr.', or 'Er.'.
 *
 *   * The remainder of string 's' (i.e., the rest of the string after the
 *     prefix) consists of one of more upper and/or lowercase English alphabetic
 *     letters (i.e., [a-z] and [A-Z]).
 *
 * Constraints
 *
 * The length of string 's' 'is >= 3'.
 *
 * Output Format
 *
 * The function must return a RegExp object that matches any string 's'
 * satisfying both of the given conditions.
 *
 * Sample Input 0
 *
 * Mr.X
 *
 * Sample Output 0
 *
 * true
 *
 * Explanation 0
 *
 * This string starts with 'Mr.', followed by an English alphabetic letter
 * ('X').
 *
 * Sample Input 1
 *
 * Mrs.Y
 *
 * Sample Output 1
 *
 * true
 *
 * Explanation 1
 *
 * This string starts with 'Mrs.', followed by an English alphabetic letter
 * ('Y').
 *
 * Sample Input 2
 *
 * Dr#Joseph
 *
 * Sample Output 2
 *
 * false
 *
 * Explanation 2
 *
 * This string starts with 'Dr#' instead of 'Dr.', so it's invalid.
 *
 * Sample Input 3
 *
 * Er .Abc
 *
 * Sample Output 3
 *
 * false
 *
 * Explanation 3
 *
 * This string starts with 'Er' but there is a space before the period ('.'),
 * making the string invalid.
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

function regexVar() {
    let re = new RegExp(/^(Mr.|Mrs.|Ms.|Dr.|Er.)([a-z]|[A-z])+$/);
    return re;
}

function main() {
    const re = regexVar();
    const s = readLine();

    console.log(!!s.match(re));
}