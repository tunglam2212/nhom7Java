/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nhom07java;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CBGV extends Nguoi{
    public float luongthuclinh,luongcung,thuong,phat;

    public CBGV() {
    }  
    public CBGV( int ID, String name, String dob, String address,Float luongcung, Float thuong,Float phat,Float luongthuclinh  ) {
        this.name = name;
        this.address = address;
        this.ID = ID;
        this.dob = dob;
        this.luongcung=luongcung;
        this.thuong=thuong;
        this.phat=phat;
        this.luongthuclinh=luongcung+thuong-phat;
    }
     public CBGV(String name, String dob, String address,Float luongcung, Float thuong,Float phat,Float luongthuclinh  ) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.luongcung=luongcung;
        this.thuong=thuong;
        this.phat=phat;
        this.luongthuclinh=luongcung+thuong-phat;
    }
  

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public float getLuongthuclinh() {
        return luongthuclinh;
    }

    public void setLuongthuclinh(float luongthuclinh) {
        this.luongthuclinh = luongthuclinh;
    }

    public float getLuongcung() {
        return luongcung;
    }

    public void setLuongcung(float luongcung) {
        this.luongcung = luongcung;
    }

    public float getThuong() {
        return thuong;
    }

    public void setThuong(float thuong) {
        this.thuong = thuong;
    }

    public float getPhat() {
        return phat;
    }

    public void setPhat(float phat) {
        this.phat = phat;
    }
    
  }