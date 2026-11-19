package courseapp;
import java.sql.*;
public class EnrollmentDAO {
    private Connection con;
    public EnrollmentDAO() throws SQLException
    {con = DriverManager.getConnection("jdbc:mysql://localhost/course_db", "root", "vidhya");
    }

    public int addEnrollment(int studentId, int courseId) throws SQLException {
        String sql = "INSERT INTO enrollment " + "(student_id, course_id, enrollment_date) " + "VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, studentId);
        pst.setInt(2, courseId);
        pst.setDate(3, Date.valueOf(java.time.LocalDate.now()));
        int result = pst.executeUpdate();
        pst.close();
        return result;
    }

    public void listEnrollments() throws SQLException {
        String sql = "SELECT e.enrollment_id, " + "s.student_name, c.name, e.enrollment_date " + "FROM enrollment e " + "JOIN student s ON e.student_id = s.student_id " + "JOIN course c ON e.course_id = c.id";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("\n===== STUDENT ENROLLMENTS =====");
        while (rs.next()) {
            System.out.println(rs.getInt("enrollment_id") + " - " + rs.getString("student_name") + " - " + rs.getString("name") + " - " + rs.getDate("enrollment_date")
            );
        }
        rs.close();
        st.close();
    }
    public void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}

