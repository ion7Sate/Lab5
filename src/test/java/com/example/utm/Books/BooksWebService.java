package com.example.utm.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/book")
public class BooksWebService {

    @Autowired
    BooksRepository booksRepository;

    @GetMapping("books")
    public List<Books> findAll() {
        return booksRepository.findAll();
    }

    @GetMapping("books/{id}")
    public Books findById(@PathVariable int id){
        return booksRepository.findById(id);
    }

  @PostMapping("books")
    public void save(@RequestBody Books books) {
   booksRepository.save(books);
    }
    @PutMapping("books/{id}")
    public void update(@RequestBody Books books, @PathVariable String title ){
       booksRepository.update(books,title);
    }

    @DeleteMapping("books/{title}")
    public void delete (@PathVariable String title ){
  booksRepository.delete(title);

    }
}
