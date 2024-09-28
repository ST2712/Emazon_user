package com.bootcamp_2024_2.emazon.domain.model;

import java.time.LocalDate;
import java.util.List;

public class User {

    private Long id;
    private String name;
    private String lastName;
    private int identification;
    private String phone;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Long roleId;
    private List<Long> shoppingCarIds;

    public User(Long id, String name, String lastName, int identification, String phone, LocalDate dateOfBirth,
                String email, String password, Long roleId, List<Long> shoppingCarIds) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.shoppingCarIds = shoppingCarIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getShoppingCarIds() {
        return shoppingCarIds;
    }

    public void setShoppingCarIds(List<Long> shoppingCarIds) {
        this.shoppingCarIds = shoppingCarIds;
    }
}
