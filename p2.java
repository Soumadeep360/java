import java.util.*;

class EmployeeDetails {
    public String name, ID, dept, designation;
    public int age;
    public double sal;

    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the employee:");
        name = sc.nextLine();
        System.out.println("Enter Employee ID:");
        ID = sc.nextLine();
        System.out.println("Enter department of the Employee:");
        dept = sc.nextLine();
        System.out.println("Enter the designation of employee:");
        designation = sc.nextLine();
        System.out.println("Enter the age of the employee:");
        age = sc.nextInt();
        System.out.println("Enter the salary of the employee:");
        sal = sc.nextDouble();
    }

    public void printdata() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employee ID: " + ID);
        System.out.println("Department: " + dept);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + sal);
        System.out.println();
    }
}

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nber of e:");
        int n = sc.nextInt();
        EmployeeDetails[]e = new EmployeeDetails[n]; // Corrected class name
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            e[i] = new EmployeeDetails(); // Corrected class name
            e[i].getdata();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Details for Employee " + (i + 1));
            e[i].printdata();
        }

        double salesTotal = 0;
        for (int i = 0; i < n; i++) {
            if (e[i].dept.compareTo("sales") == 0) {
                salesTotal = salesTotal + e[i].sal;
            }
        }
        System.out.println("Total salary of sales Department is: " + salesTotal);

        double max = 0;
        int index = -1; // Initialize with -1 to indicate no manager found
        for (int i = 0; i < n; i++) {
            if (e[i].dept.compareTo("purchase") == 0 && e[i].designation.compareTo("manager") == 0) {
                if (e[i].sal > max) {
                    max = e[i].sal;
                    index = i;
                }
            }
        }

        if (index == -1) {
            System.out.println("There are no managers in the purchase department");
        } else {
            System.out.println("Details of the highest paid manager of the purchase department:");
            e[index].printdata();
    }
  }
}
