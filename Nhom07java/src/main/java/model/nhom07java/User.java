/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nhom07java;

/**
 *
 * @author tlkhanh
 */
public class User {
        public String username, password, pe, pei;

    public String getPei() {
        return pei;
    }

    public void setPei(String pei) {
        this.pei = pei;
    }
        public User(String u, String p, String pe, String pei) {
            this.username = u;
            this.password = p;
            this.pe = pe;            this.pei = pei;

        }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }
    }