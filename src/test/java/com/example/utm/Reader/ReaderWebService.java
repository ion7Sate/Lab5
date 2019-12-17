package com.example.utm.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reader")
public class ReaderWebService {
    @Autowired
    ReaderRepository readerRepository;
    @GetMapping("reader")
    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    @GetMapping("reader/{id}")
    public Reader findById(@PathVariable int id) {
        return readerRepository.findById(id);
    }

    @PostMapping("reader")
    public void save(@RequestBody Reader reader) {
        readerRepository.save(reader);
    }

    @PutMapping("reader/{fname}")
    public void update(@RequestBody Reader reader,@PathVariable String fname){
       readerRepository.update(reader,fname);
    }
    @DeleteMapping("reader/{fname}")
    public void delete (@PathVariable String fname ){
       readerRepository.delete(fname);

    }
}
