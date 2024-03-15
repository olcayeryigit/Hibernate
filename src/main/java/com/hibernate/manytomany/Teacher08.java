package com.hibernate.manytomany;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Teacher08 {

    @Id
    private int id;

    private String name;
    private String branch;

    @ManyToMany
    @JoinTable(
            name = "teacher08_student08",
            joinColumns ={@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name ="student_id" )}
    )
    private List<Student08> listStudent=new ArrayList<>();

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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Student08> getListtStudent() {
        return listStudent;
    }

    public void setListtStudent(List<Student08> listtStudent) {
        this.listStudent = listtStudent;
    }

    @Override
    public String toString() {
        return "Teacher08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", listStudent=" + listStudent +
                '}';
    }
}
