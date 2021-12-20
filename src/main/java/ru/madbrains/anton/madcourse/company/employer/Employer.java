package ru.madbrains.anton.madcourse.company.employer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.madbrains.anton.madcourse.company.ITCompany;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employer")
@Inheritance(strategy = InheritanceType.JOINED) //стратегия наследования
public class Employer<T> implements Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private T role;


    public Employer(String name, int age, T role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ITCompany getCompany() {
        return company;
    }

    public void setCompany(ITCompany company) {
        this.company = company;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private ITCompany company;

//    public void work(){
//        System.out.println(this.name + " is working");
//    }


    public Employer() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public T getRole() {
        return this.role;
    }

    public void setRole(T role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer<?> employer = (Employer<?>) o;
        return age == employer.age && Objects.equals(name, employer.name) && Objects.equals(role, employer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, role);
    }

}
