import java.sql.SQLException;
import java.sql.Statement;

public class BookDB {

    public static String add(Book book) {
        var sql = "INSERT INTO books (isbn, title, description, author, published_date, publisher, available) " +
                  "VALUES (?,?,?,?,?,?,?);";

        try (var conn = Database.connect();
             var pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getDescription());
            pstmt.setString(4, book.getAuthor());
            pstmt.setDate(5, java.sql.Date.valueOf(book.getPublished_date().toString()));
            pstmt.setString(6, book.getPublisher());
            pstmt.setInt(7, book.getAvailable());

            int insertedRow = pstmt.executeUpdate();
            if (insertedRow > 0) {
                return book.getIsbn();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "-1";
    }
}
