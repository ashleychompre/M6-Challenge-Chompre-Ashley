package com.company.customerdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
@Table(name="customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String first_name;
    @NotNull
    private String last_name;
    @NotNull
    private String email;
    private String company;

    private String phone;
    @NotNull
    private String address1;
    private String address2;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @PositiveOrZero
    private Integer postal_code;
    @NotNull
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(Integer postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getFirst_name(), customer.getFirst_name()) &&
                Objects.equals(getLast_name(), customer.getLast_name()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getCompany(), customer.getCompany()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getCity(), customer.getCity()) &&
                Objects.equals(getAddress1(), customer.getAddress1()) &&
                Objects.equals(getAddress2(), customer.getAddress2()) &&
                Objects.equals(getPostalCode(), customer.getPostalCode()) &&
                Objects.equals(getCountry(), customer.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirst_name(), getLast_name(), getEmail(), getCompany(), getPhone(), getCity(), getAddress1(), getAddress2(), getPostalCode(), getCountry());
    }
}
