package courseapp;
import java.sql.*;
public class DBCode {
    Connection con;
    public DBCode() throws SQLException {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/course_db",
                "root",
                "vidhya");
    }
    public int addCourse(String name, String duration, float fee, String level) throws SQLException {
        String sql = "INSERT INTO course " + "(name, duration, fee, level) " + "VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, duration);
        pst.setFloat(3, fee);
        pst.setString(4, level);
        int rows = pst.executeUpdate();
        pst.close();
        return rows;
    }
    public void listCourse() throws SQLException {
        String sql = "SELECT * FROM course";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        System.out.println("\n===== COURSE LIST =====");
        while (rs.next()) {
            System.out.println(
                    "Course ID: " + rs.getInt("id") +
                            " | Name: " + rs.getString("name") +
                            " | Duration: " + rs.getString("duration") +
                            " | Fee: " + rs.getFloat("fee") +
                            " | Level: " + rs.getString("level")
            );
        }
        rs.close();
        pst.close();
    }
    public int updateCourse(int id, String name, String duration, float fee, String level) throws SQLException {
        String sql = "UPDATE course SET " + "name = ?, duration = ?, " + "fee = ?, level = ? " + "WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, duration);
        pst.setFloat(3, fee);
        pst.setString(4, level);
        pst.setInt(5, id);
        int rows = pst.executeUpdate();
        pst.close();
        return rows;
    }
    public int deleteCourse(int id) throws SQLException {
        String sql = "DELETE FROM course WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        int rows = pst.executeUpdate();
        pst.close();
        return rows;
    }
    public void searchCourse(int id) throws SQLException {
        String sql = "SELECT * FROM course WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            System.out.println("\n===== COURSE DETAILS =====");
            System.out.println(
                    "Course ID: " + rs.getInt("id"));
            System.out.println(
                    "Course Name: " + rs.getString("name"));

            System.out.println(
                    "Duration: " + rs.getString("duration"));

            System.out.println(
                    "Fee: " + rs.getFloat("fee"));

            System.out.println(
                    "Level: " + rs.getString("level"));

        } else {

            System.out.println("Course not found!");
        }
        rs.close();
        pst.close();
    }
    public void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
