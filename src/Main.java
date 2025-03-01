import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // ISBN: "2222222222222"
        var affectedRows = BookDAO.delete("2222222222222");
        System.out.println(affectedRows);
    }
}
