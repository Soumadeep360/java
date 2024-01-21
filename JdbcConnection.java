import java.sql.*;
import java.util.Scanner;

public class JdbcConnection {
    public static void main(String[] args) {
        // Replace these with your database details
        Scanner sc = new Scanner(System.in);
        String jdbcUrl = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "";
        try {
            // Establishing the database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            // Driver Program
            while (true) {
                System.out.println(
                        "1. Add student details.\n2. Display student details\n3. Delete student details\n4. Update Student Details\n5. Join tables\n6. Find max marks\n7. Create view for marks greater than 90");
                System.out.println("Please choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.println("Please enter student's name: ");
                    String namee = sc.nextLine();
                    System.out.println("Please enter student's USN: ");
                    String usnn = sc.nextLine();
                    System.out.println("Please enter student's age: ");
                    int agee = sc.nextInt();
                    System.out.println("Please enter the year of birth:");
                    int yobb = sc.nextInt();
                    System.out.println("Please enter student's marks: ");
                    int markss = sc.nextInt();
                    String queryInsert = "INSERT INTO `students`(`Name`, `USN`, `Age`, `YOB`, `Marks`) VALUES ('"+ namee + "', '" + usnn + "', " + agee + ", " + yobb + ", " + markss + ");";
                    PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
                    preparedStatement.executeUpdate();
                } else if (choice == 2) {
                    // Retrieving student details
                    String query = "SELECT * FROM students";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    // Displaying student details
                    while (resultSet.next()) {
                        String name = resultSet.getString("Name");
                        String usn = resultSet.getString("USN");
                        int age = resultSet.getInt("Age");
                        int yob = resultSet.getInt("YOB");
                        int marks = resultSet.getInt("Marks");
                        System.out.println("Name: " + name + ", USN: " +
                                usn + ", Age: " + age + ", YearofBirth: " + yob
                                + ", Marks: " + marks);
                    }
                } else if (choice == 3) {
                    System.out.println("Please enter the USN of the student to be deleted: ");
                    String usndel = sc.nextLine();
                    String queryDel = "DELETE FROM students WHERE USN='" + usndel + "'";
                    PreparedStatement preparedStatement = connection.prepareStatement(queryDel);
                     preparedStatement.executeUpdate();
                } else if (choice == 4) {
                    System.out.println("Please enter the USN of the student to be updated: ");
                    String usnUpd = sc.nextLine();
                    System.out.println("Please enter the new name: ");
                    String newName = sc.nextLine();
                    String updQuery = "UPDATE students SET name=?WHERE USN=?";
                    PreparedStatement pstmt = connection.prepareStatement(updQuery);
                    pstmt.setString(1, newName);
                    pstmt.setString(2, usnUpd);
                    pstmt.executeUpdate();
                } else if (choice == 5) {
                    System.out.println("Please enter the table's name to be joined to the current table: ");
                    String tableName = sc.nextLine();
                    String joinQuery = "SELECT * FROM students NATURAL JOIN " + tableName;
                    PreparedStatement pstmt = connection.prepareStatement(joinQuery);
                    ResultSet rs = pstmt.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(rs.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                } else if (choice == 6) {
                    System.out.println("The maximum marks has been scored by: ");
                    String maxQuery = "SELECT Name FROM students WHERE Marks = (SELECT MAX(Marks) FROM students)";
                    PreparedStatement pstmt = connection.prepareStatement(maxQuery);
                    ResultSet rs = pstmt.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(rs.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                } else if (choice == 7) {
                    String viewQuery = "CREATE VIEW Mark1 AS SELECT Name,Marks FROM students WHERE Marks > 90";
                    PreparedStatement pstmt = connection.prepareStatement(viewQuery);
                    pstmt.executeUpdate();
                    String selectQuery = "SELECT * FROM Mark1";
                    pstmt = connection.prepareStatement(selectQuery);
                    ResultSet rs = pstmt.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(rs.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// import java.sql.*;

// public class prog {
//     // JDBC URL, username, and password of MySQL server
//     private static final String JDBC_URL = "jdbc:mysql://localhost:3306/students";
//     private static final String DB_USER = "root";
//     private static final String DB_PASSWORD = "";

//     public static void main(String[] args) {
//         // Step 1: Establishing a Connection
//         try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
//             // Step 2: Creating a Statement
//             Statement statement = connection.createStatement();

//             // Step 3: CRUD Operations

//             // CREATE operation
//             String createQuery = "INSERT INTO stud (id, name, age, department) VALUES (1, 'John', 21, 'Computer Science')";
//             statement.executeUpdate(createQuery);
//             System.out.println("Record created successfully.");

//             // READ operation
//             String readQuery = "SELECT * FROM stud";
//             ResultSet resultSet = statement.executeQuery(readQuery);
//             while (resultSet.next()) {
//                 int id = resultSet.getInt("id");
//                 String name = resultSet.getString("name");
//                 int age = resultSet.getInt("age");
//                 String department = resultSet.getString("department");
//                 System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department);
//             }

//             // UPDATE operation
//             String updateQuery = "UPDATE stud SET age = 22 WHERE name = 'John'";
//             statement.executeUpdate(updateQuery);
//             System.out.println("Record updated successfully.");

//             // DELETE operation
//             String deleteQuery = "DELETE FROM stud WHERE name = 'John'";
//             statement.executeUpdate(deleteQuery);
//             System.out.println("Record deleted successfully.");

//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }
