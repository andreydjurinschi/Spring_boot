package lab.one.demo.services;

import lab.one.demo.dtos.BookDto;
import lab.one.demo.entities.Book;
import lab.one.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

   /* private BookDto MapToDto(Book book){
        return new BookDto(book.getId(), book.getTitle());
    }*/
}
