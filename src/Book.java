import java.time.LocalDate;

public class Book {
    private String isbn;
    private String title;
    private String description;
    private String author;
    private LocalDate published_date;
    private String publisher;
    private Integer available;

    public Book(String isbn, String title, String description, String author, LocalDate published_date, String publisher, Integer available) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
        this.published_date = published_date;
        this.publisher = publisher;
        this.available = available;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublished_date() {
        return published_date;
    }

    public void setPublished_date(LocalDate published_date) {
        this.published_date = published_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", published_date=" + published_date +
                ", publisher='" + publisher + '\'' +
                ", available=" + available +
                '}';
    }
}
