import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

//        var sql = "CREATE TABLE books (" +
//                "   isbn VARCHAR(17) PRIMARY KEY," +
//                "   title VARCHAR(50) NOT NULL," +
//                "   description VARCHAR(300)," +
//                "   author VARCHAR(50) NOT NULL," +
//                "   published_date DATE," +
//                "   publisher VARCHAR(50) NOT NULL," +
//                "   available INT NOT NULL" +
//                ");";

        try (var conn = Database.connect();
             var stmt = conn.createStatement()) {
//            stmt.executeUpdate(sql);

            String isbn = BookDB.add(new Book("1111111111111", "title", "description", "author", LocalDate.of(2022, 2, 2), "altabooks", 5));
            System.out.println("Inserted isbn: " + isbn);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
