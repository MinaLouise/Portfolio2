package com.example.demo.subject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public void addNewSubject(Subject subject) {
        Optional<Subject> subjectByEmail = subjectRepository
                .findStudentByName(subject.getName());
        if (subjectByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
//        System.out.println(student);
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long subjectId) {
        boolean exists = subjectRepository.existsById(subjectId);
        if (!exists){
            throw new IllegalStateException(
                    "student with id "+subjectId+" does not exist");
        }
        subjectRepository.deleteById(subjectId);
    }

    @Transactional
    public void updateSubject(Long subjectId,
                              String name) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id "+subjectId+" does not exist"));
        if (name != null &&
        !Objects.equals(subject.getName(), name)){
            subject.setName(name);
        }
    }
}