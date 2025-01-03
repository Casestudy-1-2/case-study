package model;

import java.util.Objects;

public class Customer extends Person {
    private int age;
    private String email;
    private Integer idClass;

    public Customer(int id, String name, String phone) {
        super(id, name, phone);
    }

    public Customer(String name, String phone) {
        super(name, phone);
    }

    public Customer(int id, String name, String phone, int age, String email, Integer idClass) {
        super(id, name, phone);
        this.age = age;
        this.email = email;
        this.idClass = idClass;
    }

    public Customer(String name, String phone, int age, String email, Integer idClass) {
        super(name, phone);
        this.age = age;
        this.email = email;
        this.idClass = idClass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(email, customer.email) && Objects.equals(idClass, customer.idClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, email, idClass);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "age=" + age +
                ", email='" + email + '\'' +
                ", idClass=" + idClass +
                '}';
    }
}
