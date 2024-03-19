package com.example.demo.subject;

import com.example.demo.student.Student;
import jakarta.persistence.*;

//import java.time.LocalDate;
//import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Subject {

    @Id
//    @SequenceGenerator(
//            name = "subject_sequence",
//            sequenceName = "subject_sequence",
//            allocationSize = 1
//    )
    Long id;
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
//            generator = "subject_sequence"
    )

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    private String name;

    public Subject() {
    }

    public Subject(Long id,
                   String name) {
        this.id = id;
        this.name = name;
    }

    public Subject(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }



    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
}
