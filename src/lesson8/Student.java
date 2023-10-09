package lesson8;

import com.sun.tools.javac.Main;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayStudentInfo() {
        if (name != null) {
            System.out.println("Student name: " + name);
        } else {System.out.println("There is no student name.");
    }

        if (age >=0){
        System.out.println("Student age is: " + age);
    }
        else{
        System.out.println("There is no student age.");
    }
}

    public static void main(String[] args) {
        Student defaultStudent = new Student("Mark", 20);
        defaultStudent.displayStudentInfo();
        System.out.println();

        defaultStudent.displayStudentInfo();
        defaultStudent.displayStudentInfo();
        System.out.println();

        Student nullStudent = null;
        System.out.println("Null Student Info:");
        if (nullStudent != null) {
            nullStudent.displayStudentInfo();
        } else {
            System.out.println("Student object is null.");
        }
    }
}

