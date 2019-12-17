package com.example.utm.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooksRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Books> findAll() {
        return jdbcTemplate.query(
                "SELECT *FROM Books",
                (reponse, rowNumber) ->
                        new Books(reponse.getInt("id"),
                                reponse.getString("title"),
                                reponse.getString("author"),
                                reponse.getInt("nrPages")));
    }


    public void save (Books books){
        jdbcTemplate.update(
                "INSERT INTO Books(id,title,author,nrPages) " +
                        "VALUES (?,?,?,?)",
                books.getId(),books.getTitle(),books.getAuthor(),books.getNrPages());
    }

    public void delete(String title){
        jdbcTemplate.update("DELETE FROM Books WHERE title=?",title);
    }

    public void update(Books books, String title){
        jdbcTemplate.update(
                "UPDATE Books \n"+
                        "SET title =?, author=?,nrPages=?"+
                        "WHERE title=?",
               books.getTitle(), books.getAuthor(),books.getNrPages(),title);
    }

    public Books findById(int id) {
        String sql = "SELECT *FROM Books WHERE id = ?;";
        Object[] inputs = new Object[] {id};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) ->new Books(reponse.getInt("id"),
                        reponse.getString("title"),
                        reponse.getString("author"),
                        reponse.getInt("nrPages")));
    }
}