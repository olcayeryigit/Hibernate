package com.hibernate.manytomany;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student08 {

    @Id
    private int id;

    private String name;

    @ManyToMany(mappedBy = "listStudent")
    private List<Teacher08>listTeacher=new ArrayList<>();

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

    public List<Teacher08> getListTeacher() {
        return listTeacher;
    }

    public void setListTeacher(List<Teacher08> listTeacher) {
        this.listTeacher = listTeacher;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
