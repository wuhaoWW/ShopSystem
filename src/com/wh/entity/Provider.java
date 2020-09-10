package com.wh.entity;

public class Provider {
    private  int id;
    private  String supname;
    private  String supnotice;
    private String name;
    private  long suptel;
    private  String supaddress;
    private  String email;
    public Provider(){

    }

    public Provider(String supname, String supnotice, String name, long suptel, String supaddress, String email) {
        this.supname = supname;
        this.supnotice = supnotice;
        this.name = name;
        this.suptel = suptel;
        this.supaddress = supaddress;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", supname='" + supname + '\'' +
                ", supnotice='" + supnotice + '\'' +
                ", name='" + name + '\'' +
                ", suptel=" + suptel +
                ", supaddress='" + supaddress + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getSupnotice() {
        return supnotice;
    }

    public void setSupnotice(String supnotice) {
        this.supnotice = supnotice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSuptel() {
        return suptel;
    }

    public void setSuptel(long suptel) {
        this.suptel = suptel;
    }

    public String getSupaddress() {
        return supaddress;
    }

    public void setSupaddress(String supaddress) {
        this.supaddress = supaddress;
    }

    public Provider(int id, String supname, String supnotice, String name, long suptel, String supaddress) {
        this.id = id;
        this.supname = supname;
        this.supnotice = supnotice;
        this.name = name;
        this.suptel = suptel;
        this.supaddress = supaddress;
    }
}
