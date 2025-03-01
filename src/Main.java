import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // ISBN: "2222222222222"
        var books = BookDAO.findAll();
        System.out.println(books);
    }
}
