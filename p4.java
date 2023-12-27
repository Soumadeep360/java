import java.util.*;

class Person {
    String name;
    int age;
    String gender;

    void readDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = sc.nextLine();
        System.out.println("Enter age: ");
        age = sc.nextInt();
        System.out.println("Enter gender: ");
        gender = sc.next();
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}

class Employee extends Person {
    String company;

    void readDetails() {
        super.readDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter company: ");
        company = sc.nextLine();
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Company: " + company);
    }
}

class Student extends Person {
    String school;

    void readDetails() {
        super.readDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter school: ");
        school = sc.nextLine();
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("School: " + school);
    }
}

public class p4 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        Student[] students = new Student[5];

        for (int i = 0; i < 5; i++) {
            employees[i] = new Employee();
            students[i] = new Student();
            System.out.println("Enter details for employee " + (i+1) + ":");
            employees[i].readDetails();
            System.out.println("Enter details for student " + (i+1) + ":");
            students[i].readDetails();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Details of employee " + (i+1) + ":");
            employees[i].displayDetails();
            System.out.println("Details of student " + (i+1) + ":");
            students[i].displayDetails();
        }
    }
}
