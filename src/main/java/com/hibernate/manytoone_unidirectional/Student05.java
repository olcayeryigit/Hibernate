package com.hibernate.manytoone_unidirectional;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Student05 {

    @Id
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private LocalDateTime createOn; //create edilme tarih ve saat bilgisi

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @PrePersist
    public void prePersistCreateOn() {
        createOn = LocalDateTime.now();
    }

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

    public LocalDateTime getCreateOn() {
        return createOn;
    }


    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
