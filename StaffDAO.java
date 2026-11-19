package courseapp;

import java.sql.*;
import java.util.ArrayList;
public class StaffDAO {
    Connection con;

    public StaffDAO() throws SQLException {con = DriverManager.getConnection("jdbc:mysql://localhost/course_db", "root", "vidhya");
    }

    public int addStaff(String name, String email, String phone, String designation) throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT INTO staff " + "(staff_name, email, phone, designation) " + "VALUES (?, ?, ?, ?)");
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, phone);
        pst.setString(4, designation);
        int r = pst.executeUpdate();
        pst.close();
        return r;
    }

    public void listStaff() throws SQLException {
        ArrayList<String> staffList = new ArrayList<>();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM staff");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String staff = rs.getInt("staff_id") + " - " + rs.getString("staff_name") + " - " + rs.getString("email") + " - " + rs.getString("phone") + " - " + rs.getString("designation");
            staffList.add(staff);
        }
        if (staffList.isEmpty()) {
            System.out.println("Staff List is Empty!");
        } else {
            for (String staff : staffList) {
                System.out.println(staff);
            }
        }
        rs.close();
        pst.close();
    }

    public int updateStaff(int id, String name, String email, String phone, String designation) throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE staff SET staff_name=?, email=?, " + "phone=?, designation=? WHERE staff_id=?");
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, phone);
        pst.setString(4, designation);
        pst.setInt(5, id);
        int r = pst.executeUpdate();
        pst.close();
        return r;
    }

    public int deleteStaff(int id) throws SQLException {
        PreparedStatement pst = con.prepareStatement("DELETE FROM staff WHERE staff_id=?");
        pst.setInt(1, id);
        int r = pst.executeUpdate();
        pst.close();
        return r;
    }

    public void searchStaff(int id) throws SQLException {
        String sql = "SELECT * FROM staff WHERE staff_id = ?";
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
        con.close();
    }
}
