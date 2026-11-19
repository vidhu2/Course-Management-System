package courseapp;
import java.sql.*;
public class StudentDAO {
    Connection con;
    public StudentDAO() throws SQLException {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost/course_db",
                "root",
                "vidhya");
    }
    public int addStudent(String name, String email,String phone) throws SQLException {
        String sql = "INSERT INTO student " + "(student_name, email, phone) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, phone);
        int r = pst.executeUpdate();
        pst.close();
        return r;
    }
    public void listStudents() throws SQLException {
        String sql = "SELECT * FROM student";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println(rs.getInt("student_id") + " - " + rs.getString("student_name") + " - " + rs.getString("email") + " - " + rs.getString("phone")
            );
        }
        if (!found) {
            System.out.println("Student List is Empty!");
        }
        rs.close();
        pst.close();
    }
    public int updateStudent(int id, String name, String email, String phone) throws SQLException {
        String sql = "UPDATE student SET student_name=?, " + "email=?, phone=? WHERE student_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, phone);
        pst.setInt(4, id);
        int r = pst.executeUpdate();
        pst.close();
        return r;
    }
    public int deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student WHERE student_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        int r = pst.executeUpdate();
        pst.close();
        return r;
    }
    public void searchStudent(int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE student_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            System.out.println("\n===== STUDENT DETAILS =====");
            System.out.println("Student ID: " + rs.getInt("student_id"));
            System.out.println("Student Name: " + rs.getString("student_name"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Phone: " + rs.getString("phone"));
        } else {
            System.out.println("Student not found!");
        }
        rs.close();
        pst.close();
    }
    public void closeConnection() throws SQLException {
        con.close();
    }
}

