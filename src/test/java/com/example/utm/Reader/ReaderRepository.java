package com.example.utm.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReaderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Reader> findAll() {
        return jdbcTemplate.query(
                "SELECT *FROM Reader",
                (reponse, rowNumber) ->
                        new Reader(reponse.getInt("id"),
                                reponse.getString("fname"),
                                reponse.getString("lname"),
                                reponse.getString("gender"),
                                reponse.getInt("age")));
    }
    public void save(Reader reader) {
        jdbcTemplate.update(
                "INSERT INTO Reader(id,fname,lname,gender,age)" +
                        "VALUES (?,?,?,?,?)",
               reader.getId(),reader.getFname(),reader.getLname(),reader.getGender(),reader.getAge());
    }

    public void delete(String lname) {
        jdbcTemplate.update("DELETE FROM Reader WHERE lname=?", lname);
    }
    public void update(Reader reader, String Lname) {
        jdbcTemplate.update(
                "UPDATE Reader\n" +
                        "SET fname =?, lname=?,gender=?,age=?"+
                        "WHERE lname=?",
                reader.getFname(),reader.getLname(),reader.getGender(),reader.getAge(), Lname);
    }
    public Reader findById(int id) {
        String sql = "SELECT *FROM Reader WHERE id = ?;";
        Object[] inputs = new Object[]{id};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) -> new Reader(reponse.getInt("id"),
                        reponse.getString("fname"),
                        reponse.getString("lname"),
                        reponse.getString("gender"),
                        reponse.getInt("age")));
    }
}
