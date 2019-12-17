package com.example.utm.Authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class AuthorsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Authors> findAll() {
        return jdbcTemplate.query(
                "SELECT *FROM Authors",
                (reponse, rowNumber) ->
                        new Authors(reponse.getInt("id"),
                                reponse.getString("fname"),
                                reponse.getString("lname"),
                                reponse.getString("gender"),
                                reponse.getString("nationality"),
                                 reponse.getInt("yearOfBirth")));
    }

    public void save(Authors authors) {
        jdbcTemplate.update(
                "INSERT INTO Authors(id,fname,lname,gender,nationality,yearOfBirth)" +
                        "VALUES (?,?,?,?,?,?)",
                authors.getId(),authors.getFname(),authors.getLname(),authors.getGender(),authors.getNatuonality(),authors.getYearOfBirth());
    }

    public void delete(String lname) {
        jdbcTemplate.update("DELETE FROM Authors WHERE lname=?", lname);
    }

    public void update(Authors authors, String Lname) {
        jdbcTemplate.update(
                "UPDATE Authors\n" +
                        "SET fname =?, lname=?,gender=?,nationality=?,yearOfBith=?" +
                        "WHERE lname=?",
                authors.getFname(),authors.getLname(),authors.getGender(),authors.getNatuonality(),
                authors.getYearOfBirth(), Lname);
    }
    public Authors findById(int id) {
        String sql = "SELECT *FROM Authors WHERE id = ?;";
        Object[] inputs = new Object[]{id};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) -> new Authors(reponse.getInt("id"),
                        reponse.getString("fname"),
                        reponse.getString("lname"),
                        reponse.getString("gender"),
                        reponse.getString("nationality"),
                        reponse.getInt("yearOfBirth")));
    }
}
