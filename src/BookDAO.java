import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {

    public static Book findByIsbn(String isbn) {
        var sql = "SELECT * FROM books " +
                  "WHERE books.isbn = ? ";

        try (var conn = Database.connect();
             var pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, isbn);

            var rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("author"),
                        rs.getDate("published_date").toLocalDate(),
                        rs.getString("publisher"),
                        rs.getInt("available")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Book> findAll() {
        List<Book> books = new ArrayList<>();

        var sql = "SELECT * FROM books";

        try (var conn = Database.connect();
             var stmt = conn.createStatement())
        {
            var rs = stmt.executeQuery(sql);

            while (rs.next()) {
                var book = new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("author"),
                        rs.getDate("published_date").toLocalDate(),
                        rs.getString("publisher"),
                        rs.getInt("available")
                );
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static String insert(Book book) {
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

    public static int update(String isbn, String title, Integer available) {

        var sql = "UPDATE books "
                + "SET title = ?, available = ? "
                + "WHERE isbn = ?";

        int affectedRows = 0;

        try (var conn = Database.connect();
             var pstm = conn.prepareStatement(sql))
        {
            pstm.setString(1, title);
            pstm.setInt(2, available);
            pstm.setString(3, isbn);

            affectedRows = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public static int delete(String isbn) {
        var sql = "DELETE FROM books WHERE isbn = ?";

        int numberDeletedRows = 0;

        try (var conn = Database.connect();
             var pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, isbn);

            numberDeletedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberDeletedRows;
    }
}
