package com.wh.entity;

import java.util.Date;

public class Check {
    private  int id ;
    private  String name;
    private long number;
    private double money;
    private  String paymoney;
    private  String supname;
    private  String notice;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(String paymoney) {
        this.paymoney = paymoney;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Check(int id, String name, long number, double money, String paymoney, String supname, String notice, String date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.money = money;
        this.paymoney = paymoney;
        this.supname = supname;
        this.notice = notice;
        this.date = date;
    }
    public  Check(){

    }

    public Check(String name, long number, double money, String paymoney, String supname, String notice, String date) {
        this.name = name;
        this.number = number;
        this.money = money;
        this.paymoney = paymoney;
        this.supname = supname;
        this.notice = notice;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", money='" + money + '\'' +
                ", paymoney='" + paymoney + '\'' +
                ", supname='" + supname + '\'' +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }
}
