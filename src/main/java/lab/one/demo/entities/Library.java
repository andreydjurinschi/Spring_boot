package lab.one.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private List<Long> books;

    public Library() {
    }

    public Library(Long id, String name, List<Long> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }
}
