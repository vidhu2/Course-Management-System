package courseapp;
import java.sql.*;
public class StaffCourseDAO {
    Connection con;

    public StaffCourseDAO() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_db", "root", "vidhya");
    }

    public void assignCourse(int staffId, int courseId) throws SQLException {
        String sql = "INSERT INTO staff_course (staff_id, course_id) " + "VALUES (?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, staffId);
        pst.setInt(2, courseId);
        int rows = pst.executeUpdate();
        if (rows > 0) {
            System.out.println("Course assigned successfully!");
        } else {
            System.out.println("Course assignment failed.");
        }
        pst.close();
    }

    public void viewAssignments() throws SQLException {
        String sql = "SELECT sc.staff_id, s.staff_name, " + "sc.course_id, c.name " + "FROM staff_course sc " + "JOIN staff s ON sc.staff_id = s.staff_id " + "JOIN course c ON sc.course_id = c.id " + "ORDER BY sc.staff_id";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        System.out.println("\n===== STAFF COURSE ASSIGNMENTS =====");
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("Staff ID: " + rs.getInt("staff_id") + " | Staff: " + rs.getString("staff_name") + " | Course ID: " + rs.getInt("course_id") + " | Course: " + rs.getString("name")
            );
        }

        if (!found) {
            System.out.println("No assignments found.");
        }
        rs.close();
        pst.close();
    }

    public void updateAssignment(int oldStaffId, int oldCourseId, int newStaffId, int newCourseId)
            throws SQLException {String sql = "UPDATE staff_course " + "SET staff_id = ?, course_id = ? " + "WHERE staff_id = ? AND course_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, newStaffId);
        pst.setInt(2, newCourseId);
        pst.setInt(3, oldStaffId);
        pst.setInt(4, oldCourseId);
        int rows = pst.executeUpdate();
        if (rows > 0) {
            System.out.println("Assignment updated successfully!");
        } else {
            System.out.println("Assignment not found.");
        }
        pst.close();
    }

    public void removeAssignment(int staffId, int courseId) throws SQLException {
        String sql = "DELETE FROM staff_course " + "WHERE staff_id = ? AND course_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, staffId);
        pst.setInt(2, courseId);
        int rows = pst.executeUpdate();
        if (rows > 0) {
            System.out.println("Assignment removed successfully!");
        } else {
            System.out.println("Assignment not found.");
        }
        pst.close();
    }

    public void searchStaff(int id) throws SQLException {String sql = "SELECT * FROM staff WHERE staff_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            System.out.println("\n===== STAFF DETAILS =====");
            System.out.println("Staff ID: " + rs.getInt("staff_id"));
            System.out.println("Staff Name: " + rs.getString("staff_name"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Phone: " + rs.getString("phone"));
            System.out.println("Designation: " + rs.getString("designation"));
        } else {
            System.out.println("Staff not found!");
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
