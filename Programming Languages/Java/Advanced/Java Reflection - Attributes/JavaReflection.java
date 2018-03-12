/*
 * Java reflection is a very powerful tool to inspect the attributes of a class
 * in runtime. For example, we can retrieve the list of public fields of a class
 * using 'getDeclaredMethods()'.
 *
 * In this problem, you will be given a class 'JavaReflection' in the editor.
 * You have to fill in the incompleted lines so that it prints all the methods
 * of another class called 'Student' in alphabetical order. We will append your
 * code with the 'Student' class before running it. The 'Student' class looks
 * like this:
 *
 *   class Student {
 *
 *       private String name;
 *       private String id;
 *       private String email;
 *
 *       public String getName() {
 *           return name;
 *       }
 *
 *       public void setId(String id) {
 *           this.id = id;
 *       }
 *
 *       public void setEmail(String email) {
 *           this.email = email;
 *       }
 *
 *       public void anotherMethod() {
 *           ...
 *       }
 *       ...
 *       ...
 *       some more methods
 *       ...
 *   }
 *
 * You have to print all the methods of the Student class in alphabetical order
 * like this:
 *
 * anotherMethod
 * getName
 * setEmail
 * setId
 * ...
 * ...
 * some more methods
 * ...
 *
 * There is no sample input/output for this problem. If you press "Run Code", it
 * will compile it, but it won't show any outputs.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.lang.reflect.Method;

class Student {

    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void anotherMethod() {
    }
}

public class JavaReflection {

    public static void main(String[] args) {
        Student student = new Student();
        Method[] methods = Student.class.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<String>();
        for (Method m : methods) {
            methodList.add(m.getName());
        }

        Collections.sort(methodList);
        for (String name : methodList) {
            System.out.println(name);
        }
    }
}
