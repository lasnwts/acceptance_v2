package ru.uralsib.acceptance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Сотрудники, с ФИО, адресами и ЗП")
public class Customer {

    @ApiModelProperty(notes = "id контакта, цлочеслиенный идентификатор")
    private int id;
    @ApiModelProperty(notes = "uuid контакта, строковый идентификатор")
    private String uuid4;
    @ApiModelProperty(notes = "Имя")
    private String first_name;
    @ApiModelProperty(notes = "Фамилия")
    private String last_name;
    @ApiModelProperty(notes = "Адрес")
    private String address;
    @ApiModelProperty(notes = "Должность")
    private String job;
    @ApiModelProperty(notes = "Строковое наименование валюты, ЗП")
    private String currency_name;
    @ApiModelProperty(notes = "Установленая заработная плата")
    private int salary;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", uuid4='" + uuid4 + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", currency_name='" + currency_name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Customer(int id, String uuid4, String first_name, String last_name, String address, String job, String currency_name, int salary) {
        this.id = id;
        this.uuid4 = uuid4;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.job = job;
        this.currency_name = currency_name;
        this.salary = salary;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getIdStr() {
        return Integer.toString(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid4() {
        return uuid4;
    }

    public void setUuid4(String uuid4) {
        this.uuid4 = uuid4;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
