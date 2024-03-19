package com.example.demo.subject;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/student")
public class SubjectController {


    private StudentRepository studentRepository;

    private SubjectRepository subjectRepository;

    private  SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjects(){

        return subjectService.getSubjects();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Subject subject){
        subjectService.addNewSubject(subject);
    }

    @DeleteMapping(path = "{subjectId}")
    public void deleteSubject(@PathVariable("subjectId") Long subjectId){
        subjectService.deleteSubject(subjectId);
    }

    @PutMapping(path = "{subjectId}")
    public void updateSubject(
            @PathVariable("subjectId") Long subjectId,
            @RequestParam(required = false) String name){
        subjectService.updateSubject(subjectId, name);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrolledStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ){
        Subject subject = subjectRepository.getOne(subjectId);
        Student student = studentRepository.getOne(studentId);
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
