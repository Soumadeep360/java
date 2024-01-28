import java.util.*;
import java.sql.*;
class p10{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306/data";
        String username="root";
        String pass="";
        
        try{
            Connection connection=DriverManager.getConnection(url,username,pass);
            while (true) {
            System.out.println("enter a choice:");
            System.out.println("1.Create 2.Read 3.Delete 4.Update");
            int ch=sc.nextInt();
            sc.nextLine();
            if(ch==1){
                String query="INSERT INTO st(name,age,marks) VALUES('jay',15,45)";
                PreparedStatement ps=connection.prepareStatement(query);
                ps.executeUpdate();   
            }
            else if(ch==2){
                String query="SELECT * FROM st";
                PreparedStatement ps=connection.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    String name=rs.getString("name");
                    int age=rs.getInt("age");
                    int marks=rs.getInt("marks");
                    System.out.println("NAME: "+name+" AGE: "+age+" marks: "+marks);
                }
            }
            else if(ch==3){
                String query="DELETE FROM st WHERE age=15";
                PreparedStatement ps=connection.prepareStatement(query);
                ps.executeUpdate();
            }
            else if(ch==4){
                String query="UPDATE st SET name='rahul' WHERE age=15";
                PreparedStatement ps=connection.prepareStatement(query);
                ps.executeUpdate();
            }
            else
            return;
            }

        }
        catch(SQLException e){
            e.getMessage();
        }
    }
}
