package courseapp;
import java.sql.*;
public class DashboardDAO {

    Connection con;

    public DashboardDAO() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_db","root", "vidhya");
    }

    public int getTotalCourses() throws SQLException {
        String sql = "SELECT COUNT(*) FROM course";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int total = 0;
        if (rs.next()) {
            total = rs.getInt(1);
        }
        rs.close();
        pst.close();
        return total;
    }

    public int getTotalStudents() throws SQLException {
        String sql = "SELECT COUNT(*) FROM student";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int total = 0;
        if (rs.next()) {
            total = rs.getInt(1);
        }
        rs.close();
        pst.close();
        return total;
    }

    public int getTotalStaff() throws SQLException {
        String sql = "SELECT COUNT(*) FROM staff";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int total = 0;
        if (rs.next()) {
            total = rs.getInt(1);
        }
        rs.close();
        pst.close();
        return total;
    }

    public int getTotalEnrollments() throws SQLException {
        String sql = "SELECT COUNT(*) FROM enrollment";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int total = 0;
        if (rs.next()) {
            total = rs.getInt(1);
        }
        rs.close();
        pst.close();
        return total;
    }

    public int getTotalAssignments() throws SQLException {
        String sql = "SELECT COUNT(*) FROM staff_course";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int total = 0;
        if (rs.next()) {
            total = rs.getInt(1);
        }
        rs.close();
        pst.close();
        return total;
    }

    public void showDashboard() throws SQLException {
        System.out.println("\n===== COURSE MANAGEMENT DASHBOARD =====");
        System.out.println("Total Courses  : " + getTotalCourses());
        System.out.println("Total Students : " + getTotalStudents());
        System.out.println("Total Staff    : " + getTotalStaff());
        System.out.println("Total Enrollments  : " + getTotalEnrollments());
        System.out.println("Staff-Course Assignments  : " + getTotalAssignments());
    }

    public void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}


