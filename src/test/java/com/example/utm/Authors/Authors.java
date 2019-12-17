package com.example.utm.Authors;

public class Authors {
    private int id;
    private String fname;
    private String lname;
    private String gender;
    private String natuonality;
    private int yearOfBirth;

    public Authors(int id, String fname, String lname, String gender, String natuonality, int yearOfBirth) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.natuonality = natuonality;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNatuonality() {
        return natuonality;
    }

    public void setNatuonality(String natuonality) {
        this.natuonality = natuonality;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
