/*
 * Objective
 *
 * In this challenge, we practice using arithmetic operators. Check out the
 * attached tutorial for resources.
 *
 * Task
 *
 * Complete the following functions in the editor below:
 *
 *   1.- 'getArea(length, height)': Calculate and return the area of a rectangle
 *       having sides 'length' and 'height'.
 *
 *   2.- 'getPerimeter(length, height)': Calculate and return the perimeter of a
 *       rectangle having sides 'length' and 'height'.
 *
 * The values returned by these functions are printed to stdout by locked stub
 * code in the editor.
 *
 * Input Format
 *
 *                           getArea(length, height)
 * Data Type |   Parameter   |                   Description
 *   Number  |    length     | A number denoting the length of a rectangle.
 *           |               |
 *   Number  |    height     | A number denoting the height of a rectangle.
 *           |               |
 *
 *                         getPerimeter(length, height)
 * Data Type |   Parameter   |                   Description
 *   Number  |    length     | A number denoting the length of a rectangle.
 *           |               |
 *   Number  |    height     | A number denoting the height of a rectangle.
 *           |               |
 *
 * Constraints
 *
 * 1 <= length, height <= 1000
 *
 * 'length' and 'height' are scaled to at most three decimal places.
 *
 * Output Format
 *
 *   Function    |  Return Type  |                   Description
 *    getArea    |    Number     | The area of a rectangle having sides 'length'
 *               |               | and 'height'.
 *               |               |
 * getPerimeter  |    Number     | The perimeter of a rectangle having sides
 *               |               | 'length' and 'height'.
 *               |               |
 *
 * Sample Input
 *
 * 3
 * 4.5
 *
 * Sample Output
 *
 * 13.5
 * 15
 *
 * Explanation
 *
 * The area of the rectangle is length x height = 3 * 4.5 = 13.5.
 *
 * The perimeter of the rectangle is 2 * (length + height) = 2 * (3 + 4.5) = 15.
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
*   Calculate the area of a rectangle.
*
*   length: The length of the rectangle.
*   height: The height of the rectangle.
*
*	Return a number denoting the rectangle's area.
**/
function getArea(length, height) {
    let area;

    area = length * height;
    return area;
}

/**
*   Calculate the perimeter of a rectangle.
*
*	length: The length of the rectangle.
*   height: The height of the rectangle.
*
*	Return a number denoting the perimeter of a rectangle.
**/
function getPerimeter(length, height) {
    let perimeter;

    perimeter = 2 * (length + height);
    return perimeter;
}

function main() {
    const length = +(readLine());
    const height = +(readLine());

    console.log(getArea(length, height));
    console.log(getPerimeter(length, height));
}
