import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // ISBN: "2222222222222"
        var affectedRows = BookDAO.update("2222222222222", "O ego é seu inimigo", 10);
        System.out.println(affectedRows);
    }
}
