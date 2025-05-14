package hospital;



import java.sql.*;
import java.util.Scanner;

public class Main {
 static Scanner sc = new Scanner(System.in);

 public static void main(String[] args) {
     while (true) {
         System.out.println("\n--- Hospital Management Menu ---");
         System.out.println("1. Add Patient");
         System.out.println("2. View Patients");
         System.out.println("3. Add Doctor");
         System.out.println("4. Add Admission");
         System.out.println("5. Add Appointment");
         System.out.println("6. Add Billing");
         System.out.println("7. Exit");
         System.out.print("Enter your choice: ");
         int ch = sc.nextInt();

         switch (ch) {
             case 1: addPatient(); break;
             case 2: viewPatients(); break;
             case 3: addDoctor(); break;
             case 4: addAdmission(); break;
             case 5: addAppointment(); break;
             case 6: addBilling(); break;
             case 7: System.exit(0);
             default: System.out.println("Invalid choice");
         }
     }
 }

 static void addPatient() {
     try {
         Connection con = DBConnection.getConnection();
         String query = "INSERT INTO Patients (patient_id, name, gender, dob, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
         PreparedStatement ps = con.prepareStatement(query);
         System.out.print("Patient ID: "); ps.setInt(1, sc.nextInt()); sc.nextLine();
         System.out.print("Name: "); ps.setString(2, sc.nextLine());
         System.out.print("Gender: "); ps.setString(3, sc.nextLine());
         System.out.print("DOB (YYYY-MM-DD): "); ps.setDate(4, Date.valueOf(sc.nextLine()));
         System.out.print("Phone: "); ps.setString(5, sc.nextLine());
         System.out.print("Address: "); ps.setString(6, sc.nextLine());
         ps.executeUpdate();
         System.out.println("Patient added successfully.");
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 static void viewPatients() {
     try {
         Connection con = DBConnection.getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM Patients");
         System.out.println("\n--- Patient Records ---");
         while (rs.next()) {
             System.out.println("ID: " + rs.getInt("patient_id") + ", Name: " + rs.getString("name") + ", Gender: " + rs.getString("gender"));
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 static void addDoctor() {
     try {
         Connection con = DBConnection.getConnection();
         String query = "INSERT INTO Doctors (doctor_id, name, specialization, salary) VALUES (?, ?, ?, ?)";
         PreparedStatement ps = con.prepareStatement(query);
         System.out.print("Doctor ID: "); ps.setInt(1, sc.nextInt()); sc.nextLine();
         System.out.print("Name: "); ps.setString(2, sc.nextLine());
         System.out.print("Specialization: "); ps.setString(3, sc.nextLine());
         System.out.print("Salary: "); ps.setFloat(4, sc.nextFloat());
         ps.executeUpdate();
         System.out.println("Doctor added successfully.");
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 static void addAdmission() {
     try {
         Connection con = DBConnection.getConnection();
         String query = "INSERT INTO Admissions (admission_id, patient_id, disease, admission_date, discharge_date, days_in_hospital, room_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement ps = con.prepareStatement(query);
         System.out.print("Admission ID: "); ps.setInt(1, sc.nextInt());
         System.out.print("Patient ID: "); ps.setInt(2, sc.nextInt()); sc.nextLine();
         System.out.print("Disease: "); ps.setString(3, sc.nextLine());
         System.out.print("Admission Date (YYYY-MM-DD): "); ps.setDate(4, Date.valueOf(sc.nextLine()));
         System.out.print("Discharge Date (YYYY-MM-DD): "); ps.setDate(5, Date.valueOf(sc.nextLine()));
         System.out.print("Days in Hospital: "); ps.setInt(6, sc.nextInt()); sc.nextLine();
         System.out.print("Room Number: "); ps.setString(7, sc.nextLine());
         ps.executeUpdate();
         System.out.println("Admission added successfully.");
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 static void addAppointment() {
     try {
         Connection con = DBConnection.getConnection();
         String query = "INSERT INTO Appointments (appointment_id, patient_id, doctor_id, appointment_date) VALUES (?, ?, ?, ?)";
         PreparedStatement ps = con.prepareStatement(query);
         System.out.print("Appointment ID: "); ps.setInt(1, sc.nextInt());
         System.out.print("Patient ID: "); ps.setInt(2, sc.nextInt());
         System.out.print("Doctor ID: "); ps.setInt(3, sc.nextInt()); sc.nextLine();
         System.out.print("Appointment Date (YYYY-MM-DD): "); ps.setDate(4, Date.valueOf(sc.nextLine()));
         ps.executeUpdate();
         System.out.println("Appointment added successfully.");
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 static void addBilling() {
     try {
         Connection con = DBConnection.getConnection();
         String query = "INSERT INTO Billing (bill_id, patient_id, doctor_id, total_amount, amount_paid, billing_date) VALUES (?, ?, ?, ?, ?, ?)";
         PreparedStatement ps = con.prepareStatement(query);
         System.out.print("Bill ID: "); ps.setInt(1, sc.nextInt());
         System.out.print("Patient ID: "); ps.setInt(2, sc.nextInt());
         System.out.print("Doctor ID: "); ps.setInt(3, sc.nextInt());
         System.out.print("Total Amount: "); ps.setFloat(4, sc.nextFloat());
         System.out.print("Amount Paid: "); ps.setFloat(5, sc.nextFloat()); sc.nextLine();
         System.out.print("Billing Date (YYYY-MM-DD): "); ps.setDate(6, Date.valueOf(sc.nextLine()));
         ps.executeUpdate();
         System.out.println("Billing record added successfully.");
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
