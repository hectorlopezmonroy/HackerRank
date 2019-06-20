/*
 * You are given a list of student information: ID, FirstName, and CGPA. Your
 * task is to rearrange them according to their CGPA in decreasing order. If two
 * students have the same CGPA, then arrange them according to their first name
 * in alphabetical order. If those two students also have the same first name,
 * then order them according to their ID. No two students have the same ID.
 *
 * Hint: You can use comparators to sort a list of objects. See the oracle docs
 * to learn about comparators.
 * (https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html)
 *
 * Input Format
 *
 * The first line of input contains an integer 'N', representing the total
 * number of students. The next 'N' lines contains a list of student information
 * in the following structure:
 *
 *   ID Name CGPA
 *
 * Constraints
 *
 * 2 <= N <= 1000
 *
 * 0 <= ID <= 100000
 *
 * 5 <= |Name| <= 30
 *
 * 0 <= CGPA <= 4.00
 *
 * The 'name' contains only lowercase English letters. The 'ID' contains only
 * integer numbers without leading zeros. The 'CGPA' will contain, at most, '2'
 * digits after the decimal point.
 *
 * Output Format
 *
 * After rearranging the students according to the rules above, print the first
 * name of each student on a separate line.
 *
 * Sample Input
 *
 * 5
 * 33 Rumpa 3.68
 * 85 Ashis 3.85
 * 56 Samiha 3.75
 * 19 Samara 3.75
 * 22 Fahim 3.76
 *
 * Sample Output
 *
 * Ashis
 * Fahim
 * Samara
 * Samiha
 * Rumpa
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class Student {

    private int id;
    private float cgpa;
    private String name;

    Student(int id, String name, float cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCgpa() {
        return cgpa;
    }
}

class Checker implements Comparator<Student> {

    public int compare(Student a, Student b) {
        int res = 0;

        if (a.getCgpa() != b.getCgpa()) {
            res = Float.compare(b.getCgpa(), a.getCgpa());
        } else {
            if (!a.getName().equals(b.getName())) {
                res = a.getName().compareTo(b.getName());
            } else {
                res = Integer.compare(a.getId(), b.getId());
            }
        }
        return res;
    }
}

public class JavaSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Student[] students = new Student[N];
        Checker checker = new Checker();

        // Process Students input data
        for (int i = 0; i < N; i++) {
            students[i] = new Student(in.nextInt(), in.next(), in.nextFloat());
        }
        in.close();

        // Sorts the array as requested
        Arrays.sort(students, checker);

        // Prints the ordered array data as requested
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }
}
