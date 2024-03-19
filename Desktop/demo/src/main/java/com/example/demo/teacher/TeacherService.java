package com.example.demo.teacher;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher student) {
        Optional<Teacher> studentByEmail = teacherRepository
                .findTeacherByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
//        System.out.println(student);
        teacherRepository.save(student);
    }

    public void deleteStudent(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);
        if (!exists){
            throw new IllegalStateException(
                    "student with id "+teacherId+" does not exist");
        }
        teacherRepository.deleteById(teacherId);
    }

    @Transactional
    public void updateTeacher(Long teacherId,
                              String name,
                              String email) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id "+teacherId+" does not exist"));
        if (name != null &&
        !Objects.equals(teacher.getName(), name)){
            teacher.setName(name);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(teacher.getEmail(), email)){
            Optional<Teacher> teacherOptional = teacherRepository
                    .findTeacherByEmail(email);
            if (teacherOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            teacher.setEmail(email);

        }
    }
}