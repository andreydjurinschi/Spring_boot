package lab.one.demo.dtos;

import jakarta.persistence.ManyToMany;
import lab.one.demo.entities.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<Long> books;

    public CategoryDto(Long id, String name, List<Long> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public CategoryDto() {
    }

}
