package com.hibernate.annotations;

import javax.persistence.*;

@Entity
@Table(name = "t_student01")
public class Student01 {

    @Id
    @Column(name = "std_id")
    private int id;
    @Column(name = "std_name", length = 40, nullable = false, unique = false)
    private String name;
    private int grade;

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Students01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
