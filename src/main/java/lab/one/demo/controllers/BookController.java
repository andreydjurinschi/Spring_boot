package lab.one.demo.controllers;

import lab.one.demo.dtos.BookDto;
import lab.one.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> books = service.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BookDto> createNewBook(@RequestBody BookDto dto){
        BookDto book = service.createBook(dto);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
