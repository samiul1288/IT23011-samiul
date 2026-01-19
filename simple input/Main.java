import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter studentId: ");
        String studentId = sc.nextLine().trim();

        String sql = "INSERT INTO student(student_id) VALUES (?)";

        try (Connection con = Database.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);

            int rows = ps.executeUpdate();
            System.out.println("Inserted rows: " + rows);

        } catch (Exception e) {
            System.out.println("Insert failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
