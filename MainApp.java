package courseapp;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DBCode db = null;
        StudentDAO sdb = null;
        StaffDAO fdb = null;
        EnrollmentDAO edb = null;
        StaffCourseDAO scdb = null;
        DashboardDAO ddb = null;
        try {
            db = new DBCode();
            sdb = new StudentDAO();
            fdb = new StaffDAO();
            edb = new EnrollmentDAO();
            scdb = new StaffCourseDAO();
            ddb = new DashboardDAO();
            while (true) {
                System.out.println("\n===== COURSE MANAGEMENT SYSTEM =====");
                System.out.println("1. Course Details");
                System.out.println("2. Student Details");
                System.out.println("3. Staff Details");
                System.out.println("4. Student Enrollment");
                System.out.println("5. Staff Course Assignment");
                System.out.println("6. Dashboard");
                System.out.println("0. Exit");
                System.out.print("Enter Choice: ");
                int ch = Integer.parseInt(sc.nextLine());
                if (ch == 1) {
                    while (true) {
                        System.out.println("\n===== COURSE DETAILS =====");
                        System.out.println("1. Add Course");
                        System.out.println("2. List Courses");
                        System.out.println("3. Update Course");
                        System.out.println("4. Delete Course");
                        System.out.println("5. Search Course");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter Choice: ");
                        int cch = Integer.parseInt(sc.nextLine());
                        if (cch == 1) {
                            System.out.print("Enter Course Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Duration: ");
                            String duration = sc.nextLine();
                            System.out.print("Enter Course Fee: ");
                            float fee = Float.parseFloat(sc.nextLine());
                            System.out.print("Enter Course Level: ");
                            String level = sc.nextLine();
                            int r = db.addCourse(name, duration, fee, level);
                            System.out.println(r != 0 ? "Course Added Successfully" : "Failed to Add Course");
                        }
                        else if (cch == 2) {
                            db.listCourse();
                        }
                        else if (cch == 3) {
                            System.out.print("Enter Course ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter New Course Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter New Duration: ");
                            String duration = sc.nextLine();
                            System.out.print("Enter New Course Fee: ");
                            float fee = Float.parseFloat(sc.nextLine());
                            System.out.print("Enter New Course Level: ");
                            String level = sc.nextLine();
                            int r = db.updateCourse(id, name, duration, fee, level);
                            System.out.println(r != 0 ? "Course Updated Successfully" : "Course ID Not Found");
                        }
                        else if (cch == 4) {
                            System.out.print("Enter Course ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            int r = db.deleteCourse(id);
                            System.out.println(r != 0 ? "Course Deleted Successfully" : "Course ID Not Found");
                        }
                        else if (cch == 5) {
                            System.out.print("Enter Course ID to Search: ");
                            int id = Integer.parseInt(sc.nextLine());
                            db.searchCourse(id);
                        }
                        else if (cch == 0) {
                            break;
                        }
                        else {
                            System.out.println("Invalid Operation");
                        }
                    }
                }
                else if (ch == 2) {
                    while (true) {
                        System.out.println("\n===== STUDENT DETAILS =====");
                        System.out.println("1. Add Student");
                        System.out.println("2. List Students");
                        System.out.println("3. Update Student");
                        System.out.println("4. Delete Student");
                        System.out.println("5. Search Student");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter Choice: ");
                        int sch = Integer.parseInt(sc.nextLine());
                        if (sch == 1) {
                            System.out.print("Enter Student Name: ");
                            String name = sc.nextLine();
                            if (!Validation.isValidName(name)) {
                                System.out.println("Error: Name cannot be empty!");
                                continue;
                            }
                            System.out.print("Enter Email: ");
                            String email = sc.nextLine();
                            if (!Validation.isValidEmail(email)) {
                                System.out.println("Error: Invalid Email!");
                                continue;
                            }
                            System.out.print("Enter Phone: ");
                            String phone = sc.nextLine();
                            if (!Validation.isValidPhone(phone)) {
                                System.out.println("Error: Phone number must contain 10 digits!");
                                continue;
                            }
                            int r = sdb.addStudent(name, email, phone);
                            System.out.println(r != 0 ? "Student Added Successfully" : "Failed to Add Student");
                        }
                        else if (sch == 2) {
                            sdb.listStudents();
                        }
                        else if (sch == 3) {
                            System.out.print("Enter Student ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter New Student Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter New Email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter New Phone: ");
                            String phone = sc.nextLine();
                            if (!Validation.isValidName(name)) {
                                System.out.println("Error: Name cannot be empty!");
                                continue;
                            }
                            if (!Validation.isValidEmail(email)) {
                                System.out.println("Error: Invalid Email!");
                                continue;
                            }
                            if (!Validation.isValidPhone(phone)) {
                                System.out.println("Error: Phone number must contain 10 digits!");
                                continue;
                            }
                            int r = sdb.updateStudent(id, name, email, phone);
                            System.out.println(r != 0 ? "Student Updated Successfully" : "Student ID Not Found");
                        }
                        else if (sch == 4) {
                            System.out.print("Enter Student ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            int r = sdb.deleteStudent(id);
                            System.out.println(r != 0 ? "Student Deleted Successfully" : "Student ID Not Found");
                        }
                        else if (sch == 5) {
                            System.out.print("Enter Student ID to Search: ");
                            int id = Integer.parseInt(sc.nextLine());
                            sdb.searchStudent(id);
                        }
                        else if (sch == 0) {
                            break;
                        }
                        else {
                            System.out.println("Invalid Operation");
                        }
                    }
                }
                else if (ch == 3) {
                    while (true) {
                        System.out.println("\n===== STAFF DETAILS =====");
                        System.out.println("1. Add Staff");
                        System.out.println("2. List Staff");
                        System.out.println("3. Update Staff");
                        System.out.println("4. Delete Staff");
                        System.out.println("5. Search Staff");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter Choice: ");
                        int fch = Integer.parseInt(sc.nextLine());
                        if (fch == 1) {
                            System.out.print("Enter Staff Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter Phone: ");
                            String phone = sc.nextLine();
                            System.out.print("Enter Designation: ");
                            String designation = sc.nextLine();
                            int r = fdb.addStaff(name, email, phone, designation);
                            System.out.println(r != 0 ? "Staff Added Successfully" : "Failed to Add Staff");
                        }
                        else if (fch == 2) {
                            fdb.listStaff();
                        }
                        else if (fch == 3) {
                            System.out.print("Enter Staff ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter New Staff Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter New Email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter New Phone: ");
                            String phone = sc.nextLine();
                            System.out.print("Enter New Designation: ");
                            String designation = sc.nextLine();
                            int r = fdb.updateStaff(id, name, email, phone, designation);
                            System.out.println(r != 0 ? "Staff Updated Successfully" : "Staff ID Not Found");
                        }
                        else if (fch == 4) {
                            System.out.print("Enter Staff ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            int r = fdb.deleteStaff(id);
                            System.out.println(r != 0 ? "Staff Deleted Successfully" : "Staff ID Not Found");
                        }
                        else if (fch == 5) {
                            System.out.print("Enter Staff ID to Search: ");
                            int id = Integer.parseInt(sc.nextLine());
                            fdb.searchStaff(id);
                        }
                        else if (fch == 0) {
                            break;
                        }
                        else {
                            System.out.println("Invalid Operation");
                        }
                    }
                }
                else if (ch == 4) {
                    while (true) {
                        System.out.println("\n===== STUDENT ENROLLMENT =====");
                        System.out.println("1. Enroll Student");
                        System.out.println("2. List Enrollments");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter Choice: ");
                        int ech = Integer.parseInt(sc.nextLine());
                        if (ech == 1) {
                            System.out.print("Enter Student ID: ");
                            int studentId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Course ID: ");
                            int courseId = Integer.parseInt(sc.nextLine());
                            int r = edb.addEnrollment(studentId, courseId);
                            System.out.println(r != 0 ? "Student Enrolled Successfully" : "Enrollment Failed");
                        }
                        else if (ech == 2) {
                            edb.listEnrollments();
                        }
                        else if (ech == 0) {
                            break;
                        }
                        else {
                            System.out.println("Invalid Operation");
                        }
                    }
                }
                else if (ch == 5) {
                    while (true) {
                        System.out.println("\n===== STAFF COURSE ASSIGNMENT =====");
                        System.out.println("1. Assign Course to Staff");
                        System.out.println("2. View Assignments");
                        System.out.println("3. Update Assignment");
                        System.out.println("4. Remove Assignment");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter Choice: ");
                        int ach = Integer.parseInt(sc.nextLine());
                        if (ach == 1) {
                            System.out.print("Enter Staff ID: ");
                            int staffId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Course ID: ");
                            int courseId = Integer.parseInt(sc.nextLine());
                            scdb.assignCourse(staffId, courseId);
                        }
                        else if (ach == 2) {
                            scdb.viewAssignments();
                        }
                        else if (ach == 3) {
                            System.out.print("Enter Existing Staff ID: ");
                            int oldStaffId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Existing Course ID: ");
                            int oldCourseId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter New Staff ID: ");
                            int newStaffId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter New Course ID: ");
                            int newCourseId = Integer.parseInt(sc.nextLine());
                            scdb.updateAssignment(oldStaffId, oldCourseId, newStaffId, newCourseId);
                        }
                        else if (ach == 4) {
                            System.out.print("Enter Staff ID: ");
                            int staffId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Course ID: ");
                            int courseId = Integer.parseInt(sc.nextLine());
                            scdb.removeAssignment(staffId, courseId);
                        }
                        else if (ach == 0) {
                            break;
                        }
                        else {
                            System.out.println("Invalid Operation");
                        }
                    }
                }
                else if (ch == 6) {

                    ddb.showDashboard();
                }
                else if (ch == 0) {

                    System.out.println("Application Closed");
                    break;
                }
                else {

                    System.out.println("Invalid Operation");
                }
            }
        }
        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                if (db != null) {
                    db.closeConnection();
                }
                if (sdb != null) {
                    sdb.closeConnection();
                }
                if (fdb != null) {
                    fdb.closeConnection();
                }
                if (edb != null) {
                    edb.closeConnection();
                }
                if (scdb != null) {
                    scdb.closeConnection();
                }
                if (ddb != null) {
                    ddb.closeConnection();
                }
            } catch (Exception e) {
                System.out.println(
                        "Error closing connection: " + e.getMessage());
            }
            sc.close();
        }
    }
}
