package hospital;

import java.sql.*;

public class PatientService {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db1";
    private static final String USER = "root";
    private static final String PASSWORD = "2604@mysql";  // Updated password

    private Connection connection;

    public PatientService() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Add a new patient
    public void addPatient(int patientId, String name, String gender, Date dob, String phone, String address) {
        String query = "INSERT INTO Patients (patient_id, name, gender, dob, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            stmt.setString(2, name);
            stmt.setString(3, gender);
            stmt.setDate(4, dob);
            stmt.setString(5, phone);
            stmt.setString(6, address);
            stmt.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing patient's details
    public void updatePatient(int patientId, String name, String gender, Date dob, String phone, String address) {
        String query = "UPDATE Patients SET name = ?, gender = ?, dob = ?, phone = ?, address = ? WHERE patient_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setDate(3, dob);
            stmt.setString(4, phone);
            stmt.setString(5, address);
            stmt.setInt(6, patientId);
            stmt.executeUpdate();
            System.out.println("Patient details updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a patient
    public void deletePatient(int patientId) {
        String query = "DELETE FROM Patients WHERE patient_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            stmt.executeUpdate();
            System.out.println("Patient deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a patient's details
    public void getPatientDetails(int patientId) {
        String query = "SELECT * FROM Patients WHERE patient_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Patient ID: " + rs.getInt("patient_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Date of Birth: " + rs.getDate("dob"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Address: " + rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
