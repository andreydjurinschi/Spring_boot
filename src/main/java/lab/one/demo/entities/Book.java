package lab.one.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;


    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;


    public Book(Long id, String title, Author author, Publisher publisher, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.categories = categories;
    }

    public Book() {
    }
}
