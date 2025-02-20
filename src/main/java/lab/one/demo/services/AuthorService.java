package lab.one.demo.services;

import lab.one.demo.dtos.AuthorDto;
import lab.one.demo.entities.Author;
import lab.one.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private AuthorDto mapToDto(Author author){
        return new AuthorDto(author.getId(), author.getName(), author.getSurname());
    }

    private Author mapToEntity(AuthorDto authorDto){
        return new Author(authorDto.getName(), authorDto.getSurname());
    }

    //все авторы
    public List<AuthorDto> getAllAuthors(){
        List<Author> authorList = authorRepository.findAll();
        List<AuthorDto> authorDtoList = new ArrayList<>();

        for(Author author : authorList){
            authorDtoList.add(mapToDto(author));
        }
        return authorDtoList;
    }
    //автор по id
    public AuthorDto getAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find this author"));
        return mapToDto(author);
    }
    //создание автора
    public AuthorDto createAuthor(AuthorDto authorDto){
        Author author = mapToEntity(authorDto);
        Author savedAuthor = authorRepository.save(author);
        return mapToDto(savedAuthor);
    }

    /*public AuthorDto updateAuthor(Long id, AuthorDto authorDto){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find author"));
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setBooks(authorDto.getBooksIds());
    }*/

    public void deleteAuthor(Long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot"));
        authorRepository.delete(author);
    }








}
