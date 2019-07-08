/*
 * Objective
 *
 * In this challenge, we learn about Arrays. Check out the attached tutorial for
 * more details.
 *
 * Task
 *
 * Complete the 'getSecondLargest' function in the editor below. It has one
 * parameter: an array, 'nums', of 'n' numbers. The function must find and
 * return the second largest number in 'nums'.
 *
 * Input Format
 *
 * Locked stub code in the editor reads the following input from stdin and
 * passes it to the function:
 *
 * The first line contains an integer, 'n', denoting the size of the 'nums'
 * array.
 *
 * The second line contains 'n' space-separated numbers describing the elements
 * in 'nums'.
 *
 * Constraints
 *
 * 1 <= n <= 10
 *
 * 0 <= nums[i] <= 100, where 'nums[i]' in the number at index 'i'.
 *
 * The numbers in 'nums' are not distinct.
 *
 * Output Format
 *
 * Return the value of the second largest number in the 'nums' array.
 *
 * Sample Input
 *
 * 5
 * 2 3 6 6 5
 *
 * Sample Output
 *
 * 5
 *
 * Explanation
 *
 * Given the array 'nums = [2, 3, 6, 6, 5]', we see that the largest value in
 * the array is '6' and the second largest value is '5'. Thus, we return '5' as
 * our answer.
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

/**
*   Return the second largest number in the array.
*   @param {Number[]} nums - An array of numbers.
*   @return {Number} The second largest number in the array.
**/
function getSecondLargest(nums) {
    let largest = nums[0];
    let secondLargest = Number.MIN_SAFE_INTEGER;

    for (let i of nums) {
        if (largest < i) {
            secondLargest = largest;
            largest = i;
        }
        if (secondLargest < i && i < largest) {
            secondLargest = i;
        }
    }
    return secondLargest;
}

function main() {
    const n = +(readLine());
    const nums = readLine().split(' ').map(Number);

    console.log(getSecondLargest(nums));
}
