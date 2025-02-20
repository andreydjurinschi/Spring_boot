package lab.one.demo.dtos;


import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lab.one.demo.entities.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublisherDto {

    private Long id;

    private String name;

    private List<Long> booksIds;

    public PublisherDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PublisherDto() {
    }

}
