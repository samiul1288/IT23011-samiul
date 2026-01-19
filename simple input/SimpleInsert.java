import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SimpleInsert {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String pass = 1288;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter studentId: ");
        String studentId = sc.nextLine().trim();

        String sql = "INSERT INTO student(student_id) VALUES (?)";

        try (Connection con = DriverManager.getConnection(url, user, pass);
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
