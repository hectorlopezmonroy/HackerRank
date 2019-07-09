/*
 * Objective
 *
 * In this challenge, we learn about iterating over objects. Check the attached
 * tutorial for more details.
 *
 * Task
 *
 * Complete the function in the editor. It has one parameter: an array, 'a', of
 * objects. Each object in the array has two integer properties denoted by 'x'
 * and 'y'. The function must return a count of all such objects 'o' in array
 * 'a' that satisfy 'o.x == o.y'.
 *
 * Input Format
 *
 * The first line contains an integer denoting 'n'.
 *
 * Each of the 'n' subsequent lines contains two space-separated integers
 * describing the values of 'x' and 'y'.
 *
 * Constraints
 *
 * 5 <= n <= 10
 *
 * 1 <= x, y <= 100
 *
 * Output Format
 *
 * Return a count of the total number of objects 'o' such that 'o.x == o.y'.
 * Locked stub code in the editor prints the returned value to stdout.
 *
 * Sample Input
 *
 * 5
 * 1 1
 * 2 3
 * 3 3
 * 3 4
 * 4 5
 *
 * Sample Output
 *
 * 2
 *
 * Explanation
 *
 * There are 'n = 5' objects in the 'objects' array:
 *
 * * objects[0] = {x: 1, y: 1}
 * * objects[1] = {x: 2, y: 3}
 * * objects[2] = {x: 3, y: 3}
 * * objects[3] = {x: 3, y: 4}
 * * objects[4] = {x: 4, y: 5}
 *
 * Because we have two objects 'o' that satisfy 'o.x == o.y' (i.e., 'objects[0]'
 * and 'objects[2]'), we return '2' as our answer.
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

/*
 * Return a count of the total number of objects 'o' satisfying o.x == o.y.
 *
 * Parameter(s):
 * objects: an array of objects with integer properties 'x' and 'y'
 */
function getCount(objects) {
    let res = 0;

    for (let i in objects) {
        if (objects[i].x == objects[i].y) {
            res++;
        }
    }
    return res;
}

function main() {
    const n = +(readLine());
    let objects = [];

    for (let i = 0; i < n; i++) {
        const [a, b] = readLine().split(' ');

        objects.push({x: +(a), y: +(b)});
    }

    console.log(getCount(objects));
}
