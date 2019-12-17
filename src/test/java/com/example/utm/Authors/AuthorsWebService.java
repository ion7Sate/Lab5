package com.example.utm.Authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authors")
public class AuthorsWebService {
    @Autowired
    AuthorsRepository authorsRepository;
    @GetMapping("authors")
    public List<Authors> findAll() {
        return authorsRepository.findAll();
    }

    @GetMapping("author/{id}")
    public Authors findById(@PathVariable int id) {
        return authorsRepository.findById(id);
    }

    @PostMapping("authors")
    public void save(@RequestBody Authors authors) {
        authorsRepository.save(authors);
    }

    @PutMapping("authors/{fname}")
    public void update(@RequestBody Authors authors,@PathVariable String fname){
        authorsRepository.update(authors,fname);
    }

    @DeleteMapping("authors/{fname}")
    public void delete (@PathVariable String fname ){
        authorsRepository.delete(fname);

    }
}
